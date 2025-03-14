## SpringBoot-init

> 用于自己快速开发springboot2类型的后端，自带简单角色CURD

技术使用及版本：

（1）SpringBoot2.7.6

（2）Knife4j 3.0.3（Swagger2）

（3）AOP

（4）Mybatis-Plus3.5.1

功能：

（1）AuthCheck注解, 校验用户角色

（2）统一返回对象BaseResponse、返回工具ResultUtils

（3）分页数据PageRequest

（4）全局跨域CorsConfig

（5）接口API说明Knife4jConfig

（6）权限AOP（AuthInterceptor）、请求响应日志AOP（LogInterceptor）

---

后端使用AuthCheck示例

```java
@AuthCheck(mustRole = "admin")
@GetMapping("/get")
public BaseResponse<UserVO> getUserById(int id, HttpServletRequest request) {
    if (id <= 0) {
        throw new BusinessException(ErrorCode.PARAMS_ERROR);
    }
    User user = userService.getById(id);
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(user, userVO);
    return ResultUtils.success(userVO);
}
```

说明：AuthCheck会去拿到当前用户登录态，通过登录态获取用户角色；如果有admin字段，则有权限使用该接口。如果没有admin字段，则无权限使用该接口。

---

前端请求API示例

> 登录接口：`/api/user/login`
>
> 接口类型：POST

请求参数体

```json
{
  "userAccount": "",
  "userPassword": ""
}
```

```js
import axios from 'axios'

// 创建独立axios实例
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // 从环境变量读取基础地址
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json;charset=UTF-8'
  }
})

service.post('/api/user/login', this.loginForm)
  .then(response => {
    // 处理标准响应结构（{ code: 0, data: {}, message: 'success' }）
    if (response.data.code === 0) {
      // 跳转到首页
      this.$router.push({ path: '/' })
    } else {
      this.$message.error(response.data.message || '登录失败')
    }
  })
  .catch(error => {
    // 统一错误处理
    if (error.response) {
      // HTTP状态码非2xx
      switch (error.response.status) {
        case 40000:
          this.$message.error('身份验证失败')
          break
        case 50000:
          this.$message.error('服务器内部错误')
          break
        default:
          this.$message.error(`请求错误: ${error.message}`)
      }
    } else {
      // 请求未发出（如网络问题）
      this.$message.error('网络连接异常，请检查后重试')
    }
  })
  .finally(() => {
    this.loading = false
  })
})
```

| 错误码 | 描述           |
| ------ | -------------- |
| 0      | ok             |
| 40000  | 请求参数错误   |
| 40100  | 未登录         |
| 40101  | 无权限         |
| 40400  | 请求数据不存在 |
| 40300  | 禁止访问       |
| 50000  | 系统内部异常   |
| 50001  | 操作失败       |

