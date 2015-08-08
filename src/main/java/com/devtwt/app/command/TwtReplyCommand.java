package com.devtwt.app.command;

import com.devtwt.app.bean.RootBean;

public interface TwtReplyCommand {
	
	void preProc(RootBean bean);
	void exec(String userName, String groupId);
	RootBean postProc();
}
