package com.rev.pms.exceptions;

public class LoginException extends RuntimeException{

	public LoginException() {
	}
	
	public LoginException(String message) {
		super(message);
	}
}
