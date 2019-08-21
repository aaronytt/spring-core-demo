package com.ytt.springcoredemo.concurrent.fork_join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:02 2019/8/16
 * @Modiflid By:
 */
public class ForkJoinTest {

    private static class ForkJoinTask extends RecursiveTask<Long> {

        private long start;
        private long end;
        private final long critical;

        public ForkJoinTask(long start, long end, long critical) {
            this.start = start;
            this.end = end;
            this.critical = critical;
        }

        @Override
        protected Long compute() {
//            System.out.println(Thread.currentThread().getName());
            long round = end - start;
            if(round > 0){
                if(round < critical){
                    long sum = 0;
                    for (long i = start; i < end; i++) {
                        sum += i;
                    }
                    return sum;
                }else {
                    long mid = start + round / 2;
                    ForkJoinTask left = new ForkJoinTask(start,mid,critical);
                    ForkJoinTask right = new ForkJoinTask(mid,end,critical);
                    invokeAll(left,right);
                    return left.join() + right.join();
                }
            }
            return null;
        }
    }

    private static class ForkJoinAction extends RecursiveAction {

        private long start;
        private long end;
        private final long critical;
        private static final AtomicLong sum = new AtomicLong();

        public ForkJoinAction(long start, long end, long critical) {
            this.start = start;
            this.end = end;
            this.critical = critical;
        }
        @Override
        protected void compute() {
//            System.out.println(Thread.currentThread().getName());
            List<ForkJoinAction> actions = new ArrayList<>();
            long round = end - start;
            if(round > 0){
                if(round < critical){
                    for (long i = start; i < end; i++) {
                        sum.getAndAdd(i);
                    }
                }else {
                    long mid = start + round / 2;
                    ForkJoinAction left = new ForkJoinAction(start,mid,critical);
                    ForkJoinAction right = new ForkJoinAction(mid,end,critical);
                    actions.add(left);
                    actions.add(right);
                }

                if(!actions.isEmpty()){
                    for(ForkJoinAction forkJoinAction: invokeAll(actions)){
                        forkJoinAction.join();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        long left = 0;
        long right = 10000000l;
        long critical = 100;



        long start = System.currentTimeMillis();
        ForkJoinTask task = new ForkJoinTask(left,right,critical);
        ForkJoinPool taskPool = new ForkJoinPool();
        long result  = taskPool.invoke(task);//同步调用
        System.out.println("result: " + result);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        ForkJoinAction action= new ForkJoinAction(left,right,critical);
        ForkJoinPool actionPool = new ForkJoinPool();
        actionPool.execute(action);//异步调用
        action.join();//阻塞方法
        System.out.println("result: " + action.sum);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        long sum = 0l;
        for (long i = left; i < right; i++) {
            sum += i;
        }
        System.out.println("result: " + sum);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
