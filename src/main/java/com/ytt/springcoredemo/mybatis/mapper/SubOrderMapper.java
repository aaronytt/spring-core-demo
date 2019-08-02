package com.ytt.springcoredemo.mybatis.mapper;

import com.ytt.springcoredemo.model.po.SubOrder;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubOrderMapper extends BaseMapper<SubOrder, Long> {

    List<SubOrder> selectByOrderNumber(String orderNumber);

}