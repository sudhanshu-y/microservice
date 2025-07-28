package com.example.task2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.task2.error.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(RoleNotFoundException ex, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				HttpStatus.NOT_FOUND, 
				ex.getMessage(), 
				webRequest.getDescription(true), 
				System.currentTimeMillis()
		);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
	}

}
