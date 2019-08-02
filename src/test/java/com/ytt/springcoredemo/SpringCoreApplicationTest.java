package com.ytt.springcoredemo;

import com.ytt.springcoredemo.model.po.Area;
import com.ytt.springcoredemo.model.po.Good;
import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.service.AreaService;
import com.ytt.springcoredemo.service.GoodService;
import com.ytt.springcoredemo.service.OrderService;
import com.ytt.springcoredemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class SpringCoreApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
//        User user = new User();
//        user.setUsername("ytt");
//        user.setPassword("1234456");
//        user.setAge(10);
//
//        userService.save(user);
//        System.out.println(user);

        Good good = goodService.fetchByID(1l);
        System.out.println(good);

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
