package com.csdn.controller;

import com.csdn.model.User;
import com.csdn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xwf
 * @date ：Created in 2020-7-24 16:56
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  /**
   * 非事务版本
   *
   * @return
   */
  @GetMapping("addUser")
  public String addUser() {
    // method-1
    userService.addUser(new User("小明", 18));
    return "success";
  }

  /**
   * 非事务异常版本
   *
   * @return
   * @throws Throwable
   */
  @GetMapping("addUserException")
  public String addUserException() throws Throwable {
    // method-1
    userService.addUserException(new User("小明", 18));
    return "success";
  }

  @GetMapping("addUserTransactional/required")
  public String addUserTransactionalRequired() throws Exception {
    // method-1
    userService.addUserTransactionalRequired(new User("小明required", 18));
    return "success";
  }

  @GetMapping("addUserTransactional/requires_new")
  public void addUserTransactionalRequiresNew() throws Exception {
    // method-1
    userService.addUserTransactionalRequiresNew(new User("小明requires_new", 18));
  }

  @GetMapping("addUserTransactional/mandatory")
  public void addUserTransactionalMandatory() throws Exception {
    // method-1
    userService.addUserMandatory(new User("小明mandatory", 18));
  }

  @GetMapping("addUserTransactional/supports")
  public void addUserTransactionalSupports() throws Exception {
    // method-1
    userService.addUserSupports(new User("小明supports", 18));
  }

  @GetMapping("addUserTransactional/not_supported")
  public void addUserTransactionalNotSupported() throws Exception {
    // method-1
    userService.addUserNotSupports(new User("小明not_supported", 18));
  }

  @GetMapping("addUserTransactional/never")
  public void addUserTransactionalNever() throws Exception {
    // method-1
    userService.addUserNever(new User("小明never", 18));
  }

  @GetMapping("addUserTransactional/nested")
  public void addUserTransactionalNested() throws Exception {
    // method-1
    userService.addUserNested(new User("小明nested", 18));
  }

}
