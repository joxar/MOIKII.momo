package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.GrpChngRoleExecCommand;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class GrpChngRoleExecCommandImpl implements GrpChngRoleExecCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private UserMasterDao userDao;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec() {
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_CHANGE_ROLE_OK);
		
		//画面で変更されたメンバーのロールをDBに適用
		for(UserBean member : bean.getGroup().getMemberList()) {
			userDao.updateRoleId(member);
		}	
	}
}
