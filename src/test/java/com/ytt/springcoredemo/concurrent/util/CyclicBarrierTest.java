package com.ytt.springcoredemo.concurrent.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:38 2019/8/19
 * @Modiflid By:
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(8);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }).start();
        }

        Thread.currentThread().sleep(1);
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(1000);
    }

}
