package com.example.task2.log.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.task2.log.annotation.LogMethodParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogMethodParamImpl {

	@Before("@annotation(com.example.task2.log.annotation.LogMethodParam)")
	public void logMethodCall(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		log.info("task2 -> Method: " + methodName + ", Parameters: " + Arrays.toString(args));
	}

}
