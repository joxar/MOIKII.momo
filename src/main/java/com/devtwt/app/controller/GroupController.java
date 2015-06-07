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
import com.devtwt.app.command.GroupCreateFinishCommand;
import com.devtwt.app.command.GroupCreateInitCommand;
import com.devtwt.app.command.GroupMemberInviteCommand;
import com.devtwt.app.command.GroupNameAllGetCommand;
import com.devtwt.app.command.GroupShowInfoCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.MockCommandInterface;

@Controller
@SessionAttributes("rootData")
public class GroupController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GroupCreateInitCommand groupCreateInitCommand;
	@Autowired
	GroupMemberInviteCommand groupMemberInviteCommand;
	@Autowired
	GroupCreateFinishCommand groupCreateFinishCommand;
	@Autowired
	GroupNameAllGetCommand groupNameAllGetCommand;
	@Autowired
	GroupShowInfoCommand groupShowInfoCommand;
	
	MockCommandInterface mc;
	
	/********************************/
	/******** [グループ]作成画面 *******/
	/********************************/
	@RequestMapping(value = "/group/create/init", method = RequestMethod.GET)
	public String groupCreateInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//Development Category取得
        groupCreateInitCommand.preProc(bean);
		groupCreateInitCommand.exec();
		
		//Development Categoryを画面にセット
		model.addAttribute("rootData", groupCreateInitCommand.postProc());
		
		finalize.exec();
		
		return "groupCreate";
	}
	
	@RequestMapping(value = "/group/create/invite", method = RequestMethod.POST)
	public String groupCreateInvite(@ModelAttribute("rootData") RootBean bean, Model model, Principal principal) throws Exception {

		initilize.exec();
		
		//ログインアカウントのUserNameを取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		//グループを新規作成(MEMBERには、ログインアカウントをセット)
		groupCreateFinishCommand.preProc(bean);
		groupCreateFinishCommand.exec(userName);
		
		//ログインアカウント以外のユーザをDBから取得
		groupMemberInviteCommand.preProc(bean);
		groupMemberInviteCommand.exec(userName);
		
		//ログインアカウント以外のユーザを画面にセット
		model.addAttribute("rootData", groupMemberInviteCommand.postProc());
		
		finalize.exec();
		
		return "groupInviteMember";
	}
	
	@RequestMapping(value = "/group/create/select", method = RequestMethod.GET)
	public String groupCreateSelect(@ModelAttribute("rootData") RootBean bean, Model model
			, Principal principal, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		groupCreateFinishCommand.preProc(bean);
		
		 /* 招待したメンバをCOMMUNITYテーブルにINSERT。
		　この時点では、グループ招待を拒否する機能はつけていない。*/
		for(String userName : bean.getSelectUserName()) {
			groupCreateFinishCommand.exec(userName);
		}
		
		sessionStatus.setComplete();

		finalize.exec();
		
		return "twt";
	}

}
