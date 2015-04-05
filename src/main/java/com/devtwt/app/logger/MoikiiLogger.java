package com.devtwt.app.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;

@Aspect
@Component
public class MoikiiLogger {
	
	String cName = "";
	String mName = "";
	String msg = "";
	@Autowired
	RootBean bean;
	
	@Before("execution(* com.devtwt.app.command..*.*(..))")
	public void before(JoinPoint point) {
		cName = point.getTarget().getClass().getName();
		mName = point.getSignature().getName();
		msg = "START";
		outputMsg(cName+"#"+mName+"()", msg);
		dispBean();
	}	
	
	@After("execution(* com.devtwt.app.command..*.*(..))")
	public void after(JoinPoint point) {
		cName = point.getTarget().getClass().getName();
		mName = point.getSignature().getName();
		msg = "END";
		outputMsg(cName+"#"+mName+"()", msg);
		dispBean();
	}
	
	private void dispBean() {
		System.out.println(this.bean);
	}

	private void outputMsg(String target, String msg) {
		
		String timeStamp = "";
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		timeStamp = sdf.format(now.getTime());
		
		System.out.println(timeStamp + "  " + target + " ----- " + msg);
	}
	
}
