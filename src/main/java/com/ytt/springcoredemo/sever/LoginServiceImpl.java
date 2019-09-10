package com.ytt.springcoredemo.sever;

import com.ytt.springcoredemo.model.dto.UserDTO;
import com.ytt.springcoredemo.service.UserService;
import com.ytt.springcoredemo.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO login(String username, String password){
        UserDTO u = new UserDTO();
        u.setUsername(username);
        u.setPassword(password);
        UserDTO user = userService.get(u);
        if(user != null){
            log.info(StringUtil.combine(">>>> * ", username ," * >>>>pass ytt"));
        }else {
            log.info(StringUtil.combine(">>>> * ", username ," * >>>>password error"));
        }
        return user;
    }

}
