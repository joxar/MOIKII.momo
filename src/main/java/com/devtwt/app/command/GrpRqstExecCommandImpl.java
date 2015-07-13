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
public class GrpRqstExecCommandImpl implements GrpRqstExecCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	private JoinRequestDao joinRequestDao;
	@Autowired
	private UserMasterDao userDao;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec(String userName) {
		
		//セレクトボックスで選択したグループのIDを取得
		List<GroupBean> groupList =bean.getGroupList();
		String slctGroupId = groupList.get(0).getGroupId();
		bean.getGroup().setSlctGroupId(slctGroupId);
		
		//UserNameから、UserIdを取得(JoinRequestしたアカウントを特定するため)
		bean.getJoinRequest().setMemberId(userDao.getUserId(userName));
		
		//JoinRequest情報をテーブルにセットする
		joinRequestDao.insertData(bean);
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_REQ_OK);
	}
	
}
