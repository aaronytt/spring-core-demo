package com.ytt.springcoredemo.service;

import com.ytt.springcoredemo.model.dto.UserDTO;
import com.ytt.springcoredemo.model.po.User;
import com.ytt.springcoredemo.dao.mapper.base.UserMapper;
import com.ytt.springcoredemo.service.base.AbstractCrudServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 23:01 2019/7/27
 * @Modiflid By:
 */
@Service
@Slf4j
public class UserServiceImpl extends AbstractCrudServiceImpl<User, Long, UserMapper> implements UserService {

    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String CACHE_NAME = "users";

    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY)
    public UserDTO save(UserDTO user) {
        long id = super.save(user);
        user.setId(id);
        return user;
    }

    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #user.toString()")
    @Override
    public UserDTO get(UserDTO user) {
        List<User> userPOList = super.fetchSelective(user);
        UserDTO userDTO = new UserDTO();
        if(!userPOList.isEmpty()){
            BeanUtils.copyProperties(userPOList.get(0),userDTO);
        }

        return userDTO ;
    }

    @Cacheable(value = CACHE_NAME,key = CACHE_KEY + " + #id")
    @Override
    public UserDTO getById(long id) {
        System.out.println("没有走缓存");
        User user = super.fetchByID(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO ;
    }

    @CachePut(value = CACHE_NAME,key = CACHE_KEY + " + #user.getId()")
    public long update(UserDTO user) {
        System.out.println(">>>>>>我在ytt刷脸了，好开心啊");
        /**
         * 待续
         */
        return  0;
    }

    //删除用户数据
    @CacheEvict(value = CACHE_NAME,key = CACHE_KEY + " + #id")//这是清除缓存
    public void delete(long id){
        System.out.println("清除缓存");
        return;
    }

}
