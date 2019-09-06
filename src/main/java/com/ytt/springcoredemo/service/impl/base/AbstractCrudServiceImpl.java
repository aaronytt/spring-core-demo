package com.ytt.springcoredemo.service.impl.base;

import com.ytt.springcoredemo.model.BaseEntity;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import com.ytt.springcoredemo.service.base.CrudBaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 2:47 2-119/8/1
 * @Modiflid By:
 */
public abstract class AbstractCrudServiceImpl<T extends BaseEntity<ID>, ID, K extends BaseMapper<T, ID>>
        extends DaoBaseServiceImpl<T, ID, K>
        implements CrudBaseService<T, ID> {

    @Override
    public int save(T record){
        return mapper.insert(record);
    }

    @Override
    public int saveSelective(T record){
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByID(ID id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public T fetchByID(ID id){
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> fetchSelective(T record){
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
