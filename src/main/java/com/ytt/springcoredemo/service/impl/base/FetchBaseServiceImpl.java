package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import com.ytt.springcoredemo.service.base.FetchBaseService;

import java.io.Serializable;
import java.util.List;

public abstract class FetchBaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, K extends BaseMapper<T,ID>>
        extends DaoBaseServiceImpl<T, ID, K> implements FetchBaseService<T, ID> {

    @Override
    public T fetchByID(ID id){
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> fetchSelective(T record){
        return mapper.selectSelective(record);
    }

}
