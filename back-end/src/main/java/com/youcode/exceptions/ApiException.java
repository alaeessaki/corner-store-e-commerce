package com.youcode.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
	
	private final String type;
	private final String message;
	private final HttpStatus httpStatus;
	private final String details;
	private final String path;
	private final ZonedDateTime timestamp;
	
	public ApiException(String type, String message, HttpStatus httpStatus, String details, String path,
			ZonedDateTime timestamp) {
		super();
		this.type = type;
		this.message = message;
		this.httpStatus = httpStatus;
		this.details = details;
		this.path = path;
		this.timestamp = timestamp;
	}
	public String getType() {
		return type;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public String getDetails() {
		return details;
	}
	public String getPath() {
		return path;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
}