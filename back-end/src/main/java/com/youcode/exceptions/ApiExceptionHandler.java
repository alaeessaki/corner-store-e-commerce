package com.youcode.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {NotFoundException.class})
	public ResponseEntity<Object> handleApiRequestException(NotFoundException e, WebRequest request){
		HttpStatus badRequest = HttpStatus.NOT_FOUND;
		String path[] = request.getDescription(false).split("=");
		ApiException apiException = new ApiException(NotFoundException.class.getSimpleName(), e.getMessage(), badRequest ,"the resource requested is not found",path[1], ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException,badRequest);
	}	
	
	@ExceptionHandler(value = {AttributeMissingException.class})
	public ResponseEntity<Object> handleApiRequestException(AttributeMissingException e, WebRequest request){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		String path[] = request.getDescription(false).split("=");
		ApiException apiException = new ApiException(AttributeMissingException.class.getSimpleName(), e.getMessage(), badRequest ,"One of the attributes in the resource sent is missing ",path[1], ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException,badRequest);
	}	
	
	@ExceptionHandler(value = {CouponNotValidException.class})
	public ResponseEntity<Object> handleApiRequestException(CouponNotValidException e, WebRequest request){
		HttpStatus badRequest = HttpStatus.NOT_ACCEPTABLE;
		String path[] = request.getDescription(false).split("=");
		ApiException apiException = new ApiException(AttributeMissingException.class.getSimpleName(), e.getMessage(), badRequest ,"This coupon is not valid try another coupon",path[1], ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiException,badRequest);
	}	
}