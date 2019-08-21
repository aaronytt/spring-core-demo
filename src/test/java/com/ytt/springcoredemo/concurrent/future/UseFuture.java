package com.ytt.springcoredemo.concurrent.future;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:51 2019/8/19
 * @Modiflid By:
 */
public class UseFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        if( new Random().nextInt(2) == 1 ){
            System.out.println(futureTask.get());
        }else {
            System.out.println(futureTask.cancel(true));
        }
        System.out.println(futureTask.isCancelled() + "--------------" + futureTask.isDone());
    }

}
