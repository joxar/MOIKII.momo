package com.devtwt.app.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.devtwt.app.command.JoinRequestCommand;

@Controller
@SessionAttributes("rootData")
public class GroupJoinRequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupCreateController.class);
	
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
	@Autowired
	JoinRequestCommand joinRequestCommand;
	
	/********************************/
	/****** [グループ]参加申請画面 ******/
	/********************************/
	@RequestMapping(value = "/group/reqJoin/init", method = RequestMethod.GET)
	public String groupRequestJoinInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
	    
		//DBに登録されているGroup情報を全て取得
		groupNameAllGetCommand.preProc(bean);
		groupNameAllGetCommand.exec();
		model.addAttribute("rootData", groupNameAllGetCommand.postProc());
		
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/reqJoin/tmp", method = RequestMethod.POST)
	public String groupRequestJoinTmp(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//セレクトボックスで選択したグループの情報を取得
		groupShowInfoCommand.preProc(bean);
		groupShowInfoCommand.exec();
		model.addAttribute("rootData", groupShowInfoCommand.postProc());
		
		
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/reqJoin/exec", method = RequestMethod.POST)
	public String groupRequestJoinExec(@ModelAttribute("rootData") RootBean bean, Model model
			, Principal principal, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		//JoinRequestしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		//JoinRequestをDBにINSERT
		joinRequestCommand.preProc(bean);
		joinRequestCommand.exec(userName);
		model.addAttribute("rootData", joinRequestCommand.postProc());
		
		sessionStatus.setComplete();
		finalize.exec();
		
		return "groupRequestJoin";
	}

}
