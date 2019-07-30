package com.ytt.spring.springcore.config.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:47 2019/7/28
 * @Modiflid By:
 */
@Component
public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("DemoBeanFactoryPostProcesser ......调用BeanFactoryPostProcessor.postProcessBeanFactory");

        //所有的bean的定义，已经加载到beanFactory,但是bean实例还没有创建
        int count = beanFactory.getBeanDefinitionCount();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory中定义" + count + "个Bean");
        System.out.println(Stream.of(beanDefinitionNames).filter(s -> s.contains("Service")).collect(Collectors.toList()));
    }

}