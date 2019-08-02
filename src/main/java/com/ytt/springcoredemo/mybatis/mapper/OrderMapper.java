package com.ytt.springcoredemo.mybatis.mapper;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.mybatis.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order, Long> {

    Order selectInfoBySelective(Order order);

}