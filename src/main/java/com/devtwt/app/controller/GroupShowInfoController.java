package com.devtwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.devtwt.app.command.GroupNameAllGetCommand;
import com.devtwt.app.command.GroupShowInfoCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
@SessionAttributes("rootData")
public class GroupShowInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GroupNameAllGetCommand groupNameAllGetCommand;
	@Autowired
	GroupShowInfoCommand groupShowInfoCommand;
	
	/********************************/
	/****** [グループ]情報参照画面 ******/
	/********************************/
	@RequestMapping(value = "/group/showInfo/init", method = RequestMethod.GET)
	public String groupShowInfoInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
	    
		groupNameAllGetCommand.preProc(bean);
		groupNameAllGetCommand.exec();
		model.addAttribute("rootData", groupNameAllGetCommand.postProc());
		finalize.exec();
		
		return "groupShowInfo";
	}
	
	@RequestMapping(value = "/group/showInfo/tmp", method = RequestMethod.POST)
	public String groupShowInfoTmp(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {
		
		initilize.exec();
		
		groupShowInfoCommand.preProc(bean);
		groupShowInfoCommand.exec();
		model.addAttribute("rootData", groupShowInfoCommand.postProc());
		
		sessionStatus.setComplete();
		finalize.exec();
		
		return "groupShowInfo";
	}

}
