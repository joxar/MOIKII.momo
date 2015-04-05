package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

@Component
public class GrpShwInfTmpCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		List<GroupBean> groupList = new ArrayList<GroupBean>();
		List<UserBean> memberList = new ArrayList<UserBean>();
		List<String> phNameList = new ArrayList<String>();
		GroupBean group = null;
		UserBean user = null;
		DevCategoryBean devCate = null;
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"MOKII.momo", "MOIKII.abc", "MOIKII.def", "MOIKII.ghi", "MOIKII.jkl", "MOIKII.mno"};
		String[] arr3 = {"john", "mac", "kevin", "will", "sam"};
		String[] arr4 = {"BD", "SD", "CD", "UT", "LT", "ST", "UAT"};
		String devCateName = "アジャイル";
		
		/*** グループリスト ***/
		for (int i=0; i<arr1.length; i++) {
			group = new GroupBean();
			/*** グループID **/
			group.setGroupId(arr1[i]);
			/*** グループ名 **/
			group.setGroupName(arr2[i]);
			groupList.add(group);
		}
		this.bean.setGroupList(groupList);
		
		/*** フェーズ名リスト ***/
		for (int i=0; i<arr4.length; i++) {
			devCate = new DevCategoryBean();
			phNameList.add(arr4[i]);
			devCate.setPhNameList(phNameList);
		}
		/*** 開発カテゴリ名 ***/
		devCate.setDevCategoryName(devCateName);
		this.bean.getGroup().setDevCategory(devCate);
		
		/*** メンバーリスト ***/
		for (int i=0; i<arr3.length; i++) {
			user = new UserBean();
			user.setUserName(arr3[i]);
			memberList.add(user);
		}
		this.bean.getGroup().setMemberList(memberList);
		
	}
}
