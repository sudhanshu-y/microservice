package com.example.name.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.name.error.ErrorDetails;
import com.example.name.log.annotation.LogMethodParam;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@LogMethodParam
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleValidationException(MethodArgumentNotValidException ex, WebRequest webRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				HttpStatus.BAD_REQUEST, 
				ex.getBindingResult().getFieldError().getDefaultMessage(), 
				webRequest.getDescription(true), 
				System.currentTimeMillis()
		);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
	}	

}
