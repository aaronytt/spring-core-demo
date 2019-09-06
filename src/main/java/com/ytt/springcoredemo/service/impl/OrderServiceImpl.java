package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.mybatis.mapper.OrderMapper;
import com.ytt.springcoredemo.service.OrderService;
import com.ytt.springcoredemo.service.impl.base.AbstractCrudServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
@Service
@Slf4j
public class OrderServiceImpl extends AbstractCrudServiceImpl<Order, Long, OrderMapper> implements OrderService {

    @Override
    public Order getOrderInfo(Order order){
        return mapper.selectInfoBySelective(order);
    }

}
