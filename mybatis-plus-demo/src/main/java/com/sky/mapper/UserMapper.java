package com.sky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

  User queryByName(String name);

  User queryByAge(int age);

  @Select("select * from user where email = #{email}")
  User queryByEmail(String email);
}
