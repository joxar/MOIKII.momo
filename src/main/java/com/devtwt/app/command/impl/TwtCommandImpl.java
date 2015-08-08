package com.devtwt.app.command.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.ReturnCommentBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.TwtCommand;
import com.devtwt.app.dao.GroupDao;
import com.devtwt.app.dao.MomoDao;
import com.devtwt.app.dao.ReturnCommentDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class TwtCommandImpl implements TwtCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	MomoDao momoDao;
	@Autowired
	UserMasterDao userDao;
	@Autowired
	ReturnCommentDao returnDao;
	@Autowired
	GroupDao groupDao;
	
	List<ReturnCommentBean> childList;
	List<UserBean> userList = new ArrayList<UserBean>();
	List<GroupBean> groupList;
	int count;
	String id2,memberId;
	
	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec(String userName, String groupId) {
		
		String id;
		
		//選択グループに該当する全履歴コメント(momo)を取得
		List<MomoBean> momoList = momoDao.getAllData(groupId);
		bean.setMomoList(momoList);
		
		//コメントの投稿者の情報を取得
		for(MomoBean momo : momoList) {
			id = null;
			id = momo.getCreate_id();
			if(id != null && id.length() != 0) {
				momo.setCreateName(userDao.getUserName(momo.getCreate_id()));
			}	
		}
		bean.getMomo().setUserList(userList);
		
		for(MomoBean momo : bean.getMomoList()) {
			//childListに該当Momo配下の返信コメントをセット
			childList = returnDao.selectReturnCommentListByMomoId(momo.getMomoNum(), groupId);
			momo.setChildList(childList);
			
			//各momoの返信コメントの数をセット
			count = childList.size();
			count--;
			momo.setChildCount(count);
			
			//ReturnCommentBeanに投稿者名をセット
			for(ReturnCommentBean child : childList) {
				id2 = null;
				id2 = child.getCreate_id();
				
				if(id2 != null && id2.length() != 0) {
					child.setCreateName(userDao.getUserName(id2));
				}	
			}
		}
		
		//ログインしたアカウントのIDから、所属しているグループを全て取得
		memberId = userDao.getUserId(userName);
		groupList = groupDao.selectGroupListBymemberId(memberId);
		bean.getUser().setGroupList(groupList);
		
	}

	

}
