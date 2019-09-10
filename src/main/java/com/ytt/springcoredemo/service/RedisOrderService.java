package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.po.Order;

import java.util.List;
import java.util.Map;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:17 2019/9/7
 * @Modiflid By:
 */
public interface RedisOrderService {

    String postOrder(Order order);

    List<Map<String, String>> getOrdersByCustomerId(int page, String customerId);

    Map<String, String> getOrderByOrderNumber(String orderNumber);

}
