package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupShowInfoDao;

@Component
public class GroupNameAllGetCommandImpl implements GroupNameAllGetCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao dao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		bean.setGroupNameList(dao.getAllGroupName());
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}
	
}
