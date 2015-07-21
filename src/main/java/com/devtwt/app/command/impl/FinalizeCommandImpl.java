package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;

@Component
public class FinalizeCommandImpl implements FinalizeCommand {
	
	public void exec(RootBean bean, String viewID) {
		bean.getView().setViewID(viewID);
	};	
}
