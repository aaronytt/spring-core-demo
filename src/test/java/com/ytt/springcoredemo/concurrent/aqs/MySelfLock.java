package com.ytt.springcoredemo.concurrent.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author: aaron
 * @Descriotion: 实现独占锁
 * @Date: 19:56 2019/8/21
 * @Modiflid By:
 */
public class MySelfLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync SYNC = new Sync();

    @Override
    public void lock() {
        SYNC.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        SYNC.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return SYNC.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return SYNC.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        SYNC.release(1);
    }

    @Override
    public Condition newCondition() {
        return SYNC.newCondition();
    }
}
