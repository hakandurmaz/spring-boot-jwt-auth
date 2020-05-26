package com.hakandurmaz.springbootjwtauth.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

  private String message;

  public NotFoundException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
