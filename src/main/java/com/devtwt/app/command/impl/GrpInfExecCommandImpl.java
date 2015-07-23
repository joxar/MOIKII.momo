package com.devtwt.app.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.GrpInfExecCommand;
import com.devtwt.app.dao.DevCategoryDao;
import com.devtwt.app.dao.GroupShowInfoDao;
import com.devtwt.app.dao.UserMasterDao;
import com.devtwt.app.util.UserStatusCheck;

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
		
		// ユーザが選択されたグループのメンバーかどうか判断して参加リクエスト可能フラグを設定		
		String userId = bean.getUser().getUserId();
		String groupId = bean.getGroup().getSlctGroupId();
		UserStatusCheck uscUtil = new UserStatusCheck();
		
		if (uscUtil.checkGroupMember(userId, groupId)) {
			// 参加申請可能フラグ設定
			bean.getView().setRequestable_join(true);
			
			// ユーザが選択されたグループメンバーの場合、ROLEを判断して更新可能フラグを設定
			if (uscUtil.checkGroupUpdatableMember(userId)) {
				// 更新可能フラグ設定
				bean.getView().setUpdatable(true);
			}
			
		} else {
			bean.getView().setRequestable_join(false);
			bean.getView().setUpdatable(false);
		}

	}
}
