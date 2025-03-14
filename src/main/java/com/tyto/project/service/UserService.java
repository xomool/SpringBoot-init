package com.tyto.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tyto.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户ID
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request 请求
     * @return 用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param request 请求
     * @return 登录用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param request 请求
     * @return 是/否
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 用户注销(登出)
     * @param request 请求
     * @return 注销结果
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 被新增用户id
     */
    long addUser(User user);

    /**
     * 更新用户
     * @param user 用户信息
     * @return 是否成功
     */
    boolean updateUser(User user);
}
