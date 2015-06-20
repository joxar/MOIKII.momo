package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.JoinRequestBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.JoinRequestDao;

@Component
public class RejectJoinRefuseCommandImpl implements RejectJoinRefuseCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	JoinRequestDao requestDao;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		for(JoinRequestBean req : bean.getJoinRequestList()) {
			//チェックボックスで選択したJoinRequestのstatusをRefuseにする
			if(req.getCheckRequest()) {
				req.setStatus(CommonConstants.STATUS_REFUSE);
				requestDao.updateStatus(req);
			}
		}
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_REQUEST_REFUSE_OK);
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
