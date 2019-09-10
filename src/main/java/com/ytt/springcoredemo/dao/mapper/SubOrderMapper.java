package com.ytt.springcoredemo.dao.mapper;

import com.ytt.springcoredemo.model.po.SubOrder;
import com.ytt.springcoredemo.dao.mapper.base.BaseMapper;

import java.util.List;

//@Mapper
public interface SubOrderMapper extends BaseMapper<SubOrder, Long> {

    List<SubOrder> selectByOrderNumber(String orderNumber);

}