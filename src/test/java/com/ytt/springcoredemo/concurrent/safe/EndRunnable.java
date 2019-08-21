package com.ytt.springcoredemo.concurrent.safe;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:59 2019/8/15
 * @Modiflid By:
 */
public class EndRunnable implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(threadName + " run...");
        }
        System.out.println(threadName + " interrput: " + Thread.currentThread().isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new Thread(new EndRunnable(), "endRunnable");
        endThread.start();
        Thread.sleep(100);
        endThread.interrupt();
        System.out.println(".......");
    }

}
