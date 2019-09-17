package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:07 2019/7/31
 * @Modiflid By:
 */
public abstract class DaoBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends CoreMapper<T,ID>> implements DaoBaseService {

    @Autowired
    protected K mapper;

}
