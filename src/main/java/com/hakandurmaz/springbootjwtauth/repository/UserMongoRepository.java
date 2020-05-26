package com.hakandurmaz.springbootjwtauth.repository;

import com.hakandurmaz.springbootjwtauth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserMongoRepository extends MongoRepository<User, String> {

  @Query("{username : ?0}")
  User findByUsername(String username);

}
