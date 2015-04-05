package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.constants.CommonConstants;

@Component
public class GrpCrtExecCommandImpl implements MockCommandInterface {
	
	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		/*** 開発カテゴリ ***/
		DevCategoryBean dev;
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"ウォーターフォール", "プロトタイピング", "インクリメンタル", "スパイラル", "RAD", "エクストリームプログラミング"};
		
		/*** メインメッセージ ***/
		this.bean.getCommon().setMainMessage(CommonConstants.G_CREATE_OK);

		/*** 開発カテゴリ */
		for (int i=0; i<arr1.length; i++) {
			dev = new DevCategoryBean();
			/*** カテゴリID ***/
			dev.setDevCategoryId(arr1[i]);
			/*** カテゴリ名 ***/
			dev.setDevCategoryName(arr2[i]);
			bean.getGroup().getDevCategoryList().add(dev);
		}

		/*** メンバーリスト ***/
		UserBean user = null;
		String[] arr3 = {"01"};
		String[] arr4 = {"member1(セッションからとる)"};
		List<UserBean> memberList = new ArrayList<UserBean>();
		
		/*** メンバーリスト ***/
		for (int i=0; i<arr3.length; i++) {
			user = new UserBean();
			/*** メンバーID ***/
			user.setUserId(arr3[i]);
			/*** メンバー名 ***/
			user.setUserName(arr4[i]);
			memberList.add(user);
		}
		this.bean.getGroup().setMemberList(memberList);
		
		/*** フェーズ名リスト ***/
		this.bean.getGroup().getDevCategory().setPhNameList(bean.getGroup().getDevCategory().getPhNameList());
		
		/*** 被選択開発カテゴリ ***/
		this.bean.getGroup().setSlctDevCateId(bean.getGroup().getSlctDevCateId());
	}
}
