package com.ytt.springcoredemo.config;

import com.ytt.springcoredemo.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:30 2019/9/10
 * @Modiflid By:
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.ytt.springcoredemo.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        //url
        String url = request.getRequestURL().toString();
        //method
        String method = request.getMethod();
        //ip
        String ip = request.getRemoteAddr();
        //类方法
        String class_method = StringUtil.combine(joinPoint.getSignature().getDeclaringTypeName(),
                ".",
                joinPoint.getSignature());
        //参数
        Object[] args = joinPoint.getArgs();

        log.info("[ url= {}, menthod= {}, ip= {}, class_method= {}, args= {} ]",url,method,ip,class_method,args);

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("[ return: {} ]",ret);
    }
}

