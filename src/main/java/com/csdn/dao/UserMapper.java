package com.csdn.dao;

import com.csdn.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/27 18:21
 */
public interface UserMapper {

  @Insert("insert into user(name,age) value (#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
  void addUser(User user);

}
