package com.csdn.service;

import com.csdn.model.User;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/27 18:17
 */
public interface User2Service {

  void addUser(User user);

  void addUserException(User user) throws Exception;

  void addUserTransactionalRequiresNewException(User user) throws Exception;

  void addUserTransactionalException(User user) throws Exception;

  void addUserMandatory(User user);

  void addUserTransactionalSupportsException(User user);

  void addUserTransactionalNotSupportsException(User user);

  void addUserTransactionalNever(User user);

  void addUserTransactionalNested(User user);
}
