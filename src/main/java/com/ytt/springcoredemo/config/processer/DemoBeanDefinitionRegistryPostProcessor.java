package com.ytt.springcoredemo.config.processer;//package com.ytt.spring.springcore.config.processer;
//
//import com.ytt.springcoredemo.model.po.User;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.stereotype.Component;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 22:47 2019/7/28
// * @Modiflid By:
// */
//@Component
//public class DemoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("DemoBeanDefinitionRegistryPostProcesser ......调用BeanFactoryPostProcessor.postProcessBeanFactory");
//
//        //所有的bean的定义，已经加载到beanFactory,但是bean实例还没有创建
//        int count = beanFactory.getBeanDefinitionCount();
//        System.out.println("当前BeanFactory中定义" + count + "个Bean");
//    }
//
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        System.out.println("DemoBeanDefinitionRegistryPostProcesser ......调用postProcessBeanDefinitionRegistry");
//
//        //所有的bean的定义，已经加载到beanFactory,但是bean实例还没有创建
//        int count = registry.getBeanDefinitionCount();
//        System.out.println("当前BeanDefinitionRegistry中定义" + count + "个Bean");
//
//        registry.registerBeanDefinition("haha", BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition());
//    }
//
//}