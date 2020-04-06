package com.demo.login.mapper;

import com.demo.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    //查找所有用户数据
    List<User> findAll();

    //根据名称查找用户数据
    User findByName(String name);

    //根据用户名查找用户密码
    String findPswByName(String UserName);

    //保存用户数据至数据库
    void save(User user);
}
