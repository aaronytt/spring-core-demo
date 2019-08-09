package com.ytt.springcoredemo.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:54 2019/7/23
 * @Modiflid By:
 */
@Data
@Builder
public class Person implements Serializable {

    private String name;
    private int age;

}
