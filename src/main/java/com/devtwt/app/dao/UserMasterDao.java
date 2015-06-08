package com.devtwt.app.dao;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

public interface UserMasterDao {
	
	public void exec(RootBean bean);
	public UserBean getMember(String userId);
	public String getUserName(String userId);
	
}
