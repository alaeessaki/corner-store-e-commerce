package com.youcode.exceptions;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5046718163595316617L;

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundException(String message) {
		super(message);
	}

	
}
