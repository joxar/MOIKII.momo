package com.devtwt.app.command;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;

@Component
public interface LoginCommandInterface {
	
	RootBean loginProc(RootBean bean);
	
}
