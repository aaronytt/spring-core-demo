//package com.ytt.springcoredemo.model;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 15:55 2019/7/25
// * @Modiflid By:
// */
//@Data
//public class Bird {
//
//    public Bird() {
//        super();
//    }
//
//    @Value("sam")
//    private String name;
//    @Value("#{20-2}")
//    private Integer age;
//    @Value("${color}")
//    private String color;
//
//    public String drive(String name){
//        this.name = name;
//        System.out.println("car: " + this.name.toString() +" drive.....");
//        return "OK";
//    }
//
//}
