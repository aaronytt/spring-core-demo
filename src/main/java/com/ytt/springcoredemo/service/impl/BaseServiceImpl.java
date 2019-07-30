package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.service.BaseService;
import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:07 2019/7/31
 * @Modiflid By:
 */
public abstract class BaseServiceImpl<T extends BaseEntity<ID>,ID extends Serializable,K extends BaseMapper<T,ID>> implements BaseService<T, ID> {

    @Autowired
    protected K mapper;

    @Override
    public T insert(T record){
        mapper.insert(record);
        return record;
    }

    @Override
    public T insertSelective(T record){
        mapper.insertSelective(record);
        return record;
    }

    @Override
    public int deleteByPrimaryKey(ID id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(ID id){
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectSelective(T record){
        return mapper.selectSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record){
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(ID id){
        return mapper.updateByPrimaryKey(id);
    }

}
