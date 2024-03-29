package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

import java.io.Serializable;

public interface UpdateBaseService<T extends BaseEntity<ID>, ID>{

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);

}
