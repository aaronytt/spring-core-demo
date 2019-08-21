package com.ytt.springcoredemo.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;

/**
 * @Author: aaron
 * @Descriotion:
 *
 * 1>>>main
 * 主线程
 * 2>>>Reference Handler
 * 负责清除引用的线程
 * 3>>>Finalizer
 * 调用对象Finalize方法的线程
 * 4>>>Signal Dispatcher
 * 虚拟机分发处理信号的线程
 * 5>>>Attach Listener
 * 获取线程运行时的系统属性的线程
 * 11>>>Common-Cleaner
 * 12>>>JDWP Transport Listener: dt_socket
 * 13>>>JDWP Event Helper Thread
 * 14>>>JDWP Command Reader
 *
 *
 * @Date: 15:20 2019/8/15
 * @Modiflid By:
 */
public class MainThread {

    public static void main(String[] args) {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo: threadInfos) {
            System.out.println(threadInfo.getThreadId() + ">>>" + threadInfo.getThreadName());
        }

    }

}
