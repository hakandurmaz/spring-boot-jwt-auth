package com.hakandurmaz.springbootjwtauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
