package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;

@Component
public class GrpChngRoleInitCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {

		/*** グループ ***/
		List<GroupBean> groupList = new ArrayList<GroupBean>();
		GroupBean group = null;
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"MOKII.momo", "MOIKII.abc", "MOIKII.def", "MOIKII.ghi", "MOIKII.jkl", "MOIKII.mno"};
		for (int i=0; i<arr1.length; i++) {
			group = new GroupBean();
			/*** グループID ***/
			group.setGroupId(arr1[i]);
			/*** グループ名 ***/
			group.setGroupName(arr2[i]);
			groupList.add(group);
		}
		bean.setGroupList(groupList);
		
	}
}
