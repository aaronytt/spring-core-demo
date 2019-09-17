package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.po.Good;
import com.ytt.springcoredemo.dao.mapper.base.GoodMapper;
import com.ytt.springcoredemo.service.base.AbstractCrudServiceImpl;
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
public class GoodServiceImpl extends AbstractCrudServiceImpl<Good, Long, GoodMapper> implements GoodService {
}
