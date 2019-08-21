package com.ytt.springcoredemo.concurrent.pool.semphore;

import com.ytt.springcoredemo.concurrent.pool.SqlConnectionImpl;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:26 2019/8/16
 * @Modiflid By:
 */
public class SemaphoreDBPool {

    private int poolSize;
    private static final int DEFULT_POOL_SIZE = 10;
    private static Queue<Connection> pool = new LinkedList<>();
    private final Semaphore useful,useless;

    public SemaphoreDBPool(int initalSize){
        this.useful = new Semaphore(initalSize);
        this.useless = new Semaphore(0);
        if(initalSize <= 0){
            initalSize = DEFULT_POOL_SIZE;
        }
        poolSize = initalSize;
        int i = initalSize;
        while (i> 0){
            pool.add(SqlConnectionImpl.getSqlConnection());
            i--;
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        useful.acquire();
        try {
            synchronized (pool){
                if(mills > 0) {
                    long overtime = System.currentTimeMillis() + mills;
                    long remain = mills;
                    while (pool.isEmpty() && remain > 0){
                        pool.wait(remain);
                        remain = overtime - System.currentTimeMillis();
                    }
                }
                return pool.poll();
            }
        } finally {
            useless.release();
        }
    }

    public void releaseConnection(Optional<Connection> connection) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName() + " >>> releaseConnection：前有" + useful.availablePermits() + "空闲的数据库连接...");
        useless.acquire();
        connection.ifPresent(c  -> {
            synchronized (pool){
                pool.add(c);
                pool.notifyAll();
            }
        });
        useful.release();
//        System.out.println(Thread.currentThread().getName() + " >>> releaseConnection：后有" + useful.getQueueLength() + "个线程等待数据库连接...");
    }

}
