package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GroupCreateInviteCommandImpl implements GroupCreateInviteCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupCreateDao dao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		// TODO Auto-generated method stub
		dao.insertData(bean, userName);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
