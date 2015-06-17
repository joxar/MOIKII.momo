package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.JoinRequestDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class JoinRequestCommandImpl implements JoinRequestCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	JoinRequestDao joinRequestDao;
	@Autowired
	UserMasterDao userDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		// TODO Auto-generated method stub
		
		//セレクトボックスで選択したグループのIDを取得
		List<GroupBean> groupList =bean.getGroupList();
		String slctGroupId = groupList.get(0).getGroupId();
		bean.getGroup().setSlctGroupId(slctGroupId);
		
		//UserNameから、UserIdを取得
		bean.getJoinRequest().setMemberId(userDao.getUserId(userName));
		
		//JoinRequest情報をテーブルにセットする
		joinRequestDao.insertData(bean);
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_REQ_OK);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}
	

}
