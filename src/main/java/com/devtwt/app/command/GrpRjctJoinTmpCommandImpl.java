package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

@Component
public class GrpRjctJoinTmpCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		List<GroupBean> groupList = new ArrayList<GroupBean>();
		List<UserBean> requesterList = new ArrayList<UserBean>();
		GroupBean group = null;
		UserBean user = null;
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"MOKII.momo", "MOIKII.abc", "MOIKII.def", "MOIKII.ghi", "MOIKII.jkl", "MOIKII.mno"};
		String[] arr3 = {"michel", "taro"};
		String[] arr4 = {"tim", "page"};
		
		/*** グループリスト ***/
		for (int i=0; i<arr1.length; i++) {
			group = new GroupBean();
			/*** グループID **/
			group.setGroupId(arr1[i]);
			/*** グループ名 **/
			group.setGroupName(arr2[i]);
			
			/*** リクエスターリスト ***/			
			if (i == 0) {
				for (int j=0; j<arr3.length; j++) {
					user = new UserBean();
					user.setUserName(arr3[i]);
					requesterList.add(user);
				}
				group.setRequesterList(requesterList);
			} else if (i == 1) {
				for (int j=0; j<arr4.length; j++) {
					user = new UserBean();
					user.setUserName(arr4[i]);
					requesterList.add(user);
				}
				group.setRequesterList(requesterList);
			}
			groupList.add(group);
		}
		this.bean.setGroupList(groupList);
	}
}
