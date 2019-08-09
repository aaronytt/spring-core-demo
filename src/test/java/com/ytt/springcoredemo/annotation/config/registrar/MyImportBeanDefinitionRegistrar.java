package com.ytt.springcoredemo.annotation.config.registrar;

import com.ytt.springcoredemo.model.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:28 2019/7/23
 * @Modiflid By:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 自定义想要注入的bean
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDrfinition注册类
     *                 把所需要的bean添加到容器中
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b1 = registry.containsBeanDefinition("person");
        boolean b2 = registry.containsBeanDefinition("com.ytt.springcoredemo.model.Monkey");

        if(b1 && b2){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig",beanDefinition);
        }

    }
}
