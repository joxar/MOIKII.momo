package com.devtwt.app.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.ReturnCommentDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class PostReturnCommentCommandImpl implements PostReturnCommentCommand {
	
	@Autowired
	private RootBean bean;
	@Autowired
	UserMasterDao userDao;
	@Autowired
	ReturnCommentDao returnDao;
	
	String userId;
	private final static String DATE_PATTERN ="yyyy-MM-dd HH:mm:ss";

	@Override
	public void preProc(RootBean bean) {
		// TODO Auto-generated method stub
		this.bean = bean;
	}

	@Override
	public void exec(String userName) {
		
		bean.getReturnComment().setCreateName(userName);
		
		// ログインアカウント名称からユーザIDを取得し、ReturnCommentにセット

		userId = userDao.getUserId(userName);

		bean.getReturnComment().setCreate_id(userId);
		bean.getReturnComment().setUpdate_id(userId);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		
		bean.getReturnComment().setCreate_date(sdf.format(date));
		bean.getReturnComment().setUpdate_date(sdf.format(date));

		returnDao.insertData(bean.getReturnComment());
	}

	@Override
	public RootBean postProc() {
		// TODO Auto-generated method stub
		return bean;
	}

}
