package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

import java.io.Serializable;

public interface DeleteBaseService<T extends BaseEntity<ID>, ID extends Serializable>{

    int deleteByID(ID id);

}
