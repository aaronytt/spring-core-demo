package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import com.ytt.springcoredemo.service.base.DeleteBaseService;

import java.io.Serializable;

@Deprecated
public abstract class DeleteBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends BaseMapper<T,ID>>
        extends DaoBaseServiceImpl<T, ID, K> implements DeleteBaseService<T,ID> {

    @Override
    public int deleteByID(ID id){
        return mapper.deleteByPrimaryKey(id);
    }

}
