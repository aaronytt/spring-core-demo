package com.ytt.springcoredemo.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 12:17 2019/6/23
 * @Modiflid By:
 */
@Slf4j
public class PerformanceInteceptor implements HandlerInterceptor {

    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatchThreadLocal.set(stopWatch);
        stopWatch.start();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        stopWatchThreadLocal.get().stop();
        stopWatchThreadLocal.get().start();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StopWatch stopWatch = stopWatchThreadLocal.get();
        stopWatch.stop();
        String method = handler.getClass().getSimpleName();

        if(handler instanceof HandlerMethod){
            String beanType = ((HandlerMethod)handler).getBeanType().getName();
            String methodName = ((HandlerMethod)handler).getMethod().getName();
            method = new StringBuffer().append(beanType).append(".").append(methodName).toString();
        }

        log.info("{};{};{};{};{}ms;{}ms;{}ms",
                request.getRequestURI(),
                method,
                response.getStatus(),null==ex ? "_" : ex.getClass().getSimpleName(),
                stopWatch.getTotalTimeMillis(),
                stopWatch.getTotalTimeMillis() - stopWatch.getLastTaskTimeMillis(),
                stopWatch.getLastTaskTimeMillis()
                );
    }

}
