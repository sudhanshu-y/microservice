package com.example.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.main.exception.ExternalServiceException;
import com.example.main.log.annotation.LogMethodParam;
import com.example.main.request.NameRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CombinedHelloNameService {

	@Autowired
	RestTemplate restTemplate;

	@LogMethodParam
	public String getCombinedHelloNameService(NameRequest nameRequest) {

		try {

			// hello service - GET call
			String hello = restTemplate.getForObject("http://hello/hello", String.class);
			log.info("Response from hello service: {}", hello);

			// name service - POST call
			String name = restTemplate.postForObject("http://name/concatenate", nameRequest, String.class);
			log.info("Response from name service: {}", name);

			return hello + " " + name;

		} catch (RestClientException ex) {

			log.error("Failed to call external services", ex);
			throw new ExternalServiceException("Failed to call 'hello' or 'name' service: " + ex);

		}
	}

}
