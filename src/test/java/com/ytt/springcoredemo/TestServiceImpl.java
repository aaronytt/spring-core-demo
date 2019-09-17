package com.ytt.springcoredemo;

import com.ytt.springcoredemo.dao.mapper.order.OrderMapper;
import com.ytt.springcoredemo.dao.mapper.base.UserMapper;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 5:32 2019/9/12
 * @Modiflid By:
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void testTransactional() {
        User user = new User();
        user.setUsername("ytt");
        user.setPassword("1234456");
        user.setSex((byte)1);
        user.setAge((byte)15);

        userMapper.insert(user);
        System.out.println(user);

        Order order = Order.builder().orderNumber("NSB201808080251").customerId(0l).amount(BigDecimal.valueOf(100)).state(OrderState.INIT).build();
        orderMapper.insert(order);

        System.out.println(order);

        System.out.println(100/0);
        order.setAmount(BigDecimal.valueOf(200));
        orderMapper.updateByPrimaryKeySelective(order);

        orderMapper.deleteByPrimaryKey(1l);
        userMapper.deleteByPrimaryKey(1l);
        System.out.println(100/0);

        System.out.println(orderMapper.selectByPrimaryKey(2l));
    }
}
