package com.devtwt.app.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MoikiiLogger {
	
	@Before("execution(* com.devtwt.app.command.*.*(..))")
	public void before() {
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}
	
	@After("execution(* com.devtwt.app.command.*.*(..))")
	public void after() {
		System.out.println("AFFFBBFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
	}
	
}
