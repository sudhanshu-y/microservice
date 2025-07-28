package com.example.main.log.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import brave.propagation.CurrentTraceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogMethodParamImpl {

	@Autowired
	CurrentTraceContext currentTraceContext;

	@Before("@annotation(com.example.main.log.annotation.LogMethodParam)")
	public void logMethodCall(JoinPoint joinPoint) {

		String traceId = currentTraceContext.get().traceIdString();

		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.info("main -> TraceID: " + traceId + ", Method: " + methodName + ", Parameters: " + Arrays.toString(args));

	}

}
