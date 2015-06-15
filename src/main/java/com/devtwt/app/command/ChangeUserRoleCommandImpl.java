package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class ChangeUserRoleCommandImpl implements ChangeUserRoleCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private UserMasterDao userDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_CHANGE_ROLE_OK);
		
		for(UserBean member : bean.getGroup().getMemberList()) {
			userDao.updateRoleId(member);
		}
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}