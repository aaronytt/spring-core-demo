package com.ytt.springcoredemo.service.annotation;

import com.ytt.springcoredemo.service.impl.base.DaoBaseServiceImpl;

public @interface Crud {
    Class<?>[] classes() default {DaoBaseServiceImpl.class};
}
