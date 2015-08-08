package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.GroupBean;

public interface GroupShowInfoDao {
	
	
	public List<String> getAllGroupName();
	public List<GroupBean> getGroupInfo(String slctGroupName);

}
