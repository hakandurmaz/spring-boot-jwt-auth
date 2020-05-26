package com.hakandurmaz.springbootjwtauth.handler.impl;

import com.hakandurmaz.springbootjwtauth.exceptions.NotFoundException;
import com.hakandurmaz.springbootjwtauth.handler.UserHandler;
import com.hakandurmaz.springbootjwtauth.model.User;
import com.hakandurmaz.springbootjwtauth.repository.UserMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserHandlerImpl implements UserHandler {

  final
  UserMongoRepository userMongoRepository;

  public UserHandlerImpl(UserMongoRepository userMongoRepository) {
    this.userMongoRepository = userMongoRepository;
  }

  @Override
  public User save(User newUser) {
    return userMongoRepository.save(newUser);
  }

  @Override
  public User login(String username, String password) {
    User one =
        userMongoRepository.findByUsername(username);
    if (one != null) {
      return one;
    } else {
      throw new NotFoundException("User Not Found");
    }
  }
}
