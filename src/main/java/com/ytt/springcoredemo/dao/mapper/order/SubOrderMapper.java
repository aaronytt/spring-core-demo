package com.ytt.springcoredemo.dao.mapper.order;

import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;
import com.ytt.springcoredemo.model.po.SubOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface SubOrderMapper extends CoreMapper<SubOrder, Long> {

    List<SubOrder> selectByOrderNumber(String orderNumber);

}