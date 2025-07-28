package com.example.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.log.annotation.LogMethodParam;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HelloController {

	@LogMethodParam
	@Operation(summary = "get hello")
	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}

}
