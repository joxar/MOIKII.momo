package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.DaoInterface;
import com.devtwt.app.dao.DbacMockDaoImpl;

@Component
public class LoginCommandImpl implements LoginCommandInterface {
	
	DaoInterface dao = new DbacMockDaoImpl();
	@Autowired
	RootBean bean;

	public RootBean loginProc(RootBean bean) {
		return bean;
	}
	
}
