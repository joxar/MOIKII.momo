package com.devtwt.app.dao;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

public interface UserMasterDao {
	
	public void exec(RootBean bean);
	public UserBean getMember(String userId);
	public String getUserName(String userId);
	public void updateRoleId(UserBean bean);
	public String getUserId(String userName);
	public void updateProfileId(String userId, String profileId);
	
}
