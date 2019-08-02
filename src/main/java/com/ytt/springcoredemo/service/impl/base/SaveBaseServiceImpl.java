package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import com.ytt.springcoredemo.service.base.SaveBaseService;

import java.io.Serializable;

public abstract class SaveBaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, K extends BaseMapper<T,ID>>
        extends DaoBaseServiceImpl<T, ID, K> implements SaveBaseService<T,ID> {

    @Override
    public int save(T record){
        return mapper.insert(record);
    }

    @Override
    public int saveSelective(T record){
        return mapper.insertSelective(record);
    }

}