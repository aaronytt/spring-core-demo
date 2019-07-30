//package com.ytt.springcoredemo.aop.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Component
//public class CarAspectClass {
//
//    @Pointcut("execution(public * com.ytt.springcoredemo.model.Car.*(..))")
//    public void drive(){
//    }
//
//
//    /***
//     * 執行結果：
//     *
//     * IOC容器创建完成...
//     *
//     * Around before...
//     * Before...... args:[666]
//     * car: 666 drive.....
//     * Around after...
//     * After......
//     * AfterReturning...... result:OK
//     * OK
//     *****************************************************
//     * IOC容器创建完成...
//     * Around before...
//     * Before...... args:[null]
//     * After......
//     * AfterThrowing...... java.lang.NullPointerException
//     *
//     * ****************************************************
//     */
//    @Before("drive()")
//    public void logStart(JoinPoint joinPoint){
//        System.out.println("Before...... args:" + Arrays.asList(joinPoint.getArgs()));
//    }
//
//    @After("drive()")
//    public void logEnd(JoinPoint joinPoint){
//        System.out.println("After......");
//    }
//
//    @AfterReturning(value = "drive()",returning = "result")
//    public void logReturn(Object result){
//        System.out.println("AfterReturning...... result:" + result);
//    }
//
//    @AfterThrowing(value = "drive()", throwing = "e")
//    public void logException(Exception e){
//        System.out.println("AfterThrowing...... " + e);
//    }
//
//    @Around("drive()")
//    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Around before...");
//        Object proceed = proceedingJoinPoint.proceed();
//        System.out.println("Around after...");
//        return proceed;
//    }
//
//    /**
//     * 异常信息
//     *
//     * Exception in thread "restartedMain" java.lang.reflect.InvocationTargetException
//     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//     * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//     * 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
//     * 	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49)
//     * Caused by: java.lang.NullPointerException
//     * 	at com.ytt.spring.aop.model.Car.drive(Car.java:18)
//     * 	at com.ytt.spring.aop.model.Car$$FastClassBySpringCGLIB$$10300244.invoke(<generated>)
//     * 	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
//     * 	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:749)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
//     * 	at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:56)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88)
//     * 	at com.ytt.spring.aop.aspect.CarAspectClass.logAround(CarAspectClass.java:57)
//     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//     * 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//     * 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//     * 	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
//     * 	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)
//     * 	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)
//     * 	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.aspectj.AspectJAfterAdvice.invoke(AspectJAfterAdvice.java:47)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor.invoke(AfterReturningAdviceInterceptor.java:55)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:93)
//     * 	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
//     * 	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)
//     * 	at com.ytt.spring.aop.model.Car$$EnhancerBySpringCGLIB$$195ecf9.drive(<generated>)
//     * 	at com.ytt.spring.aop.SpringAopDemoApplication.main(SpringTransactionDemoApplication.java:29)
//     */
//
//}
