package com.ytt.springcoredemo.mybatis.mapper;

import com.ytt.springcoredemo.model.po.Area;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AreaMapper extends BaseMapper<Area, Integer> {
}