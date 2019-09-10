package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.dto.UserDTO;
import com.ytt.springcoredemo.model.po.User;
import com.ytt.springcoredemo.service.base.CrudBaseService;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
public interface UserService extends CrudBaseService<User, Long> {

    UserDTO get(UserDTO user);

    UserDTO getById(long id);

}
