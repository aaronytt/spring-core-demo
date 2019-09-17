package com.ytt.springcoredemo;

import com.ytt.springcoredemo.model.Car;
import com.ytt.springcoredemo.model.enumeration.OrderState;
import com.ytt.springcoredemo.model.po.Area;
import com.ytt.springcoredemo.model.po.Good;
import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.model.po.User;
import com.ytt.springcoredemo.service.AreaService;
import com.ytt.springcoredemo.service.GoodService;
import com.ytt.springcoredemo.service.OrderService;
import com.ytt.springcoredemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class SpringCoreApplicationTest {

    @Autowired
    Car car;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TestService testService;

    @Test
    public void test(){
        System.out.println(userService.fetchByID(29l));

        System.out.println(orderService.fetchByID(2l));

        testService.testTransactional();
    }

    @Test
    public void testAreaService(){
        Area area = areaService.fetchByID(110000);
        System.out.println(area);
    }

    @Test
    public void testOrderService(){

        Order order = Order.builder().orderNumber("NSB201808080250").build();

        Order result = orderService.getOrderInfo(order);

        System.out.println(result);
    }

}
