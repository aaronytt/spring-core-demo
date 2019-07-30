package com.ytt.spring.springcore.Service;

import com.ytt.spring.springcore.model.po.User;
import com.ytt.spring.springcore.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
public interface UserService extends BaseService<User,Long> {
}
