package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.service.base.DaoBaseService;
import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:07 2019/7/31
 * @Modiflid By:
 */
public abstract class DaoBaseServiceImpl<T extends BaseEntity<ID>,ID extends Serializable,K extends BaseMapper<T,ID>> implements DaoBaseService {

    @Autowired
    protected K mapper;

}
