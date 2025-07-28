package com.example.name.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.name.log.annotation.LogMethodParam;
import com.example.name.request.NameRequest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class NameController {

	@LogMethodParam
	@Operation(summary = "concatenate name and surname")
	@PostMapping("/concatenate")
	public ResponseEntity<String> concatenateName(@Valid @RequestBody NameRequest nameRequest) {

		log.info("Request Name: " + nameRequest.getName());
		log.info("Request Surname: " + nameRequest.getSurname());

		String concatenatedName = nameRequest.getName() + " " + nameRequest.getSurname();

		log.info("concatenatedName: " + concatenatedName);

		return ResponseEntity.status(HttpStatus.CREATED).body(concatenatedName);
	}

}
