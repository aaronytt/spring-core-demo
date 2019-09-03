package com.ytt.springcoredemo.concurrent.practice.task;

import lombok.ToString;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:37 2019/8/29
 * @Modiflid By:
 */
@ToString
public class TaskResult<R> {
    //结果类型
    private final TaskResultType type;
    //结果数据
    private final R data;
    //失败原因
    private final String reason;
    //异常
    private final Exception e;

    public TaskResult(TaskResultType type, R data, String reason, Exception e) {
        this.type = type;
        this.data = data;
        this.reason = reason;
        this.e = e;
    }

    public TaskResult(TaskResultType type, R data) {
        this.type = type;
        this.data = data;
        this.reason = "success";
        this.e = null;
    }

    public static <T> TaskResult<T> getSuccess(T data){
        return new TaskResult<T>(TaskResultType.SUCCESS,data);
    }

    public static <T> TaskResult<T> getFailure(T data,String reason){
        return new TaskResult(TaskResultType.FAILURE,null,reason,null);
    }

    public static <T> TaskResult<T> getException(T data, String reason,Exception e){
        return new TaskResult(TaskResultType.EXCEPTION,null,reason,e);
    }

    public TaskResultType getType() {
        return type;
    }

    public R getData() {
        return data;
    }

    public String getReason() {
        return reason;
    }

    public Exception getException() {
        return e;
    }
}
