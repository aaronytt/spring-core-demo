package com.ytt.springcoredemo.service.impl;

import com.ytt.springcoredemo.service.UserService;
import com.ytt.springcoredemo.model.po.User;
import com.ytt.springcoredemo.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User,Long, UserMapper> implements UserService {
}
