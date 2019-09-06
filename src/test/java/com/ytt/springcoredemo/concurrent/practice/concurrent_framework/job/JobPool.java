package com.ytt.springcoredemo.concurrent.practice.concurrent_framework.job;

import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.processer.CheckJobProcesser;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.processer.TaskProcesser;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.task.TaskResult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:28 2019/8/30
 * @Modiflid By:
 */
public class JobPool {

    //线程数，无法估计时，保守用机器核数
    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
    //任务队列
    private static BlockingQueue<Runnable> jobQueue = new ArrayBlockingQueue<>(5000);

    private static ExecutorService pool = new ThreadPoolExecutor(THREAD_COUNT,THREAD_COUNT,60, TimeUnit.SECONDS,jobQueue);

    private static ConcurrentHashMap<String,Job<?>> jobMap = new ConcurrentHashMap<>();

    private static CheckJobProcesser checkJobProcesser = CheckJobProcesser.getInstance();

    //单例
    private JobPool(){}
    private static class JobPoolHolder{
        public static JobPool POOL = new JobPool();
    }
    public static JobPool getPoolInstance(){
        return JobPoolHolder.POOL;
    }

    //注册Job
    public <T, R> void registerJob(String jobName, int jobLength, TaskProcesser<T, R> taskProcesser, long expireTime){
        Job<Integer> job = new Job<>(jobName, jobLength, taskProcesser, expireTime);
        if(jobMap.putIfAbsent(jobName,job) != null){
            throw new RuntimeException(job.getName() + "已经注册");
        }
    }

    //检索任务
    private <R> Job<R> getJob(String jobName) {
        Job<R> job = (Job<R>) jobMap.get(jobName);
        if(job == null){
            throw new RuntimeException(jobName + "未找到");
        }
        return job;
    }

    private static class PendingTask<T, R> implements Runnable {
        private Job<R> job;
        private T processData;

        public PendingTask(Job<R> job, T processData) {
            this.job = job;
            this.processData = processData;
        }

        @Override
        public void run() {
            TaskProcesser<T,R> taskProcesser = (TaskProcesser<T,R>) job.getTaskProcesser();
            //执行具体的任务结果
            TaskResult<R> result = null ;
            try {
                //执行具体的任务
                result = taskProcesser.execute(processData);
                //做检查
                if(result == null){
                    result = TaskResult.getFailure(null, "result is null");
                }

                if(result.getType() == null){
                    if(result.getReason().isBlank()){
                        if(result.getException() != null){
                            result = TaskResult.getException(null, "result is null,but reason: exception", result.getException());
                        }else {
                            result = TaskResult.getFailure(null, "result is null");
                        }
                    }else{
                        result = TaskResult.getFailure(null, "result is null,but reason: " + result.getReason());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = TaskResult.getException(null, "result is null,but reason: exception", e);
            } finally {
                job.addTaskDetail(result, checkJobProcesser);
            }
        }
    }

    //调用者提交任务
    public <T, R> void putTask(String jobName,T t){
        Job<R> job = getJob(jobName);
        PendingTask<T, R> task = new PendingTask<>(job, t);
        pool.execute(task);
    }

    public static Map<String,Job<?>> getMap(){
        return jobMap;
    }

    //获取Job任务详情
    public <R> List<TaskResult<R>> getJobTaskDatail(String jobName){
        return ((Job<R>)getJob(jobName)).getTaskDetail();
    }

    //获取Job任务进度
    public <R> String getJobProgress(String jobName){
        return ((Job<R>)getJob(jobName)).getProgress();
    }

}
