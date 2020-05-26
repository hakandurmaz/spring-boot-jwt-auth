package com.hakandurmaz.springbootjwtauth.security;


public interface JsonWebTokenService {

  String getToken(String username, String password);

}
