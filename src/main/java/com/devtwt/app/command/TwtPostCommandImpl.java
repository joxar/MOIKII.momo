package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.MomoDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class TwtPostCommandImpl implements TwtPostCommand {
	
	@Autowired
	MomoDao momo;
	@Autowired
	RootBean bean;
	@Autowired
	UserMasterDao userDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		// TODO Auto-generated method stub
		momo.exec(bean, userName);
		//↓いらない気がする
		bean.getMomo().setCreateName(userDao.getUserName(bean.getMomo().getCreate_id()));
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
