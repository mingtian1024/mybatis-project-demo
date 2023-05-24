package com.sky.service;

import com.sky.common.entity.User;
import com.sky.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

  @Autowired
  UserMapper userMapper;


  public User queryByEmail(String email) {
    return userMapper.queryByEmail(email);
  }

}
