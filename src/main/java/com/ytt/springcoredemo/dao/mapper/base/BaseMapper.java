package com.ytt.springcoredemo.dao.mapper.base;

import java.util.List;

public interface BaseMapper<T,ID> {

    int insert(T record);

    int insertSelective(T record);

    int deleteByPrimaryKey(ID id);

    T selectByPrimaryKey(ID id);

    List<T> selectSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(ID id);

}
