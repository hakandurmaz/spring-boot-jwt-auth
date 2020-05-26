package com.hakandurmaz.springbootjwtauth.exceptions;

@SuppressWarnings("serial")
public class NotValidRequestException extends RuntimeException {

  private String message;

  public NotValidRequestException(String message) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
