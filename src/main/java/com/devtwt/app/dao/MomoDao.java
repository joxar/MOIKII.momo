package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.MomoBean;

public interface MomoDao {
	
	public void exec(RootBean bean);
	public List<MomoBean> getAllData();

}
