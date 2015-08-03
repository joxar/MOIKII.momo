package com.devtwt.app.dao;

import com.devtwt.app.bean.ProfileImageBean;
import com.devtwt.app.bean.RootBean;

public interface ProfileImageDao {
	
	public void insertData(RootBean bean);
	public ProfileImageBean selectBinaryById(String Id);;

}
