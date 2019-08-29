package com.ytt.springcoredemo.concurrent.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 20:22 2019/8/21
 * @Modiflid By:
 */
public class MySelfLockTest {

    public static void main(String[] args) {

//        Lock lock = new MySelfLock();
        Lock lock = new ReentrantLock(true);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().sleep(500);
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }).start();

            if(i == 10){
                System.out.println("");
            }
        }

        try {
            Thread.currentThread().sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());

    }

}
