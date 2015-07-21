package com.devtwt.app.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RoleBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.GrpChngRoleTmpCommand;
import com.devtwt.app.dao.DevCategoryDao;
import com.devtwt.app.dao.GroupShowInfoDao;
import com.devtwt.app.dao.RoleDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class GrpChngRoleTmpCommandImpl implements GrpChngRoleTmpCommand  {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private GroupShowInfoDao grpShowInfodao;
	@Autowired
	private DevCategoryDao devCategoryDao;
	@Autowired
	private UserMasterDao userMasterDao;
	@Autowired
	private RoleDao roleDao;
	
	String tmp;
	List<RoleBean> roleList;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec() {
		//セレクトボックスで選択したグループのリストを取得
		bean.setGroupList(grpShowInfodao.getGroupInfo(bean.getGroup().getSlctGroupName()));
		
		List<GroupBean> groupList = bean.getGroupList();
		
		//groupをセット DevCateIdとメンバー名の一覧を取得する必要がある
	    tmp = bean.getGroup().getSlctGroupName();
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
		
		//ROLE_MASTERテーブルに格納されている全Roleを取得
		roleList = roleDao.getAllData();
		
		//リストボックス表示のため、グループの各メンバに全ロール情報をセット
		for(UserBean member : bean.getGroup().getMemberList()) {
			member.setRoleList(roleList);
			member.setSlctRoleId(member.getRoleId());
		} 
	}
}
