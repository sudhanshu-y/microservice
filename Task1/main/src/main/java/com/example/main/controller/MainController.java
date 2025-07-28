package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.log.annotation.LogMethodParam;
import com.example.main.request.NameRequest;
import com.example.main.service.CombinedHelloNameService;
import com.example.main.service.HealthCheckService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MainController {

	@Autowired
	HealthCheckService healthCheckService;

	@Autowired
	CombinedHelloNameService helloNameService;

	@LogMethodParam
	@Operation(summary = "Get Main Service Status")
	@GetMapping("/status")
	public ResponseEntity<String> getServiceStatus() {
		return ResponseEntity.status(HttpStatus.OK).body(healthCheckService.getServiceStatus());
	}

	@LogMethodParam
	@Operation(summary = "Final response from hello and name service")
	@PostMapping("/main")
	public ResponseEntity<String> getMainMessage(@Valid @RequestBody NameRequest nameRequest) {
		String result = helloNameService.getCombinedHelloNameService(nameRequest);
		log.info("From MainController: getCombinedHelloNameService -> result: " + result);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

}
