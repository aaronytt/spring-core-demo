package com.ytt.springcoredemo.log;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:04 2019/4/22
 * @Modiflid By:
 */
public enum  LogEnum {

    BUSSINESS("bussiness"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),
            ;

    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
