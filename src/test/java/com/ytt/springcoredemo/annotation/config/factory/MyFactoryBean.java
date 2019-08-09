package com.ytt.springcoredemo.annotation.config.factory;

import com.ytt.springcoredemo.model.Apple;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:53 2019/7/23
 * @Modiflid By:
 */
public class MyFactoryBean implements FactoryBean<Apple> {

    @Override
    public Apple getObject() throws Exception {
        return new Apple();
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
