package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.JoinRequestBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.GroupDao;
import com.devtwt.app.dao.JoinRequestDao;

@Component
public class RejectJoinApproveCommandImpl implements RejectJoinApproveCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	JoinRequestDao requestDao;
	@Autowired
	GroupDao groupDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		for(JoinRequestBean req : bean.getJoinRequestList()) {
			//チェックボックスで選択したJoinRequestのstatusをApproveにする
			if(req.getCheckRequest()) {
				req.setStatus(CommonConstants.STATUS_APPROVE);
				requestDao.updateStatus(req);
				
				//JoinRequestを申請したメンバをリクエスト先Groupに追加
				req.getRequestGroup().setMemberId(req.getRequester().getUserId());
				groupDao.insertData(req.getRequestGroup());
			}
		}
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_REQUEST_APPROVE_OK);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
