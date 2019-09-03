package com.ytt.springcoredemo.concurrent.util;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:56 2019/8/30
 * @Modiflid By:
 */
public class SleepUtil {

    public static final void sleep(long l){
        try {
            Thread.currentThread().sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
