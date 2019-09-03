package com.ytt.springcoredemo.concurrent.practice.test;

import com.ytt.springcoredemo.concurrent.practice.job.Job;
import com.ytt.springcoredemo.concurrent.practice.job.JobPool;
import com.ytt.springcoredemo.concurrent.practice.task.TaskResult;
import com.ytt.springcoredemo.concurrent.util.SleepUtil;

import java.util.List;
import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 3:13 2019/8/30
 * @Modiflid By:
 */
public class TestPool {

    private final static String JOB_NAME = "计算Test";
    private final static int JOB_LENGTH = 1000;

    private static class QueryResult implements Runnable {

        private JobPool pool;

        public QueryResult(JobPool pool) {
            super();
            this.pool = pool;
        }

        @Override
        public void run() {
            for (int i = 0; i < 400; i++){
                List<TaskResult<String>> taskResults = pool.getJobTaskDatail(JOB_NAME);
                if(!taskResults.isEmpty()){
                    System.out.println(pool.getJobProgress(JOB_NAME) + "   " + i);
                    System.out.println(taskResults);
                }
                SleepUtil.sleep(100);
            }
        }
    }

    public static void main(String[] args) {
        TestTask testTask = new TestTask();
        JobPool pool = JobPool.getPoolInstance();
        pool.registerJob(JOB_NAME, JOB_LENGTH, testTask, 10);

        for (int i = 0; i < JOB_LENGTH; i++) {
            pool.putTask(JOB_NAME, new Random().nextInt(10000));
        }

        new Thread(new QueryResult(pool)).start();
    }

}
