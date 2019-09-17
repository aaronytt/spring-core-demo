package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;

import java.util.List;

@Deprecated
public abstract class FetchBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends CoreMapper<T,ID>>
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
