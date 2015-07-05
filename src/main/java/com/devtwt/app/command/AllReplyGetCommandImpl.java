package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.ReturnCommentBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.MomoDao;
import com.devtwt.app.dao.ReturnCommentDao;

@Component
public class AllReplyGetCommandImpl implements AllReplyGetCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	MomoDao momoDao;
	@Autowired
	ReturnCommentDao returnDao;
	
	List<ReturnCommentBean> childList;
	int count;

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		for(MomoBean momo : bean.getMomoList()) {
			childList = returnDao.selectReturnCommentListByMomoId(momo.getMomoNum());
			momo.setChildList(childList);
			count = childList.size();
			count--;
			momo.setChildCount(count);
		}
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
