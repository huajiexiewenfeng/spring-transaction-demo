package com.csdn.service.impl;

import com.csdn.dao.UserMapper;
import com.csdn.model.User;
import com.csdn.service.User2Service;
import com.csdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/27 18:20
 */
@Service
public class UserImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private User2Service user2Service;

  @Autowired
  private DataSourceTransactionManager dataSourceTransactionManager;

  @Override
  public void addUser(User user) {
    userMapper.addUser(user);
    // method-2
    user2Service.addUser(user);
  }

  @Override
  public void addUserException(User user) throws Exception {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserException(user);
  }

  @Override
  public void addUserMandatory(User user) {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserMandatory(user);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserTransactionalRequired(User user) throws Exception {
    userMapper.addUser(user);
    // method-2
    try {
      user2Service.addUserTransactionalException(user);
    }catch (Exception e){
      e.printStackTrace();
    }
//    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
  public void addUserTransactionalRequiresNew(User user) throws Exception {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserTransactionalRequiresNewException(user);
    throw new RuntimeException("异常测试");
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserSupports(User user) {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserTransactionalSupportsException(user);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserNotSupports(User user) {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserTransactionalNotSupportsException(user);
//    throw new RuntimeException("异常测试");
  }

  @Override
//  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserNever(User user) {
    userMapper.addUser(user);
    // method-2
    user2Service.addUserTransactionalNever(user);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  public void addUserNested(User user) {
    userMapper.addUser(user);
    try{
    user2Service.addUserTransactionalNested(user);
    }catch (Exception e){
      e.printStackTrace();
    }
//    throw new RuntimeException("异常测试");
  }
}
