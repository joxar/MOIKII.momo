package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

@Component
public class GrpRjctJoinInitCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		
		List<GroupBean> groupList = new ArrayList<GroupBean>();
		GroupBean group = null;
		UserBean user = null;
		String[] arr1 = {"01", "02"};
		String[] arr2 = {"MOKII.momo", "MOIKII.abc"};
		String[] arr3 = {"michel", "taro"};
		String[] arr4 = {"tim", "page", "tate"};
		
		/*** グループリスト ***/
		for (int i=0; i<arr1.length; i++) {
			group = new GroupBean();
			/*** グループID ***/
			group.setGroupId(arr1[i]);
			/*** グループ名 ***/
			group.setGroupName(arr2[i]);
			
			/*** リクエスターリスト ***/			
			List<UserBean> requesterList = null;
			if (i == 0) {
				requesterList = new ArrayList<UserBean>();
				for (int j=0; j<arr3.length; j++) {
					user = new UserBean();
					user.setUserName(arr3[j]);
					requesterList.add(user);
				}
			} else if (i == 1) {
				requesterList = new ArrayList<UserBean>();
				for (int j=0; j<arr4.length; j++) {
					user = new UserBean();
					user.setUserName(arr4[j]);
					requesterList.add(user);
				}
			}
			group.setRequesterList(requesterList);
			groupList.add(group);
		}
		this.bean.setGroupList(groupList);
	}
}
