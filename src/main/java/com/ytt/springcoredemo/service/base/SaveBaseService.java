package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

import java.io.Serializable;

public interface SaveBaseService<T extends BaseEntity<ID>, ID extends Serializable>{

    int save(T record);

    int saveSelective(T record);

}
