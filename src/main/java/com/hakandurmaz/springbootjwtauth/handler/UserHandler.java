package com.hakandurmaz.springbootjwtauth.handler;

import com.hakandurmaz.springbootjwtauth.model.User;

public interface UserHandler {

  User save(User newUser);

  User login(String username, String password);


}
