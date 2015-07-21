package com.devtwt.app.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.JoinRequestBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GrpApprvlInitCommand;
import com.devtwt.app.dao.GroupDao;
import com.devtwt.app.dao.JoinRequestDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class GrpApprvlInitCommandImpl implements GrpApprvlInitCommand{
	
	@Autowired
	private RootBean bean;
	@Autowired
	private JoinRequestDao requestDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private UserMasterDao userDao;
	
	List<JoinRequestBean> requestList;
	List<GroupBean> groupList;
	String groupId,memberId;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec() {
		
		//status=REQUESTのJoinRequestデータを全て取得
		requestList = requestDao.getAllRequestData();
		
		for(JoinRequestBean req : requestList) {
			//リクエスト先groupIdからリクエスト先groupを取得
			groupId = req.getCommunityId();
			req.setRequestGroup(groupDao.selectGroupById(groupId));
			
			//リクエストしたユーザのuserIdからリクエストユーザのuserオブジェクトを取得
			memberId = req.getMemberId();
			req.setRequester(userDao.getMember(memberId));
		}
		bean.setJoinRequestList(requestList);
		
	}

}
