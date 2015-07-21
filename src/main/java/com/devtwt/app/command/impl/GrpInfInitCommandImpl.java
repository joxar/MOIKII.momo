package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GrpInfInitCommand;
import com.devtwt.app.dao.GroupShowInfoDao;

@Component
public class GrpInfInitCommandImpl implements GrpInfInitCommand {

	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao dao;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		//登録されている全グループのグループ名称を取得
		bean.setGroupNameList(dao.getAllGroupName());
		
	}
}
