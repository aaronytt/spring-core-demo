package com.ytt.springcoredemo.concurrent.util;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:38 2019/8/19
 * @Modiflid By:
 */
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(8);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        countDownLatch.await();
        System.out.println(1000);
    }

}
