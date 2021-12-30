package com.csdn.service;

import com.csdn.model.User;

/**
 * @Author: xiewenfeng
 * @Date: 2021/12/27 18:17
 */
public interface UserService {

  void addUser(User user);

  void addUserException(User user) throws Exception;

  void addUserMandatory(User user);

  void addUserNested(User user);

  void addUserTransactionalRequired(User user) throws Exception;

  void addUserTransactionalRequiresNew(User user) throws Exception;

  void addUserSupports(User user);

  void addUserNotSupports(User user);

  void addUserNever(User user);
}
