package com.ytt.springcoredemo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:06 2019/7/24
 * @Modiflid By:
 */
@Data
@Builder
public class Jeep implements InitializingBean, DisposableBean {
    public Jeep() {
        System.out.println("Jeep Constructor...");
    }

    /**
     * 按以下书写顺序执行初始化和销毁
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("Jeep...PostConstruct...");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Jeep...afterPropertiesSet...");
    }

    public void init(){
        System.out.println("Jeep...init...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Jeep...PreDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Jeep...destroy...");
    }

    public void beanDestory(){
        System.out.println("Jeep...bean.destory...");
    }

}
