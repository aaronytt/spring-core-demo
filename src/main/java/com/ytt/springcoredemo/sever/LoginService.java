package com.ytt.springcoredemo.sever;

import com.ytt.springcoredemo.model.dto.UserDTO;

public interface LoginService {

    UserDTO login(String username, String password);

}
