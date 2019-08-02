package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.service.base.CrudBaseService;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 0:33 2019/7/31
 * @Modiflid By:
 */
public interface OrderService extends CrudBaseService<Order, Long> {

    Order getOrderInfo(Order order);

}
