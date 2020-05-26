package com.hakandurmaz.springbootjwtauth.security.impl;

import com.hakandurmaz.springbootjwtauth.model.User;
import com.hakandurmaz.springbootjwtauth.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImppl implements UserDetailsService {

  private final UserMongoRepository userMongoRepository;

  @Autowired
  public UserDetailsServiceImppl(final UserMongoRepository userMongoRepository) {
    this.userMongoRepository = userMongoRepository;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final User user = userMongoRepository.findByUsername(username);
    if (user != null) {
      return user;
    } else {
      throw new UsernameNotFoundException("User with username:" + username + " not found");
    }
  }
}
