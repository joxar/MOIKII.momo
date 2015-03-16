package com.devtwt.app.command;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;

@Component
public interface MockCommandInterface {
	
	void preProc(RootBean bean);
	void exec();
	RootBean postProc();
	
}
