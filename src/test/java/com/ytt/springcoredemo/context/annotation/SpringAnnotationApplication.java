package com.ytt.springcoredemo.context.annotation;

import com.ytt.spring.context.annotation.model.Bird;
import com.ytt.springcoredemo.SpringCoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:18 2019/7/23
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
@PropertySource(value = "classpath:My.properties")
public class SpringAnnotationApplication {
    /**
     * Autowired按照类型注入，可以注入空
     *
     * Resource默认按照类型，指定名字按照名字
     *
     * Inject 需要POM.XML额外引用javax.inject, 和Autowired差不多，支持@Primary，不支持required
     *
     */
    @Autowired
//    @Resource
//    @Inject
    Bird bird;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test(String[] args) {
        SpringApplication.run(SpringAnnotationApplication.class);

        System.out.println("IOC容器创建完成...");

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String name: beanNames) {
            System.out.println(name);
        }

//      @Value - test - start
//        System.out.println("-------------------");
//        Bird bird = (Bird) applicationContext.getBean("bird");
//        System.out.println(bird);
//
//        Environment environment = applicationContext.getEnvironment();
//        System.out.println("environment:  color= " + environment.getProperty("color"));
//      @Value - test - end

//       - test - start
        //org.springframework.beans.factory.NoUniqueBeanDefinitionException:
        //  No qualifying bean of type 'com.ytt.spring.context.annotation.model.Bird' available:
        //      expected single matching bean but found 2: bird,bird2
        System.out.println("-------------------");
        Bird bird1 = (Bird) applicationContext.getBean(Bird.class);
        System.out.println(bird1);

        System.out.println(this.bird);
//       - test - end

    }

}
