package com.ytt.spring.springcore.Service.impl;

import com.ytt.spring.springcore.Service.OrderService;
import com.ytt.spring.springcore.model.po.Order;
import com.ytt.spring.springcore.mybatis.mapper.OrderMapper;
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
public class OrderServiceImpl extends BaseServiceImpl<Order,Long,OrderMapper> implements OrderService {
}
