package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.TwtPostCommand;
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
	int tmp;
	String momoNum;

	@Override
	public void preProc(RootBean bean) {
		this.bean = bean;
	}

	@Override
	public void exec(String userName, String groupId) {
		bean.getMomo().setGroupId(groupId);
		momo.exec(bean, userName);
		
		//ここで追加したMOMOのIDを取得し、Beanにセット
		tmp = momo.selectMaxMomoNum();
		momoNum = Integer.toString(tmp);
		bean.getMomo().setMomoNum(momoNum);
		
		//画面に表示するため、投稿者名をbeanにセット
		bean.getMomo().setCreateName(userDao.getUserName(bean.getMomo().getCreate_id()));
	}

	@Override
	public RootBean postProc() {
		return bean;
	}

}
