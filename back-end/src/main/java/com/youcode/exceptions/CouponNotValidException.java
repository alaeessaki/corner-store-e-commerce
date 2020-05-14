package com.youcode.exceptions;

public class CouponNotValidException extends RuntimeException{

	private static final long serialVersionUID = 6695895971109988144L;

	public CouponNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public CouponNotValidException(String message) {
		super(message);
	}
	
	
}
