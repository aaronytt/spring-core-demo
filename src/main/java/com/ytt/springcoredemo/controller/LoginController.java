package com.ytt.springcoredemo.controller;

import com.ytt.springcoredemo.model.dto.UserDTO;
import com.ytt.springcoredemo.sever.LoginService;
import com.ytt.springcoredemo.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/into")
    public String loginInto(HttpServletRequest request, HttpServletResponse response){
        log.info(StringUtil.combine("ip: ", StringUtil.combine(),
                ", port: ", request.getRemotePort(),
                ", host: ", request.getRemoteHost(),
                "在访问登陆主页"));
        return "/views/login";
    }

    @RequestMapping("/out")
    @ResponseBody
    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        log.info(StringUtil.combine("ip: ", StringUtil.combine(),
                ", port: ", request.getRemotePort(),
                ", host: ", request.getRemoteHost(),
                "退出登陆成功"));
        return "/templates/views/login";
    }

    @PostMapping(value = "/into")
    public UserDTO loginInto(@RequestParam("userid") String username,
                             @RequestParam("psw") String password){
        UserDTO user = loginService.login(username,password);
        return user;
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String[] login(String username, String password){
//        loginService.login(username,password);
//        ((UserService)loginService).updateUesr();
//        return new String[]{"welcome","come"};
//    }

}
