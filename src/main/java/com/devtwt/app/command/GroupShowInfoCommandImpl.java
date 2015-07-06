package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.dao.DevCategoryDao;
import com.devtwt.app.dao.GroupShowInfoDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class GroupShowInfoCommandImpl implements GroupShowInfoCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao dao;
	@Autowired
	private DevCategoryDao devCategoryDao;
	@Autowired
	private UserMasterDao userMasterDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		//セレクトボックスで選択したグループのリストを取得
		bean.setGroupList(dao.getGroupInfo(bean.getGroup().getSlctGroupName()));
		
		List<GroupBean> groupList = bean.getGroupList();
		
		//groupをセット DevCateIdとメンバー名の一覧を取得する必要がある
		String tmp = bean.getGroup().getSlctGroupName();
		bean.setGroup(groupList.get(0));
		bean.getGroup().setSlctGroupName(tmp);
		
		//RootBeanにDevCategoryをセットする
		bean.setDevCategory(devCategoryDao.getDevCategory(bean.getGroup().getDevCategoryId()));
		
		List<UserBean> memberList = new ArrayList<UserBean>();
		//RootBeanにMemberListをセット
		for(GroupBean group : groupList) {
				memberList.add(userMasterDao.getMember(group.getMemberId()));
		}
		bean.getGroup().setMemberList(memberList);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
