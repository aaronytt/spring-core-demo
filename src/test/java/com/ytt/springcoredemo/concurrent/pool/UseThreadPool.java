package com.ytt.springcoredemo.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 14:53 2019/8/27
 * @Modiflid By:
 */
public class UseThreadPool {

    public static void main(String[] args) {
        ExecutorService es1 = Executors.newFixedThreadPool(0);
        ExecutorService es2 = Executors.newCachedThreadPool();
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        ExecutorService es4 = Executors.newWorkStealingPool();
        ExecutorService es5 = Executors.newScheduledThreadPool(0);

        es1.execute(() -> {});
    }

}
