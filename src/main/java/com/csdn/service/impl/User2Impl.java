package com.csdn.service.impl;

import com.csdn.dao.UserMapper;
import com.csdn.model.User;
import com.csdn.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/29 15:42
 */
@Service
public class User2Impl implements User2Service {

  @Autowired
  private UserMapper userMapper;

  @Override
  public void addUser(User user) {
    User newUser = new User(user.getName() + "-new", 18);
    userMapper.addUser(newUser);
  }

  @Override
  public void addUserException(User user) throws Exception {
    User newUser = new User(user.getName() + "-exception", 18);
    int i = 1 / 0;
    userMapper.addUser(newUser);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserTransactionalException(User user) throws Exception {
    User newUser = new User(user.getName() + "-exception", 18);
    userMapper.addUser(newUser);
    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public void addUserTransactionalRequiresNewException(User user) throws Exception {
    User newUser = new User(user.getName() + "-exception", 18);
    userMapper.addUser(newUser);
//    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
  public void addUserMandatory(User user) {
    User newUser = new User(user.getName() + "-new", 18);
    userMapper.addUser(newUser);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
  public void addUserTransactionalSupportsException(User user) {
    User newUser = new User(user.getName() + "-exception", 18);
    userMapper.addUser(newUser);
    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
  public void addUserTransactionalNotSupportsException(User user) {
    User newUser = new User(user.getName() + "-exception", 18);
    userMapper.addUser(newUser);
    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
  public void addUserTransactionalNever(User user) {
    User newUser = new User(user.getName() + "-new", 18);
    userMapper.addUser(newUser);
    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
  public void addUserTransactionalNested(User user) {
    User newUser = new User(user.getName() + "-exception", 18);
    userMapper.addUser(newUser);
    throw new RuntimeException("异常测试");
  }

}
