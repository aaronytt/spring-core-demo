package com.ytt.springcoredemo.concurrent.pool.semphore;

import com.ytt.springcoredemo.concurrent.pool.DBPool;
import com.ytt.springcoredemo.concurrent.pool.SqlConnectionImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:26 2019/8/16
 * @Modiflid By:
 */
public class SemaphoreDBPoolTest {

    private static final SemaphoreDBPool POOL = new SemaphoreDBPool(10);

    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;

        end = new CountDownLatch(threadCount);

        final int count = 2;

        final AtomicInteger got = new AtomicInteger();
        final AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {

            new Thread(() -> {

                for (int j = 0; j < count; j++) {

                    try {
                        Connection connection = POOL.fetchConnection(0);

                        if (connection != null) {
                            Thread.currentThread().sleep(new Random().nextInt(1000));
                            POOL.releaseConnection(Optional.ofNullable(connection));
                            got.incrementAndGet();
                        } else {
                            notGot.incrementAndGet();
                            System.out.println(Thread.currentThread().getName() + ": " + j + " 获取连接失败");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                end.countDown();

            }).start();
        }
        end.await();
        System.out.println("一共尝试多少次：" + (threadCount * count));
        System.out.println("拿到连接的次数： " + got);
        System.out.println("没有拿到连接的次数： " + notGot);
    }

}
