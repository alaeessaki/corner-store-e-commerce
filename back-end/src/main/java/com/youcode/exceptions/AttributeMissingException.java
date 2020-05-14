package com.youcode.exceptions;

public class AttributeMissingException extends RuntimeException{

	private static final long serialVersionUID = 3333864351605213030L;

	public AttributeMissingException(String message, Throwable cause) {
		super(message, cause);
	}

	public AttributeMissingException(String message) {
		super(message);
	}

	
}
