package com.hakandurmaz.springbootjwtauth;

import com.hakandurmaz.springbootjwtauth.repository.UserMongoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableMongoRepositories(basePackages = "com.hakandurmaz.springbootjwtauth.repository")
@SpringBootApplication
@EnableSwagger2
public class SpringBootJwtAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJwtAuthApplication.class, args);
  }

}
