package com.inetum.TpSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("perf")
public class MyPerfLogAspect {
	
	@Pointcut("execution(* com.inetum.TpSpring.service.*.*(..))")
	public void servicePointCut() {
		
	}
	
	@Pointcut("execution(* com.inetum.TpSpring.dao.*.*(..))")
	public void daoPointCut() {
		
	}
	
	Logger log = LoggerFactory.getLogger(MyPerfLogAspect.class);
	
	@Around("execution(* com.inetum.TpSpring.service.*.*(..))")
	public Object doXxxLog(ProceedingJoinPoint pjp) throws Throwable {
		log.trace("<< trace == debut == " + 
			pjp.getSignature().toLongString() + " <<");
		long td=System.nanoTime();
		
		Object objRes = pjp.proceed();
		
		long tf=System.nanoTime();
		log.trace(">> trace == fin == "
			+ pjp.getSignature().toShortString() +
			" [" + (tf-td)/1000000.0 + " ms] >>");
		
		return objRes;
	}
	
	@Before("servicePointCut()")
	public void myAspectBeforeService(JoinPoint jp) throws Throwable {
		log.trace("début d'un service");
	}
	
	@After("servicePointCut()")
	public void myAspectAfterService(JoinPoint jp) throws Throwable {
		log.trace("fin d'un service");
	}
	
	@Before("daoPointCut()")
	public void myAspectBeforeDao(JoinPoint jp) throws Throwable {
		log.trace("début d'un dao");
	}
	
	@After("daoPointCut()")
	public void myAspectAfterDao(JoinPoint jp) throws Throwable {
		log.trace("fin d'un dao");
	}
}
