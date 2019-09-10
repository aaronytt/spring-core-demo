//package com.ytt.springcoredemo.service;
//
//import com.ytt.springcoredemo.config.Constants;
//import com.ytt.springcoredemo.model.po.Article;
//import com.ytt.springcoredemo.redis.util.JedisUtil;
//import com.ytt.springcoredemo.service.RedisArticleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 17:01 2019/9/6
// * @Modiflid By:
// */
//@Service
//public class RedisArticleServiceImpl implements RedisArticleService {
//
//    private final static String ARTICLE_KEY_PREFIX = "aeticle:";
//    private final static String VOTE_KEY_PREFIX = "votes:";
//    private final static String SCORE_INFO = "score:info";
//    private final static String POST_TIME = "postTime";
//    private final static int SCORE = 10;
//    private final static int PRE_PAGE = 5;
//
//    @Autowired
//    private JedisUtil jedisUtil;
//
//    @Override
//    public String postArticle(Article article) {
//        return postArticle(String.valueOf(article.getId()), article.getTitle(), article.getContent(), article.getLink(), String.valueOf(article.getUserId()));
//    }
//
//    @Override
//    public String postArticle(String articleId, String title, String content, String link, String userId) {
//        long now = System.currentTimeMillis()/1000;
//
//        //生成文章id,自增主键
////        articleId = String.valueOf(jedisUtil.incr(ARTICLE_KEY_PREFIX));
//        //生成文章key
//        String articleKey = ARTICLE_KEY_PREFIX + articleId;
//        Map<String,String> articleData = new HashMap<>();
//        articleData.put("title", title);
//        articleData.put("link", link);
//        articleData.put("userId", userId);
//        articleData.put("createTime", String.valueOf(now));
//        articleData.put("votes", "1");
//        //发布文章 , map
//        jedisUtil.hmset(articleKey,articleData,0);
//
//        //投票Key
//        String votedKey = VOTE_KEY_PREFIX + articleId;
//        //投票的集合,自己投票
//        jedisUtil.sadd(votedKey, userId);
//        //七天之后投票失效
//        jedisUtil.expire(votedKey, Constants.ONE_WEEK_IN_SECONDS,0);
//        //投票失效，相关数据持久化
//        //todo
//
//        //根据文章分值排序文章的集合
//        jedisUtil.zadd(SCORE_INFO, SCORE, articleKey);
//        //根据文章发布时间排序文章的集合
//        jedisUtil.zadd(POST_TIME, now, articleKey);
//
//        return articleId;
//    }
//
//    @Override
//    public void articleVote(String articleId, String userId) {
//        long now = System.currentTimeMillis()/1000;
//        //文章key
//        String articleKey = ARTICLE_KEY_PREFIX + articleId;
//        //投票截止时间
//        Double cutOffTime = jedisUtil.zscore(POST_TIME,articleKey) + Constants.ONE_WEEK_IN_SECONDS;
//        //判断文章是否还可以投票
//        if(cutOffTime > now){
//            String votedKey = VOTE_KEY_PREFIX + articleId;
//            //投票
//            if(jedisUtil.sadd(votedKey, userId) == 1){
//                //增加票数
//                jedisUtil.hincrby(articleKey, "votes", 1L);
//                //根据文章分值排序文章的集合, 分值增加
//                jedisUtil.zincrby(SCORE_INFO, SCORE, articleKey);
//            }
//        }
//    }
//
//    @Override
//    public List<Map<String,String>> getArticle(int page, String key) {
//        int start = (page - 1) * PRE_PAGE;
//        int end = start + PRE_PAGE - 1;
//        return jedisUtil.zrevrange(key, start, end)
//                .parallelStream()
//                .map(id -> {
//                    Map<String,String> article = jedisUtil.hgetall(id, 0);
//                    article.put("id", id);
//                    return article;
//                }).collect(Collectors.toList());
//    }
//
//}
