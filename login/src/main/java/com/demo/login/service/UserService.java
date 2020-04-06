package com.demo.login.service;

import com.demo.login.mapper.UserMapper;
import com.demo.login.pojo.User;
import com.demo.login.util.StringEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public String login(User user){
        try {
            User username = userMapper.findByName(user.getUsername());
            if (username != null){
                String psw = userMapper.findPswByName(user.getUsername());

                if (psw.equals(StringEncrypt.Encrypt(user.getPassword()))){
                    return user.getUsername()+" 用户登录成功,欢迎您！";
                }else {
                    return "登陆失败,密码错误！";
                }
            }else {
                return "登陆失败，账户不存在";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String regist(User user){
        try{
            User username = userMapper.findByName(user.getUsername());
            if (user.getUsername().equals("")){
                return "账户名不能为空";
            }else if (user.getPassword().equals("")){
                return "密码不能为空";
            }else if (username != null){
                return "账户已经存在";
            }else {
                user.setPassword(StringEncrypt.Encrypt(user.getPassword()));
                userMapper.save(user);
                return "注册成功";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
