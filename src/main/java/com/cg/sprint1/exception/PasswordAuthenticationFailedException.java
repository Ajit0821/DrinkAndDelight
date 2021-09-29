package com.cg.sprint1.exception;

public class PasswordAuthenticationFailedException extends RuntimeException {
	
	public  PasswordAuthenticationFailedException(String msg)
	{
		super(msg);
	}
}
