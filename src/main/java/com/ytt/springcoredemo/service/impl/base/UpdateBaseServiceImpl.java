package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import com.ytt.springcoredemo.service.base.UpdateBaseService;

import java.io.Serializable;

public abstract class UpdateBaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, K extends BaseMapper<T,ID>>
        extends DaoBaseServiceImpl<T, ID, K> implements UpdateBaseService<T,ID> {

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
