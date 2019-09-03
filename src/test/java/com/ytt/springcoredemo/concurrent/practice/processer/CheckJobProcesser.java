package com.ytt.springcoredemo.concurrent.practice.processer;

import com.ytt.springcoredemo.concurrent.practice.job.JobPool;

import java.util.concurrent.DelayQueue;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:14 2019/8/30
 * @Modiflid By:
 */
public class CheckJobProcesser {
    private static DelayQueue<ItemVo<String>> queue = new DelayQueue<ItemVo<String>>();

    //单例模式
    private CheckJobProcesser(){}
    private static class CheckJobProcesserHolder{
        public static final CheckJobProcesser CHECK_JOB_PROCESSER = new CheckJobProcesser();
    }
    public static CheckJobProcesser getInstance(){
        return CheckJobProcesserHolder.CHECK_JOB_PROCESSER;
    }

    private static class FetchJob implements Runnable{
        @Override
        public void run() {
            for (;;){
                ItemVo<String> item = null;
                try {
                    item = queue.take();
                    String jobName = item.getData();
                    System.out.println(JobPool.getPoolInstance().getJobProgress(jobName));
                    JobPool.getMap().remove(jobName);
                    System.out.println(jobName + " is out of date ,and removed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void putJob(String jobName, long expireTime){
        ItemVo<String> item = new ItemVo<>(jobName, expireTime);
        queue.offer(item);
        System.out.println("Job[" + jobName + "] 已经放入过期检查，过期时长:" + expireTime);
    }

    static {
        Thread thread = new Thread(new FetchJob());
        thread.setDaemon(true);
        thread.start();
        System.out.println("开始任务过期检查守护线程......");
    }

}
