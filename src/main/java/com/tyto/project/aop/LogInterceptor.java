package com.tyto.project.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 请求响应日志 AOP
 */
@Aspect
@Component
@Slf4j
public class LogInterceptor {

    /**
     * 执行请求拦截
     */
    @Around("execution(* com.tyto.project.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint point)
            throws Throwable {
        // 计时
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 获取请求路径
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 生成请求唯一ID
        String requestId = UUID.randomUUID().toString();
        String url = request.getRequestURI();
        // 获取请求参数
        Object[] args = point.getArgs();
        String requestParams = "[" + StringUtils.join(args, ", ") + "]";
        // 输出请求日志
        log.info("request start, id: {}, path: {}, ip: {}, params: {}",
                requestId, url, request.getRemoteAddr(), requestParams);
        // 执行原方法
        Object result = point.proceed();
        // 输出相应日志
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        log.info("request end, id: {}, cost: {}ms",
                requestId, totalTimeMillis);
        return result;
    }
}
