package com.fbm.exception;

public class PasswordWrongException extends Exception {

	public PasswordWrongException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordWrongException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordWrongException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordWrongException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "密码错误";
	}
	
	
}
