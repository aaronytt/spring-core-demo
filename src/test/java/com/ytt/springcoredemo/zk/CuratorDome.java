package com.ytt.springcoredemo.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.framework.api.transaction.TransactionOp;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:34 2019/9/18
 * @Modiflid By:
 */
public class CuratorDome {

    private final static String ZK_URL = "192.168.1.7:2181";

    @Test
    public void testCurator() throws Exception {
        //创建连接
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString(ZK_URL).sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        curatorFramework.start();
        System.out.println("success");

//        //创建节点
//        String result = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
//                .forPath("/curator/a/b/c","c".getBytes());
//
//        System.out.println(result);
//
//        //获取节点
//        Stat stat1 = new Stat();
//        byte[] bytes1 = curatorFramework.getData().storingStatIn(stat1).forPath("/curator/a/b/c");
//        System.out.println(new String(bytes1));

//        //删除节点
//        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/curator");
//
//        //获取节点
//        Stat stat2 = new Stat();
//        byte[] bytes2 = curatorFramework.getData().storingStatIn(stat2).forPath("/curator/a/b/c");
//        System.out.println(new String(bytes2));

//        //更新节点
//        Stat stat = curatorFramework.setData().forPath("/curator/a/b/c","123456".getBytes());
//        System.out.println(stat);
//
//        //获取节点
//        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/curator/a/b/c");
//        System.out.println(new String(bytes));

        //异步
//        ExecutorService service = Executors.newFixedThreadPool(1);
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
//        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
//                .inBackground(new BackgroundCallback() {
//                    @Override
//                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
//                        System.out.println(Thread.currentThread().getName() + "->resultCode:" + event.getResultCode() + "->" + event.getType());
//                        countDownLatch.countDown();
//                    }
//                }, service).forPath("/zk/my","my1".getBytes());
//        countDownLatch.await();
//        service.shutdown();

        //事务
        List<CuratorOp> curatorOps = Arrays.asList(
                curatorFramework.transactionOp().create().forPath("/zk/you", "some data".getBytes()),
                curatorFramework.transactionOp().setData().forPath("/zk/my", "some data".getBytes()),
                curatorFramework.transactionOp().create().forPath("/zk/my","my1".getBytes())
        );

        Collection<CuratorTransactionResult> results = curatorFramework.transaction().forOperations(curatorOps);

        results.forEach( result -> {
            System.out.println(result.getForPath() + "->" + result.getType());
        });
    }

}
