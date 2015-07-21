package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GrpCrtExecCommand;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GrpCrtExecCommandImpl implements GrpCrtExecCommand {
	
	@Autowired
	private GroupCreateDao groupCreateDao;
	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		 //招待したメンバを作成したGroupに追加
		for(String userName : bean.getSelectUserName()) {
			groupCreateDao.insertData(bean, userName);
		}
		
		/*** メインメッセージ ***/
		bean.getCommon().setMainMessage(CommonConstants.G_CREATE_OK);
		
	}
}
