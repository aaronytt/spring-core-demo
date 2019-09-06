package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

import java.io.Serializable;

public interface DeleteBaseService<T extends BaseEntity<ID>, ID>{

    int deleteByID(ID id);

}
