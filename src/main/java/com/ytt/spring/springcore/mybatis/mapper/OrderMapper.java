package com.ytt.spring.springcore.mybatis.mapper;

import com.ytt.spring.springcore.model.po.Order;
import com.ytt.spring.springcore.model.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:38 2019/7/27
 * @Modiflid By:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order,Long>{
}
