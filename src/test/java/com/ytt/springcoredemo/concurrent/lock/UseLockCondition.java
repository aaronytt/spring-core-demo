package com.ytt.springcoredemo.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:37 2019/8/21
 * @Modiflid By:
 */
public class UseLockCondition {

    private int km;
    private String city;

    private final Lock lock = new ReentrantLock();
    private final Condition kmCondition = lock.newCondition();
    private final Condition cityCondition = lock.newCondition();

    public UseLockCondition(int km, String city) {
        this.km = km;
        this.city = city;
    }

    public void changekm(int ckm){
        lock.lock();
        try {
            if (ckm != km){
                km = ckm;
                kmCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void changeCity(String ccity){
        lock.lock();
        try {
            if (!city.equals(ccity)){
                city = ccity;
                cityCondition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitKm(){
        lock.lock();
        try {
            while (true){
                try {
                    kmCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " km: " + km + " city: " + city);
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitCity(){
        lock.lock();
        try {
            while (true){
                try {
                    cityCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " city: " + city + " km: " + km);
            }
        } finally {
            lock.unlock();
        }
    }

    //km thread
    public static class KmThread extends Thread{

        private UseLockCondition useLockCondition;

        public KmThread(UseLockCondition useLockCondition) {
            this.useLockCondition = useLockCondition;
        }

        @Override
        public void run() {
            useLockCondition.waitKm();
        }
    }

    //city thread
    public static class CityThread extends Thread{

        private UseLockCondition useLockCondition;

        public CityThread(UseLockCondition useLockCondition) {
            this.useLockCondition = useLockCondition;
        }

        @Override
        public void run() {
            useLockCondition.waitCity();
        }
    }

    public static void main(String[] args) {

        UseLockCondition useLockCondition = new UseLockCondition(100,"beijing");

        for (int i = 0; i < 3; i++) {
            new CityThread(useLockCondition).start();
            new KmThread(useLockCondition).start();
        }

        useLockCondition.changeCity("上海");

    }


}
