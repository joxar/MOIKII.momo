package com.devtwt.app.controller;

import java.security.Principal;

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
import com.devtwt.app.command.GrpCrtExecCommand;
import com.devtwt.app.command.GrpCrtInitCommand;
import com.devtwt.app.command.GrpCrtInviteCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
@SessionAttributes("rootData")
public class GroupCreateController {
		
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GrpCrtInitCommand grpCrtInitCommand;
	@Autowired
	GrpCrtInviteCommand grpCrtInviteCommand;
	@Autowired
	GrpCrtExecCommand grpCrtExecCommand;
	
	/********************************/
	/******** [グループ]作成画面 *******/
	/********************************/
	@RequestMapping(value = "/group/create/init", method = RequestMethod.GET)
	public String grpCrtInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//画面に表示するために、全Development Categoryを取得
		grpCrtInitCommand.preProc(bean);
		grpCrtInitCommand.exec();
		this.bean = grpCrtInitCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupCreate";
	}
	
	@RequestMapping(value = "/group/create/invite", method = RequestMethod.POST)
	public String grpCrtInvite(@ModelAttribute("rootData") RootBean bean, Model model, Principal principal) throws Exception {

		initilize.exec();
		
		//ログインアカウントのUserNameを取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		/*グループを新規作成(MEMBERには、ログインアカウントのみをセット)し、
		  ログインアカウント以外のーザを取得*/
		grpCrtInviteCommand.preProc(bean);
		grpCrtInviteCommand.exec(userName);
		this.bean = grpCrtInviteCommand.postProc();
		
		//ログインアカウント以外のユーザを画面にセット
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupInviteMember";
	}
	
	@RequestMapping(value = "/group/create/exec", method = RequestMethod.GET)
	public String grpCrtExec(@ModelAttribute("rootData") RootBean bean, Model model
			, Principal principal, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		 //招待したメンバをGroupに追加
		grpCrtExecCommand.preProc(bean);
		grpCrtExecCommand.exec();
		this.bean = grpCrtExecCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		sessionStatus.setComplete();

		finalize.exec();
		
		return "groupInviteMember";
	}

}
