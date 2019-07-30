//package com.ytt.spring.springcore.annotation;
//
//import com.ytt.spring.springcore.model.Bird;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 15:18 2019/7/23
// * @Modiflid By:
// */
//@SpringBootApplication
//@PropertySource(value = "classpath:My.properties")
//public class SpringContextDemoApplication implements ApplicationContextAware {
//    /**
//     * Autowired按照类型注入，可以注入空
//     *
//     * Resource默认按照类型，指定名字按照名字
//     *
//     * Inject 需要POM.XML额外引用javax.inject, 和Autowired差不多，支持@Primary，不支持required
//     *
//     */
//    @Autowired
////    @Resource
////    @Inject
//    static Bird BIRD;
//
//    @Autowired
//    private static ApplicationContext applicationContext;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringContextDemoApplication.class);
//
//        System.out.println("IOC容器创建完成...");
//
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//
//        for (String name: beanNames) {
//            System.out.println(name);
//        }
//
////      @Value - test - start
////        System.out.println("-------------------");
////        Bird bird = (Bird) applicationContext.getBean("bird");
////        System.out.println(bird);
////
////        Environment environment = applicationContext.getEnvironment();
////        System.out.println("environment:  color= " + environment.getProperty("color"));
////      @Value - test - end
//
////       - test - start
//        //org.springframework.beans.factory.NoUniqueBeanDefinitionException:
//        //  No qualifying bean of type 'com.ytt.spring.context.annotation.model.Bird' available:
//        //      expected single matching bean but found 2: bird,bird2
//        System.out.println("-------------------");
//        Bird bird = (Bird) applicationContext.getBean(Bird.class);
//        System.out.println(bird);
//
//        System.out.println(BIRD);
////       - test - end
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if(SpringContextDemoApplication.applicationContext == null) {
//            SpringContextDemoApplication.applicationContext = applicationContext;
//        }
//    }
//}
