package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.po.Article;

import java.util.List;
import java.util.Map;

public interface RedisArticleService {

    String postArticle(Article article);

    String postArticle(String articleId, String title, String content, String link, String userId);

    void articleVote(String UserId, String articleId);

    List<Map<String,String>> getArticle(int page, String Key);

}
