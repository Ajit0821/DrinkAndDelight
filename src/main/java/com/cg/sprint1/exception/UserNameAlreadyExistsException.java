package com.cg.sprint1.exception;

public class UserNameAlreadyExistsException extends RuntimeException {
  public UserNameAlreadyExistsException(String msg)
  {
	  super(msg);
  }
}
