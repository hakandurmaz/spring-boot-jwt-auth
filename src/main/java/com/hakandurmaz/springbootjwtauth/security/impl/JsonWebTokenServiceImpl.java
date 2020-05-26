package com.hakandurmaz.springbootjwtauth.security.impl;

import com.hakandurmaz.springbootjwtauth.exceptions.NotValidRequestException;
import com.hakandurmaz.springbootjwtauth.model.User;
import com.hakandurmaz.springbootjwtauth.security.JsonWebTokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class JsonWebTokenServiceImpl implements JsonWebTokenService {

  private static int tokenExpirationTime = 300;

  @Value("${jwt.security.secret.key}")
  private String tokenKey;

  private final UserDetailsService userDetailsService;

  @Autowired
  public JsonWebTokenServiceImpl(final UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  public String getToken(final String username, final String password) {
    if (username == null || password == null) {
      return null;
    }

    final User user = (User) userDetailsService.loadUserByUsername(username);
    Map<String, Object> tokenData = new HashMap<>();
    if (password.equals(user.getPassword())) {
      tokenData.put("clientType", "user");
      tokenData.put("userID", user.getId());
      tokenData.put("username", user.getUsername());
      tokenData.put("token_create_date", LocalDateTime.now());
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.MINUTE, tokenExpirationTime);
      tokenData.put("token_expiration_date", calendar.getTime());
      JwtBuilder jwtBuilder = Jwts.builder();
      jwtBuilder.setExpiration(calendar.getTime());
      jwtBuilder.setClaims(tokenData);
      return jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();

    } else {
      throw new NotValidRequestException("Authentication error occurred");
    }
  }
}
