package com.hakandurmaz.springbootjwtauth.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

  Contact contact =
      new Contact("Hakan Durmaz", "http://www.hakandurmaz.com.tr", "hello@hakandurmaz.com.tr");

  List<VendorExtension> vendorExtensions = new ArrayList<>();

  ApiInfo apiInfo =
      new ApiInfo(
          "Tennis Partner Application RESTful Web Service documentation",
          "This page documents Tennis Partner mobile app RESTful Web Service endpoints",
          "1.0",
          "http://www.hakandurmaz.com.tr/tennis-partner",
          contact,
          "Apache 2.0",
          "http://www.apache.org/licenses/LICENSE-2.0",
          vendorExtensions);

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2) //
        .directModelSubstitute(LocalDateTime.class, String.class)
        .directModelSubstitute(LocalDate.class, String.class)
        .apiInfo(apiInfo)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.hakandurmaz"))
        .build();
  }
}
