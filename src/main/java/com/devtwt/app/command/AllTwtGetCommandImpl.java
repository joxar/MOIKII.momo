package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.dao.MomoDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class AllTwtGetCommandImpl implements AllTwtGetCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	MomoDao momoDao;
	@Autowired
	UserMasterDao userDao;
	
	List<UserBean> userList = new ArrayList<UserBean>();

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		String id;
		//タイムラインの全履歴を取得
		List<MomoBean> momoList = momoDao.getAllData();
		bean.setMomoList(momoList);
		
		//コメントの投稿者の情報を取得
		for(MomoBean momo : momoList) {
			id = null;
			id = momo.getCreate_id();
			if(id != null && id.length() != 0) {
				System.out.println("ID:" + id);
				momo.setCreateName(userDao.getUserName(momo.getCreate_id()));
			}	
		}
		bean.getMomo().setUserList(userList);

	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}
}
