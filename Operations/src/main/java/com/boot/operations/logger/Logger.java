package com.boot.operations.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	 private final Log log = LogFactory.getLog(this.getClass());

	    public Logger () {}
	   /* 
	    @Before("execution(* com.boot.operations..*.*(..))")
	    public void logMethodAccessBefore(JoinPoint joinPoint) {
	        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	        System.out.println("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	    }
	    
	    @Around("execution(* com.boot.operations..*.*(..))")
	    public void logMethodAccessBefore(ProceedingJoinPoint  joinPoint) throws Throwable { 
	        log.info("***** Before: " + joinPoint.getSignature().getName() + " *****");
	        System.out.println("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	        joinPoint.proceed();
	        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	        System.out.println("***** After: " + joinPoint.getSignature().getName() + " *****");
	    }
	    
	    @AfterReturning(pointcut="execution(* com.boot.operations..*.*(..))",returning="result")
	    public void logMethodAccessAfter(JoinPoint joinPoint,Object result) {
	        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	        System.out.println("***** Starting: " + joinPoint.getSignature().getName() + " *****");
	    }*/
}
