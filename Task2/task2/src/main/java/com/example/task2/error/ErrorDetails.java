package com.example.task2.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	private HttpStatus httpStatus;
	private String message;
	private String details;
	private Long timestamp;
	
}
