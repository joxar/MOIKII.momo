package com.devtwt.app.command;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;

@Component
public interface FinalizeCommand {
	
	public void exec(RootBean bean, String viewID);
	
}
