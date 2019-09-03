package com.ytt.springcoredemo.concurrent.practice.processer;

import com.ytt.springcoredemo.concurrent.practice.task.TaskResult;

/**
 * @Author: aaron
 * @Descriotion: 任务执行器
 * @Date: 23:29 2019/8/29
 * @Modiflid By:
 */
public interface TaskProcesser<T, R> {

    /**
     * 实际执行自己实现
     * @param t
     * @return
     */
    TaskResult<R> execute(T t);

}
