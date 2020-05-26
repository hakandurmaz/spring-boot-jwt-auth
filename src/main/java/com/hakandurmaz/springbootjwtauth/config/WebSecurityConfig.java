package com.hakandurmaz.springbootjwtauth.config;

/**
 * Created by Hakan Durmaz at 27.02.2020 21:27
 */

import com.hakandurmaz.springbootjwtauth.security.TokenAuthenticationService;
import com.hakandurmaz.springbootjwtauth.security.filter.AuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private final TokenAuthenticationService tokenAuthenticationService;

  @Autowired
  protected WebSecurityConfig(final TokenAuthenticationService tokenAuthenticationService) {
    super();
    this.tokenAuthenticationService = tokenAuthenticationService;
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(
            "/user/signup",
            "/user/login",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new AuthenticationTokenFilter(tokenAuthenticationService),
            UsernamePasswordAuthenticationFilter.class)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf().disable();
  }

}
