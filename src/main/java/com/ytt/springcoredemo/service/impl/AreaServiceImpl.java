package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.model.po.Area;
import com.ytt.springcoredemo.mybatis.mapper.AreaMapper;
import com.ytt.springcoredemo.service.AreaService;
import com.ytt.springcoredemo.service.impl.base.AbstractCrudServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
@Service
@Slf4j
public class AreaServiceImpl extends AbstractCrudServiceImpl<Area, Integer, AreaMapper> implements AreaService {
}
