package com.ytt.springcoredemo.concurrent;

import lombok.Builder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:38 2019/8/15
 * @Modiflid By:
 */
public class NewThread {

    @Builder
    private static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("myrun...");
        }
    }

    @Builder
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("myThread...");
            super.run();
        }
    }

    @Builder
    private static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("mycall...");
            return "mycall";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread myrun =  new Thread(MyRun.builder().build());
//        myrun.start();
//        myrun.interrupt();
//
//        FutureTask<String> futureTask = new FutureTask<>(MyCall.builder().build());
//        Thread myCall = new Thread(futureTask);
//        myCall.start();
//        System.out.println(futureTask.get());
        new NewThread().wn();

    }

    private void wn(){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                        this.wait();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        this.notifyAll();
        System.out.println(Thread.currentThread().getName());
    }

}
