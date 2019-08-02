package com.ytt.springcoredemo.mybatis.mapper.base;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T extends Serializable,ID extends Serializable> {

    int insert(T record);

    int insertSelective(T record);

    int deleteByPrimaryKey(ID id);

    T selectByPrimaryKey(ID id);

    List<T> selectSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(ID id);

}
