package com.ytt.springcoredemo.context.annotation.config.confition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:02 2019/7/23
 * @Modiflid By:
 */
public class WindowsCondition implements Condition {
    /**
     *
     * @param context 判断条件可以使用的上下文（环境）
     * @param metadata 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //获取到IOC容器正在使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取当前到系统环境（win linux）
        Environment environment = context.getEnvironment();
        String os_name = environment.getProperty("os.name");
        System.out.println("os.name: " + os_name);

        if(os_name.contains("Windows")){
            return true;
        }
        return false;
    }
}
