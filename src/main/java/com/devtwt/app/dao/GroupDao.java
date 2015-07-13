package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.GroupBean;

public interface GroupDao {
	
	public GroupBean selectGroupById(String groupId);
	public void insertData(GroupBean group);
	public List<GroupBean> selectGroupListBymemberId(String memberId);
}
