package com.ytt.springcoredemo.dao.mapper.order;

import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;
import com.ytt.springcoredemo.model.po.Order;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface OrderMapper extends CoreMapper<Order, Long> {

    Order selectInfoBySelective(Order order);

}