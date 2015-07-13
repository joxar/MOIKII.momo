package com.devtwt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.GrpInfExecCommand;
import com.devtwt.app.command.GrpInfInitCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
@SessionAttributes("rootData")
public class GroupShowInfoController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GrpInfInitCommand grpInfInitCommand;
	@Autowired
	GrpInfExecCommand grpInfExecCommand;
	
	/********************************/
	/****** [グループ]情報参照画面 ******/
	/********************************/
	@RequestMapping(value = "/group/information/init", method = RequestMethod.GET)
	public String grpInfInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
	    
		//画面に表示するために、登録されている全グループのグループ名称を取得
		grpInfInitCommand.preProc(bean);
		grpInfInitCommand.exec();
		bean = grpInfInitCommand.postProc();
		
		model.addAttribute("rootData", bean);
		finalize.exec();
		
		return "groupShowInfo";
	}
	
	@RequestMapping(value = "/group/information/exec", method = RequestMethod.POST)
	public String groupShowInfoTmp(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {
		
		initilize.exec();
		
		//セレクトリストで選択したグループの全メンバと開発カテゴリを取得
		grpInfExecCommand.preProc(bean);
		grpInfExecCommand.exec();
		bean = grpInfExecCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		sessionStatus.setComplete();
		finalize.exec();
		
		return "groupShowInfo";
	}

}
