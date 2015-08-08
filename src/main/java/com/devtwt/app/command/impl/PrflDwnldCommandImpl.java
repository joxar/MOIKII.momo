package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.PrflDwnldCommand;
import com.devtwt.app.dao.ProfileImageDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class PrflDwnldCommandImpl implements PrflDwnldCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	ProfileImageDao profileImageDao;
	@Autowired
	UserMasterDao userDao;
	@Autowired
	UserBean user;
	String userId,imgId;
	

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec(String userName) {
		
		userId = userDao.getUserId(userName);
		user = userDao.getMember(userId);
		
		imgId = user.getProfileImageId();
		
		bean.setProfileImage(profileImageDao.selectBinaryById(imgId));

	}

}
