package com.ytt.springcoredemo.concurrent.safe.interrupted;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:59 2019/8/15
 * @Modiflid By:
 */
public class EndThread extends Thread {

    public EndThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String threadName = getName();
        while (!isInterrupted()){
            System.out.println(threadName + " run...");
        }
        System.out.println(threadName + " interrput: " + isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new EndThread("endThread");
        endThread.start();
        Thread.sleep(100);
        endThread.interrupt();
    }

}
