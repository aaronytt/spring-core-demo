package com.ytt.springcoredemo.redis;

import com.ytt.springcoredemo.SpringCoreApplication;
import com.ytt.springcoredemo.model.po.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 6:01 2019/9/11
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class RedisClusterTest {

    @Autowired
    JedisCluster jedisCluster;

    @Test
    public void testPostArticle(){

        int j = 1000000;

//        Long[] rs =new Long[j];

        long start = System.currentTimeMillis();
        long pre ;

        for (int i = 0; i < j; i++) {
            long r = new Random().nextLong();
            Article article = Article.builder().title("母猪上树了").content("他真的上树了").link("@lyj").userId(r+1).build();
            article.setId(r);
            String articleId = jedisCluster.set(r + "", "@lyj" + r);
//            rs[i] = r;0l;
            pre = System.currentTimeMillis();
            if(i%10000 == 0 && i != 0){
                System.out.println(i + " >>time: " + (pre - start) + " ms");
            }

        }

        System.out.println("time: " + (System.currentTimeMillis() - start) + " ms");

//        System.out.println(Arrays.asList(rs));
    }

}
