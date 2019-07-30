//package com.ytt.spring.springcore.aop;
//
//import com.ytt.spring.springcore.model.Car;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 15:18 2019/7/23
// * @Modiflid By:
// */
//@SpringBootApplication
//@EnableAspectJAutoProxy
//public class SpringAopDemoApplication implements ApplicationContextAware {
//
//    @Autowired
//    private static ApplicationContext applicationContext;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringAopDemoApplication.class);
//
//        System.out.println("IOC容器创建完成...");
//
//        Car car = (Car) applicationContext.getBean("car");
//        System.out.println(car.drive(null));
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if (SpringAopDemoApplication.applicationContext == null) {
//            SpringAopDemoApplication.applicationContext = applicationContext;
//        }
//    }
//}
