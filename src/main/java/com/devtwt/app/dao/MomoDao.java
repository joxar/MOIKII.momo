package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.MomoBean;

public interface MomoDao {
	
	public void exec(RootBean bean, String userName);
	public List<MomoBean> getAllData(String groupId);

}
