package com.ytt.springcoredemo.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:59 2019/8/20
 * @Modiflid By:
 */
public class UseLock {
    private final static Lock LOCK = new ReentrantLock();

    private final static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LOCK.lock();
//                try {
//                    System.out.println(Thread.currentThread().getName() + ": " + count.incrementAndGet());
//                    Thread.currentThread().sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    LOCK.unlock();
//                }
//            }).start();
//        }
//        System.out.println(Thread.currentThread().getName());

        new Thread(() -> {
            System.out.println(new UseLock().loop());
        }).start();

        System.out.println(Thread.currentThread().getName());
    }

    public synchronized int loop(){
        System.out.println(">>" + count.get());
        count.incrementAndGet();
        if(count.get() == 5){
            return count.get();
        }
        return loop();
    }

}
