package com.ytt.spring.springcore.Service.impl;

import com.ytt.spring.springcore.Service.UserService;
import com.ytt.spring.springcore.model.po.User;
import com.ytt.spring.springcore.mybatis.mapper.UserMapper;
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
public class UserServiceImpl extends BaseServiceImpl<User,Long,UserMapper> implements UserService {
}
