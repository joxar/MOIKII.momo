package com.devtwt.app.dao;

import com.devtwt.app.bean.GroupBean;

public interface GroupDao {
	
	public GroupBean selectGroupById(String groupId);
	public void insertData(GroupBean group);
}
