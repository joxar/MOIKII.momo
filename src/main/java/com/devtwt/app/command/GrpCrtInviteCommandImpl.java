package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.GroupCreateDao;

@Component
public class GrpCrtInviteCommandImpl implements GrpCrtInviteCommand {
	
	@Autowired
	private GroupCreateDao groupCreateDao;
	
	@Autowired
	private RootBean bean;

	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec(String userName) {
				
		//新規作成したグループを、構成メンバ毎にINSERT
		groupCreateDao.insertData(bean, userName);
		
		//ログインアカウント以外の全登録ユーザを画面に表示するために取得する
		bean.getGroup().setMemberList(groupCreateDao.getAllMember(userName));
		
		}
}
