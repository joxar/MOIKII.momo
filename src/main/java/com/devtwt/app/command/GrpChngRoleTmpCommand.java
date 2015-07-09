package com.devtwt.app.command;

import com.devtwt.app.bean.RootBean;

public interface GrpChngRoleTmpCommand {
	
	void preProc(RootBean bean);
	void exec();
	RootBean postProc();

}
