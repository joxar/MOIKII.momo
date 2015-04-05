package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

@Component
public class GrpChngRoleTmpCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {

		/*** 定数リスト ***/
		this.bean.setConstants(bean.getConstants());
		
		/*** グループリスト ***/
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
		
		List<UserBean> memberList = new ArrayList<UserBean>();
		UserBean user = null;
		String[] arr1_1 = {"01", "02", "03"};
		String[] arr1_2 = {"taro", "jiro", "saburo"};
		String[] arr2_1 = {"0", "1"};
		String[] arr2_2 = {"user", "admin"};
		
		/*** メンバーリスト ***/
		for (int i=0; i<arr1_1.length; i++) {
			user = new UserBean();
			/*** メンバーID ***/
			user.setUserId(arr1_1[i]);
			/*** メンバー名 ***/
			user.setUserName(arr1_2[i]);
			for (int j=0; j<arr2_1.length; j++) {
				/*** メンバーロールID ***/
				user.setRoleId(arr2_1[j]);
				/*** メンバーロール名 ***/
				user.setRoleName(arr2_2[j]);
			}
			memberList.add(user);
		}
		bean.getGroup().setMemberList(memberList);
		
	}
}
