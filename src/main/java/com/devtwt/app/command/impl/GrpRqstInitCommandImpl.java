package com.devtwt.app.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GrpRqstInitCommand;
import com.devtwt.app.dao.GroupShowInfoDao;

@Component
public class GrpRqstInitCommandImpl implements GrpRqstInitCommand {

	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao grpShowInfodao;

	@Override
	public RootBean postProc() { return bean; }
	
	@Override
	public void preProc(RootBean bean) { this.bean = bean; }

	@Override
	public void exec() {
		
		//登録されている全グループのグループ名称を取得
		bean.setGroupNameList(grpShowInfodao.getAllGroupName());
	}
	
}
