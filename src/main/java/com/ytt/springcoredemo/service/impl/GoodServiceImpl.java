package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.service.GoodService;
import com.ytt.springcoredemo.model.po.Good;
import com.ytt.springcoredemo.mybatis.mapper.GoodMapper;
import com.ytt.springcoredemo.service.annotation.Crud;
import com.ytt.springcoredemo.service.impl.base.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
@Service
@Slf4j
public class GoodServiceImpl extends CrudServiceImpl<Good, Long, GoodMapper> implements GoodService {
}
