package com.hakandurmaz.springbootjwtauth.security.filter;

import com.hakandurmaz.springbootjwtauth.security.TokenAuthenticationService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


public class AuthenticationTokenFilter extends GenericFilterBean {

  private final TokenAuthenticationService authenticationService;

  public AuthenticationTokenFilter(final TokenAuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain filterChain)
      throws IOException, ServletException {
    final HttpServletRequest httpRequest = (HttpServletRequest) request;
    final Authentication authentication = authenticationService.authenticate(httpRequest);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(request, response);
    SecurityContextHolder.getContext().setAuthentication(null);
  }
}
