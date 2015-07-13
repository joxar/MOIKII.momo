package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class GetBelongingGroupsCommandImpl implements GetBelongingGroupsCommand{
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private UserMasterDao userDao;
	
	String memberId;
	List<GroupBean> groupList;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		// TODO Auto-generated method stub
		
		//ログインしたアカウントのIDから、所属しているグループを全て取得
		memberId = userDao.getUserId(userName);
		groupList = groupDao.selectGroupListBymemberId(memberId);
		bean.getUser().setGroupList(groupList);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}
	
	

}
