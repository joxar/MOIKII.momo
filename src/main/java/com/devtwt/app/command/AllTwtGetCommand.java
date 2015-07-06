package com.devtwt.app.command;

import java.util.List;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;

public interface AllTwtGetCommand {
	
	void preProc(RootBean bean);
	void  exec();
	RootBean postProc();

}
