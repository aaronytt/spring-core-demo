package com.ytt.springcoredemo.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:20 2019/9/17
 * @Modiflid By:
 */
public class ACLDemo implements Watcher{

    private final static String ZK_URL = "192.168.1.7:2181";
    private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(1);

    @Test
    public void testACL() throws IOException, NoSuchAlgorithmException, KeeperException, InterruptedException {

        ZooKeeper zooKeeper = new ZooKeeper(ZK_URL, 5000, new ACLDemo());
        COUNT_DOWN_LATCH.await();

        ACL acl1 = new ACL(ZooDefs.Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest("root:root")));
        ACL acl2 = new ACL(ZooDefs.Perms.CREATE, new Id("ip", "192.168.1.4"));
        zooKeeper.create("/a", "a".getBytes(), Arrays.asList(acl1,acl2), CreateMode.PERSISTENT);
        zooKeeper.addAuthInfo("digest", "root:root".getBytes());
        zooKeeper.create("/a/a1", "a1".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);

        System.out.println(new String(zooKeeper.getData("/a/a1",true,new Stat())));

        ZooKeeper zooKeeper1 = new ZooKeeper(ZK_URL, 5000, new ACLDemo());
        COUNT_DOWN_LATCH.await();
        zooKeeper1.addAuthInfo("digest", "root:root".getBytes());
        zooKeeper1.delete("/a/a1",-1);

    }


    @Override
    public void process(WatchedEvent event) {
        if(event.getState() == Watcher.Event.KeeperState.SyncConnected){
            COUNT_DOWN_LATCH.countDown();
            System.out.println(event.getState());
        }
        if(event.getType() == Watcher.Event.EventType.NodeDataChanged){
            System.out.println("节点发生了变化");
        }
    }
}
