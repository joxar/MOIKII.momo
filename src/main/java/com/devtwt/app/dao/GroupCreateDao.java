package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

public interface GroupCreateDao {
	
	public List<DevCategoryBean> getAllData();
	public void dropTable();
	public void createTable();
	public void insertData(RootBean bean, String userName);
	public List<UserBean> getAllMember(String userName);

}
