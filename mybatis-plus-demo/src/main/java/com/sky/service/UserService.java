package com.sky.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

  @Autowired
  UserMapper userMapper;

  public User getUserById(Integer id) {
    return userMapper.selectById(id);
  }

  public User queryUserByName(String name) {
    return userMapper.queryByName(name);
  }

}
