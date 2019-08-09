package com.ytt.springcoredemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:54 2019/7/23
 * @Modiflid By:
 */
@Data
@Builder
//@Component
public class Book implements InitializingBean, DisposableBean {

    public Book() {
        System.out.println("Book...constructor...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book...afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Book...destroy...");
    }
}
