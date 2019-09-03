package com.ytt.springcoredemo.concurrent.practice.test;

import com.ytt.springcoredemo.concurrent.practice.processer.TaskProcesser;
import com.ytt.springcoredemo.concurrent.practice.task.TaskResult;
import com.ytt.springcoredemo.concurrent.util.SleepUtil;

import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:52 2019/8/30
 * @Modiflid By:
 */
public class TestTask implements TaskProcesser<Integer,Integer> {
    @Override
    public TaskResult<Integer> execute(Integer data) {

        Random random = new Random();

        int r = random.nextInt(500);

        SleepUtil.sleep(r);

        if(r < 300){
            return TaskResult.getSuccess(r + data);
        }else if (r>400){
            return TaskResult.getFailure(-1,"");
        }else {
            if(r > 350){
                return TaskResult.getException(-1,"",new Exception("异常"));
            }
            throw new RuntimeException("e: " + r);
        }

    }
}
