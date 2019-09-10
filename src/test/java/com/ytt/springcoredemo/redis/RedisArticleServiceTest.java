package com.ytt.springcoredemo.redis;

import com.ytt.springcoredemo.SpringCoreApplication;
import com.ytt.springcoredemo.model.po.Article;
import com.ytt.springcoredemo.service.RedisArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 17:54 2019/9/6
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class RedisArticleServiceTest {

    @Autowired
    RedisArticleService redisArticleService;

    @Test
    public void testPostArticle(){
        Long[] rs =new Long[10];

        for (int i = 0; i < 10; i++) {
            long r = new Random().nextInt(100);
            Article article = Article.builder().title("母猪上树了").content("他真的上树了").link("@lyj").userId(r+1).build();
            article.setId(r);
            String articleId = redisArticleService.postArticle(article);
            rs[i] = r;
        }

        System.out.println(Arrays.asList(rs));
    }

    @Test
    public void testArticleVote(){
        int[] id = {60, 82, 35, 87, 76, 29, 25, 56, 57, 87};
        for (int i = 0; i < 100; i++) {
            long userId = new Random().nextInt(1000);
            redisArticleService.articleVote(String.valueOf(id[i%10]), String.valueOf(userId));
            System.out.println(userId);
        }
    }

    private final static String SCORE_INFO = "score:info";

    @Test
    public void testGetArticle(){
        for (int i = 1; i < 7; i++) {
            List<Map<String, String>> list = redisArticleService.getArticle(i,SCORE_INFO);
            System.out.println(list);
        }
    }

}
