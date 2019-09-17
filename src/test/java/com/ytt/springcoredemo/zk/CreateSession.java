package com.ytt.springcoredemo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 21:54 2019/9/17
 * @Modiflid By:
 */
public class CreateSession {

    private final static String ZK_URL = "192.168.1.7:2181";
    private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    @Test
    public void createSession() throws InterruptedException, IOException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper(ZK_URL, 5000, watchedEvent -> {
            if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected){
                COUNT_DOWN_LATCH.countDown();
                System.out.println(watchedEvent.getState());
            }
            if(watchedEvent.getType() == Watcher.Event.EventType.NodeDataChanged){
                System.out.println("节点发生了变化");
            }
        });

        COUNT_DOWN_LATCH.await();
        System.out.println(zooKeeper.getState());

//        zooKeeper.create("/ytt1", "ytt1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //获取数据
        Stat stat = new Stat();
        byte[] data;
        data = zooKeeper.getData("/ytt1", true, null);
        System.out.println(new String(data));
        System.out.println(stat);

        //修改数据
//        zooKeeper.setData("/ytt1","wawa1".getBytes(),-1);
//        data = zooKeeper.getData("/ytt1", true, null);
//        System.out.println(new String(data));
//        System.out.println(stat);
//        zooKeeper.setData("/ytt1","wawa2".getBytes(),-1);
//        data = zooKeeper.getData("/ytt1", true, null);
//        System.out.println(new String(data));
//        System.out.println(stat);

        //删除数据
//        zooKeeper.delete("/ytt",-1);
//        data = zooKeeper.getData("/ytt", true, stat);
//        System.out.println(new String(data));
//        System.out.println(stat);

//        zooKeeper.create("/ytt/ytt1", "ytt1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zooKeeper.create("/ytt/ytt2", "ytt2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zooKeeper.create("/ytt/ytt3", "ytt3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        List<String> childrens = zooKeeper.getChildren("/ytt",true);
//        System.out.println(childrens);

    }





}
