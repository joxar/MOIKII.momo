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
public class GrpInfExecCommandImpl implements GrpInfExecCommand {

	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao dao;
	@Autowired
	private DevCategoryDao devCategoryDao;
	@Autowired
	private UserMasterDao userMasterDao;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
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
}
