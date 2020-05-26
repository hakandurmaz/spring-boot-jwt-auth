package com.hakandurmaz.springbootjwtauth.beans;

import com.hakandurmaz.springbootjwtauth.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthResponseBean {

  User user;
  String token;

}
