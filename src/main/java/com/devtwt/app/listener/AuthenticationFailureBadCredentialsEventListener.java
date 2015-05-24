package com.devtwt.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

public class AuthenticationFailureBadCredentialsEventListener implements
		ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		
				event.getException().printStackTrace();
}
}
