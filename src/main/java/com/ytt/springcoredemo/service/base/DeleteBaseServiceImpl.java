package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;

@Deprecated
public abstract class DeleteBaseServiceImpl<T extends BaseEntity<ID>, ID, K extends CoreMapper<T,ID>>
        extends DaoBaseServiceImpl<T, ID, K> implements DeleteBaseService<T,ID> {

    @Override
    public int deleteByID(ID id){
        return mapper.deleteByPrimaryKey(id);
    }

}
