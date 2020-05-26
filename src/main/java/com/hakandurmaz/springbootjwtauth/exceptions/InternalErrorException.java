package com.hakandurmaz.springbootjwtauth.exceptions;

@SuppressWarnings("serial")
public class InternalErrorException extends RuntimeException {

  private String message;

  public InternalErrorException(String message) {
    super(message);
    this.message = message;
  }

  public InternalErrorException(String message, Exception exception) {
    super(message);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
