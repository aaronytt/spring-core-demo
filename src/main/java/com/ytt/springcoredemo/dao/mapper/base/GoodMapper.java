package com.ytt.springcoredemo.dao.mapper.base;

import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;
import com.ytt.springcoredemo.model.po.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 11:15 2019/6/20
 * @Modiflid By:
 */
//@Mapper
public interface GoodMapper extends CoreMapper<Good, Long> {

    @Select("SELECT count(0) FROM goods")
    long getCount();

}
