package com.devtwt.app.command;

import com.devtwt.app.bean.RootBean;

public interface GrpCrtInviteCommand {
	
	void preProc(RootBean bean);
	void exec(String userName);
	RootBean postProc();

}
