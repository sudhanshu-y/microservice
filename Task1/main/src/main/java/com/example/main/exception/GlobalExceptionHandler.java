package com.example.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.main.error.ErrorDetails;
import com.example.main.log.annotation.LogMethodParam;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@LogMethodParam
	@ExceptionHandler(HealthCheckException.class)
	public ResponseEntity<ErrorDetails> handleHealthCheckException (HealthCheckException ex, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				HttpStatus.SERVICE_UNAVAILABLE, 
				"Health check failed: " + ex.getMessage(), 
				webRequest.getDescription(true), 
				System.currentTimeMillis()
		);
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorDetails);
	}
	
	@LogMethodParam
	@ExceptionHandler(ExternalServiceException.class)
	public ResponseEntity<ErrorDetails> handleExternalServiceException (ExternalServiceException ex, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				HttpStatus.SERVICE_UNAVAILABLE, 
				"External service call failed: " + ex.getMessage(), 
				webRequest.getDescription(true), 
				System.currentTimeMillis()
		);
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorDetails);
	}
	
	@LogMethodParam
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException (Exception  ex, WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				HttpStatus.INTERNAL_SERVER_ERROR, 
				"An unexpected error occurred: " + ex.getMessage(), 
				webRequest.getDescription(true), 
				System.currentTimeMillis()
		);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
	}
	

}
