package com.devtwt.app.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GrpCrtInitCommandImpl implements GrpCrtInitCommand {

	@Autowired
	GroupCreateDao groupCreateDao;
	
	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
	
		//GroupCreate画面に表示する、DevCategoryリストを取得
		List<DevCategoryBean> devCategoryList = groupCreateDao.getAllData();
		bean.getGroup().setDevCategoryList(devCategoryList);
				
		}
	}

