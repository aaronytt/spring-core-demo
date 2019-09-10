package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.dao.mapper.OrderMapper;
import com.ytt.springcoredemo.service.OrderService;
import com.ytt.springcoredemo.service.base.AbstractCrudServiceImpl;
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
