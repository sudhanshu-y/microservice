package com.example.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Service;

import com.example.main.exception.HealthCheckException;
import com.example.main.log.annotation.LogMethodParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HealthCheckService {

	@Autowired
	HealthEndpoint healthEndpoint;

	@LogMethodParam
	public String getServiceStatus() {

		try {
			if (healthEndpoint.health().getStatus().getCode().equalsIgnoreCase("UP")) {
				log.info("From HealthCheckService: getServiceStatus(): Up");
				return "Up";
			}
			log.info("From HealthCheckService: getServiceStatus(): Up");
			return "Down";
		} catch (Exception ex) {
			throw new HealthCheckException("Failed to retrieve health status: " + ex.getMessage());
		}

	}

}
