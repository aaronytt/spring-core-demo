package com.ytt.springcoredemo.service.base;

import com.ytt.springcoredemo.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface FetchBaseService<T extends BaseEntity<ID>, ID extends Serializable>{

    T fetchByID(ID id);

    List<T> fetchSelective(T record);

}
