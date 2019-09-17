package com.ytt.springcoredemo.zk;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:00 2019/9/18
 * @Modiflid By:
 */
public class ZkClientDome {

    private final static String ZK_URL = "192.168.1.7:2181";

    @Test
    public void testZkClient() throws InterruptedException {

        ZkClient zkClient = new ZkClient(ZK_URL, 10000);

//        zkClient.createPersistent("/a/b/c/d/e/f",true);
//        System.out.println(zkClient.getChildren("/"));

//        zkClient.deleteRecursive("/a");
//        System.out.println(zkClient.getChildren("/"));

        zkClient.subscribeDataChanges("/a", new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("update 节点名称：" + dataPath + ", 数据：" + data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("delete 节点名称：" + dataPath);
            }
        });
        zkClient.writeData("/a","a");
        Thread.sleep(2000);
        zkClient.writeData("/a/b","b");
        Thread.sleep(2000);


        zkClient.subscribeChildChanges("/a", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("delete 节点名称：" + parentPath + ", 节点列表：" + currentChilds);
            }
        });
        zkClient.deleteRecursive("/a/b/c");

        Thread.sleep(2000);
    }

}
