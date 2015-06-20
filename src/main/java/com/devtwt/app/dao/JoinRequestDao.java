package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.JoinRequestBean;
import com.devtwt.app.bean.RootBean;

public interface JoinRequestDao {
	
	public void insertData(RootBean bean);
	public List<JoinRequestBean> getAllRequestData();
	public void updateStatus(JoinRequestBean req);
}
