package com.ytt.springcoredemo;

import com.ytt.springcoredemo.model.po.Order;
import com.ytt.springcoredemo.dao.mapper.order.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 9:52 2019/8/6
 * @Modiflid By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
public class MapperCoreTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSelect(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Order order = Order.builder().orderNumber("NSB201808080250").build();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order result = orderMapper.selectInfoBySelective(order);

        System.out.println(result);

        result = sqlSession.selectOne("com.ytt.springcoredemo.mybatis.mapper.OrderMapper.selectInfoBySelective",order);

        System.out.println(result);

    }

}
