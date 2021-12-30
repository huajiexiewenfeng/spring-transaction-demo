package com.csdn.model;


import lombok.Data;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/27 18:17
 */
@Data
public class User {

  private Long id;

  private String name;

  private Integer age;

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public User() {
  }
}
