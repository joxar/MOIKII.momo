package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.constants.CommonConstants;

@Component
public class GrpRjctJoinExecCommandImpl implements MockCommandInterface {
	
	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_REJECT_OK);
	}
}
