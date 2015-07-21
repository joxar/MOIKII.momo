package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.UserCreateCommand;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class UserCreateCommandImpl implements UserCreateCommand {
	
	@Autowired
	private UserMasterDao userMasterDao;
	
	@Autowired
	RootBean bean;

	@Override
	public void preProc(RootBean bean) {
		this.bean = bean;
	}

	@Override
	public void exec() {
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.A_CREATE_OK);
		
		//設定した情報のユーザをDBにINSERT
		userMasterDao.exec(bean);
		
	}

	@Override
	public RootBean postProc() {
		return null;
	}

}
