package com.devtwt.app.controller;

import java.security.Principal;
import java.util.List;

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

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.GroupCreateInitCommand;
import com.devtwt.app.command.GroupCreateInviteCommand;
import com.devtwt.app.command.GroupMemberInviteCommand;
import com.devtwt.app.command.GrpCrtExecCommandImpl;
import com.devtwt.app.command.GrpCrtInitCommandImpl;
import com.devtwt.app.command.GrpCrtTmpCommandImpl;
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
	GroupCreateInviteCommand groupCreateInviteCommand;
	@Autowired
	GroupMemberInviteCommand groupMemberInviteCommand;
	
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
		
		//Development Categoryセット
		model.addAttribute("rootData", groupCreateInitCommand.postProc());
		
		finalize.exec();
		
		return "groupCreate";
	}
	
	/*@RequestMapping(value = "/group/create/tmp", method = RequestMethod.POST)
	public String groupCreateTmp(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpCrtTmpCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupCreate";
	}*/
	
	/*@RequestMapping(value = "/group/create/exec", method = RequestMethod.POST)
	public String groupCreateExec(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpCrtExecCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupCreate";
	}*/
	
	@RequestMapping(value = "/group/create/invite", method = RequestMethod.POST)
	public String groupCreateInvite(@ModelAttribute("rootData") RootBean bean, Model model, Principal principal) throws Exception {

		initilize.exec();
		logger.info("DataLog:" + bean);
		
		//UserNameを取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		//ログインアカウント以外のユーザをDBから取得
		groupMemberInviteCommand.preProc(bean);
		groupMemberInviteCommand.exec(userName);
		
		//ログインアカウント以外のユーザを画面にセット
		model.addAttribute("rootData", groupMemberInviteCommand.postProc());
		
		logger.info("LOGU:" + groupMemberInviteCommand.postProc());
		logger.info("LOGU2:" + bean);
		
		finalize.exec();
		
		return "groupInviteMember";
	}
	
	@RequestMapping(value = "/group/create/select", method = RequestMethod.GET)
	public String groupCreateSelect(@ModelAttribute("rootData") RootBean bean, Model model, Principal principal) throws Exception {

		initilize.exec();
		
		for(String s : bean.getSelectUserId()) {
			logger.info("LOG2:" + s);
		}
		logger.info("FInal:" + bean);
		finalize.exec();
		
		return "twt";
	}
	

}
