package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.ReturnCommentBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.MomoDao;
import com.devtwt.app.dao.ReturnCommentDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class AllReplyGetCommandImpl implements AllReplyGetCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	MomoDao momoDao;
	@Autowired
	ReturnCommentDao returnDao;
	@Autowired
	UserMasterDao userDao;
	
	List<ReturnCommentBean> childList;
	int count;
	String id;

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
			
			//各momoの返信コメントの数をセット
			count = childList.size();
			count--;
			momo.setChildCount(count);
			
			//ReturnCommentBeanに投稿者名をセット
			for(ReturnCommentBean child : childList) {
				id = null;
				id = child.getCreate_id();
				
				if(id != null && id.length() != 0) {
					child.setCreateName(userDao.getUserName(id));
				}	
			}
		}
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
