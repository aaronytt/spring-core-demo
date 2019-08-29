package com.ytt.springcoredemo.concurrent.pool.db;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:26 2019/8/16
 * @Modiflid By:
 */
public class DBPool {

    private static Queue<Connection> pool = new LinkedList<>();

    public DBPool(int initalSize){
        if(initalSize > 0){
            int i = initalSize;
            while (i> 0){
                pool.add(SqlConnectionImpl.getSqlConnection());
                i--;
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills < 0){
                if(pool.isEmpty()){
                    pool.wait();
                }
                return pool.poll();
            }else {
                long overtime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0){
                    pool.wait(remain);
                    remain = overtime - System.currentTimeMillis();
                }
                return pool.poll();
            }
        }
    }

    public void releaseConnection(Optional<Connection> connection){
            connection.ifPresent(c  -> {
                synchronized (pool){
                    if(pool.add(c)){
                        pool.notifyAll();
                    }
                }
            });
    }

}
