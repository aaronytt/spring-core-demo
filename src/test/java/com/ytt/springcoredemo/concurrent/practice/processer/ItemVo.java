package com.ytt.springcoredemo.concurrent.practice.processer;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:16 2019/8/30
 * @Modiflid By:
 */
public class ItemVo<T> implements Delayed {

    private T data;
    private long expireTime;

    public ItemVo(T data, long expireTime) {
        this.data = data;
        this.expireTime = expireTime;
    }

    //按照剩余时间排序
    @Override
    public int compareTo(Delayed o) {
        long d = getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
        return (d==0)?0:((d>0)?1:-1);
    }

    //返回元素的剩余时间
    @Override
    public long getDelay(TimeUnit unit) {
        long d = unit.convert(this.expireTime-System.nanoTime(),
                TimeUnit.NANOSECONDS);
        return d;
    }

    public T getData() {
        return data;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
