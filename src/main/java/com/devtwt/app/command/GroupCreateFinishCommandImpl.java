package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GroupCreateFinishCommandImpl implements GroupCreateFinishCommand {
	
	@Autowired
	GroupCreateDao groupCreateDao;
	
	@Autowired
	private RootBean bean;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		// TODO Auto-generated method stub
		
		//新規作成したグループを、構成メンバ毎にINSERT
		groupCreateDao.insertData(bean, userName);

	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
