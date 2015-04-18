package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
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
		userMasterDao.exec(bean);
	}

	@Override
	public RootBean postProc() {
		return null;
	}

}
