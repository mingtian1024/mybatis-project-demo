package com.sky.service;

import com.sky.common.entity.User;
import com.sky.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserServiceTest {

  @Autowired
  UserService userService;

  @Autowired
  UserMapper userMapper;

  @Test
  public void testQueryUserByName() {
    User user = userService.queryByEmail("test");
    User user1 = userMapper.queryByEmail("test@");
    System.out.println(user);
    System.out.println(user1);
  }

  @Test
  public void test1(){
    User tom = userMapper.queryByUserName("tom");
    System.out.println(tom);
  }


  @Test
  public void test2() {
    User user = userMapper.queryByUserAge(18);
    System.out.println(user);
  }
}