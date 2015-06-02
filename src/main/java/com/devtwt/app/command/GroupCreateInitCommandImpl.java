package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GroupCreateInitCommandImpl implements GroupCreateInitCommand{
	
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
	public void exec() {
		// TODO Auto-generated method stub
		
		List<DevCategoryBean> devCategoryList = groupCreateDao.getAllData();
		bean.getGroup().setDevCategoryList(devCategoryList);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}
	

}
