package com.sky.mapper;

import com.sky.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select * from user where email = #{email}")
  User queryByEmail(String email);


  User queryByUserName(String name);

  User queryByUserAge(int age);
}
