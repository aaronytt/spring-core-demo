package com.ytt.springcoredemo.concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:52 2019/8/19
 * @Modiflid By:
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int random = new Random().nextInt(1000);
        Thread.currentThread().sleep(5000+ random);
        return random;
    }

}
