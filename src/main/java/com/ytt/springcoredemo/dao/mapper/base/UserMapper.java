package com.ytt.springcoredemo.dao.mapper.base;

import com.ytt.springcoredemo.dao.mapper.core.CoreMapper;
import com.ytt.springcoredemo.model.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 22:38 2019/7/27
 * @Modiflid By:
 */
//@Mapper
public interface UserMapper extends CoreMapper<User,Long> {
}
