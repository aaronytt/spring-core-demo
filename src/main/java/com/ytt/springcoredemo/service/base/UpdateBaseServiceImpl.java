package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;

@Deprecated
public abstract class UpdateBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends CoreMapper<T,ID>>
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
    public int updateByPrimaryKey(T record){
        return mapper.updateByPrimaryKey(record);
    }

}
