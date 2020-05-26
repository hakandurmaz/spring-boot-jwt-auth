package com.hakandurmaz.springbootjwtauth.controller;

import com.hakandurmaz.springbootjwtauth.beans.UserAuthResponseBean;
import com.hakandurmaz.springbootjwtauth.exceptions.NotValidRequestException;
import com.hakandurmaz.springbootjwtauth.handler.UserHandler;
import com.hakandurmaz.springbootjwtauth.model.User;
import com.hakandurmaz.springbootjwtauth.security.JsonWebTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  final
  UserHandler userHandler;
  final
  JsonWebTokenService tokenService;

  public UserController(UserHandler userHandler, JsonWebTokenService tokenService) {
    this.userHandler = userHandler;
    this.tokenService = tokenService;
  }

  @RequestMapping(
      value = "/signup",
      method = {RequestMethod.POST},
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public User signup(@RequestBody User newUser) {
    return userHandler.save(newUser);
  }

  @RequestMapping(
      value = "/login",
      method = {RequestMethod.GET})
  public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
    final String token = tokenService.getToken(username, password);
    if (token != null) {
      User user = userHandler.login(username, password);
      return new ResponseEntity<>(new UserAuthResponseBean(user, token), HttpStatus.OK);
    } else {
      throw new NotValidRequestException("Authentication failed");
    }
  }

  @GetMapping(value = "/hello")
  @ResponseBody
  public String hello() {
    return "Hello World!";
  }


}
