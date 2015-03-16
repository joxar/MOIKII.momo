package com.devtwt.app.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MoikiiLogger {
	
	@Before("execution(* exec(..))")
	public void outMsgBefCommand() {
		System.out.println("bef");
	}
	
	@After("execution(* exec(..))")
	public void outMsgAftCommand() {
		System.out.println("aft");
	}
	
}
