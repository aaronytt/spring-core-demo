package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;

@Deprecated
public abstract class SaveBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends CoreMapper<T,ID>>
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
