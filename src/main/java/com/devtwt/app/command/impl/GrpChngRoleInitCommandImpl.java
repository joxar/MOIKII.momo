package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GrpChngRoleInitCommand;
import com.devtwt.app.dao.GroupShowInfoDao;

@Component
public class GrpChngRoleInitCommandImpl implements GrpChngRoleInitCommand{
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao dao;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec() {
		//全グループのグループ名称を取得
		bean.setGroupNameList(dao.getAllGroupName());
	}
}
