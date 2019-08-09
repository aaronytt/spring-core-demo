package com.ytt.spring.context.annotation.config.selector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:50 2019/7/23
 * @Modiflid By:
 */
public class MyImportSelector implements ImportSelector {
    /**
     * Select and return the names of which class(es) should be imported based on
     * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
     * 根据导入@ {@link Configuration}类的{@link AnnotationMetadata}选择并返回应导入哪个类的名称。
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.ytt.springcoredemo.model.Monkey"};
        //不能为空
//        return null;
    }
}
