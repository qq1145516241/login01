package com.demo.login.controller;

import com.demo.login.pojo.User;
import com.demo.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(User user){
        return userService.login(user);
    }

    @PostMapping("/regist")
    public String regist(User user){
        return userService.regist(user);
    }
}
