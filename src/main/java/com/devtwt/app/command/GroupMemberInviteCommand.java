package com.devtwt.app.command;

import com.devtwt.app.bean.RootBean;

public interface GroupMemberInviteCommand {
	
	void preProc(RootBean bean);
	void exec(String userName);
	RootBean postProc();

}
