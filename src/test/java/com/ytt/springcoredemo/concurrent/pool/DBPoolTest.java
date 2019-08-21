package com.ytt.springcoredemo.concurrent.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:46 2019/8/16
 * @Modiflid By:
 */
public class DBPoolTest {

    private static final DBPool POOL = new DBPool(50);

    private static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;

        end = new CountDownLatch(threadCount);

        final int count = 1;

        final AtomicInteger got = new AtomicInteger();
        final AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++){

            new Thread(() -> {

                for (int j = 0; j < count; j++) {
                    try {
                        Connection connection = POOL.fetchConnection(100);

                        if(connection != null){
                            try {
                                connection.createStatement();
                                connection.commit();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }finally {
                                POOL.releaseConnection(Optional.ofNullable(connection));
                                got.incrementAndGet();
                            }
                        }else {
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
