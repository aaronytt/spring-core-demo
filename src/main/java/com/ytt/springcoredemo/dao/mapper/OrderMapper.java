package com.ytt.springcoredemo.dao.mapper;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.dao.mapper.base.BaseMapper;

//@Mapper
public interface OrderMapper extends BaseMapper<Order, Long> {

    Order selectInfoBySelective(Order order);

}