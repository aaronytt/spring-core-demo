package com.ytt.springcoredemo.concurrent.safe.interrupted;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:59 2019/8/15
 * @Modiflid By:
 */
public class HasInterruptExceptionThread extends Thread {

    public HasInterruptExceptionThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        String threadName = getName();
        while (!isInterrupted()){
            try {
                Thread.sleep(1);
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrput>>: " + isInterrupted());
                e.printStackTrace();
                interrupt();
            }
            System.out.println(threadName + " run...");
        }
        System.out.println(threadName + " interrput: " + isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new HasInterruptExceptionThread("hasInterruptExceptionThread");
        endThread.start();
        Thread.sleep(1000);
//        endThread.interrupt();
    }

}
