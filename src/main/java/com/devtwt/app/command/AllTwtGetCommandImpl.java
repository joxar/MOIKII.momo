package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.MomoDao;

@Component
public class AllTwtGetCommandImpl implements AllTwtGetCommand {
	
	@Autowired
	MomoDao momoDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MomoBean> exec() {
		// TODO Auto-generated method stub
		List<MomoBean> momoList = momoDao.getAllData();
		
		return momoList;
		
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
