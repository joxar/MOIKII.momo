package com.devtwt.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureServiceExceptionEvent;

public class AuthenticationFailureServiceExceptionEventListener implements
		ApplicationListener<AuthenticationFailureServiceExceptionEvent> {

	@Override
	public void onApplicationEvent(
			AuthenticationFailureServiceExceptionEvent event) {
				
		event.getException().printStackTrace();
		
	}
	
	
	

}
