package com.ytt.springcoredemo.concurrent.practice.concurrent_framework.job;

import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.processer.CheckJobProcesser;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.processer.TaskProcesser;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.task.TaskResult;
import com.ytt.springcoredemo.concurrent.practice.concurrent_framework.task.TaskResultType;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:44 2019/8/29
 * @Modiflid By:
 */
public class Job<R> {

    //区分工作
    private final String name;
    //任务个数
    private final int jobLength;
    //任务处理器
    private final TaskProcesser<?,?> taskProcesser;

    private AtomicInteger successTaskCount;
    private AtomicInteger taskProcesserCount;

    //任务结果队列
    private LinkedBlockingDeque<TaskResult<R>> taskResultDeque;

    private final long expireTime;

    public Job(String name, int jobLength, TaskProcesser<?, ?> taskProcesser,long expireTime) {
        this.name = name;
        this.jobLength = jobLength;
        this.taskProcesser = taskProcesser;
        this.successTaskCount = new AtomicInteger(0);
        this.taskProcesserCount = new AtomicInteger(0);
        this.taskResultDeque = new LinkedBlockingDeque<TaskResult<R>>(jobLength);
        this.expireTime = expireTime;
    }

    /**
     *
     * @return
     */
    public List<TaskResult<R>> getTaskDetail(){
        return taskResultDeque.stream().filter(taskResult -> taskResult != null).collect(
                Collector.of(
                        (Supplier<List<TaskResult<R>>>) LinkedList::new,
                        List::add,
                        (left, right) -> {
                            left.addAll(right);
                            return left;
                        }
                )
        );
    }

    /**
     *
     * @param result
     */
    public void addTaskDetail(TaskResult<R> result, CheckJobProcesser checkJobProcesser){
        if(TaskResultType.SUCCESS.equals(result.getType())){
            successTaskCount.incrementAndGet();
        }
        taskResultDeque.addLast(result);
        taskProcesserCount.incrementAndGet();
        //job任务完成以后，执行过期时间
        if(taskProcesserCount.get() == jobLength){
            checkJobProcesser.putJob(name,expireTime);
        }
    }

    /**
     *
     * @return
     */
    public String getProgress(){
        return "Success[" + successTaskCount.get() + "], Current[" + taskProcesserCount.get() + "], Total[" + jobLength + "]";
    }

    public String getName() {
        return name;
    }

    public int getTaskCount() {
        return taskProcesserCount.get();
    }

    public int getSuccessTaskCount() {
        return successTaskCount.get();
    }

    public int getFailTaskCount(){
        return getTaskCount() - getSuccessTaskCount();
    }

    public TaskProcesser<?, ?> getTaskProcesser() {
        return taskProcesser;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
