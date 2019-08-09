//package com.ytt.spring.context.annotation.config.beanPostProcesser;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 0:27 2019/7/24
// * @Modiflid By:
// */
//@Component
//public class MyBeanPostProcesser implements BeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization..."+ beanName + "..." + bean);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization..."+ beanName + "..." + bean);
//        return bean;
//    }
//}
