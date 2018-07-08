package com.demo.ccengine.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CCEngineLoggerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(CCEngineLoggerAspect.class);

	@Before("within(com.demo..*)")
	public void logMethodStart(JoinPoint joinPoint){
		LOGGER.info(joinPoint.getSignature()+" method execution start");
	}
	
	@After("within(com.demo..*)")
	public void logMethodComplete(JoinPoint joinPoint){
		LOGGER.info(joinPoint.getSignature()+" method execution complete");
	}
}
