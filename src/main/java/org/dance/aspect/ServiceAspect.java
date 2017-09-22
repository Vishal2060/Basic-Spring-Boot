package org.dance.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Aspect
@Component
@Log
public class ServiceAspect {

	@Before("@within(org.springframework.stereotype.Service)")
	public void beforeService(JoinPoint joinPoint) {
		log.info("Before : " + joinPoint.getSignature().getName());
		log.info("with Args : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "@within(org.springframework.stereotype.Service)", returning = "result")
	public void afterReturningService(JoinPoint joinPoint, Object result) {
		log.info("After Returning : " + joinPoint.getSignature().getName());
		log.info("with Result : " + result);
	}

	@AfterThrowing(pointcut = "@within(org.springframework.stereotype.Service)", throwing = "exception")
	public void afterThrowingService(Exception exception) {
		log.info("After Throwing Exception : " + exception.getMessage());
	}
}
