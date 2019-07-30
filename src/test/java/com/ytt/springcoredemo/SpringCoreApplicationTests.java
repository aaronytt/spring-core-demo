package com.ytt.springcoredemo;

import com.ytt.springcoredemo.model.po.Good;
import com.ytt.springcoredemo.model.po.User;
import com.ytt.springcoredemo.service.GoodService;
import com.ytt.springcoredemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class SpringCoreApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private GoodService goodService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        User user = new User();
        user.setUsername("ytt");
        user.setPassword("1234456");
        user.setAge(10);

        userService.insert(user);
        System.out.println(user);

        Good good = goodService.selectByPrimaryKey(1l);
        System.out.println(good);

    }

}
