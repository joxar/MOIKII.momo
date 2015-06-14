package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.RoleBean;

public interface RoleDao {
	
	public List<RoleBean> getAllData();
	public String getRoleName(String roleId);

}
