package com.sky.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

  @Autowired
  UserService userService;

  @Autowired
  UserMapper userMapper;

  @Test
  void getUserById() {
    User userById = userService.getUserById(1);
    System.out.println(userById);
  }

  @Test
  void queryUserByName() {
    User user = userMapper.queryByAge(20);
    System.out.println(user);
  }

  @Test
  void selectById() {
    User user = userMapper.selectById(1L);
  }

  @Test
  void selectOne() {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("age", 20);
    User user = userMapper.selectOne(queryWrapper);
    System.out.println(user);
  }

  @Test
  void selectList() {
    LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.gt(User::getAge, 20);
    List<User> users = userMapper.selectList(queryWrapper);
  }

  @Test
  void selectList2() {
    LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.gt(User::getAge, 20);
    queryWrapper.eq(true, User::getId, 1);
    List<User> users = userMapper.selectList(queryWrapper);
  }


  @Test
  void selectMaps() {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .select(User::getUserName, User::getAge)
        .eq(User::getId, 1)
        .eq(User::getAge, 20);
    List<Map<String, Object>> mapList = userMapper.selectMaps(lambdaQueryWrapper);
    System.out.println(mapList);
  }

  @Test
  void selectObj() {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .in(User::getId, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Object> objs = userMapper.selectObjs(lambdaQueryWrapper);
    System.out.println(objs);
  }

  @Test
  void selectCount() {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .like(User::getUserName, "s");
    Long count = userMapper.selectCount(lambdaQueryWrapper);
    System.out.println(count);
  }

  @Test
  void selectPage () {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .like(User::getUserName, "s");
    Page<User> pageQuery = new Page<>(3, 5);
    IPage<User> page = userMapper.selectPage(pageQuery, lambdaQueryWrapper);
    System.out.println(page.getRecords());
    System.out.println(page.getTotal());
  }


  @Test
  void insert() {
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setUserName("tom");
      user.setAge((int) (Math.random() * 30 + 10));
      user.setEmail(user.getUserName() + "@qq.com");
      int insert = userMapper.insert(user);
    }
  }

  @Test
  void updateById() {
    User user = new User();
    user.setId(1L);
    user.setAge(20);
    user.setUserName("tom");
    userMapper.updateById(user);
  }

  /**
   * ==>  Preparing: UPDATE user SET age=? WHERE (id = ?)
   * ==> Parameters: 22(Integer), 80(Integer)
   */
  @Test
  void updateByWrapper() {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .eq(User::getId, 80);
    User user = new User();
    user.setAge(22);
    userMapper.update(user, lambdaQueryWrapper);
  }

  @Test
  void updateByWrapper2() {
    LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>()
        .set(User::getAge, 22)
        .eq(User::getId, 81);
    userMapper.update(null, updateWrapper);
  }

  @Test
  void deleteById() {
    userMapper.deleteById(1L);
  }

  @Test
  void deleteByWrapper() {
    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
        .eq(User::getAge, 20);
    userMapper.delete(lambdaQueryWrapper);
  }

  @Test
  void deleteBatchIds() {
    userMapper.deleteBatchIds(List.of(10L, 20L, 30L));
  }

  @Test
  void deleteByMap() {
    Map<String, Object> map = Map.of("id", 101);
    userMapper.deleteByMap(map);
  }



}