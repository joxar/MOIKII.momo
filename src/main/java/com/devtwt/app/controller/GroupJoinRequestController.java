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
import com.devtwt.app.command.GrpRqstExecCommand;
import com.devtwt.app.command.GrpRqstInitCommand;
import com.devtwt.app.command.GrpRqstTmpCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
@SessionAttributes("rootData")
public class GroupJoinRequestController {
		
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GrpRqstInitCommand grpRqstInitCommand;
	@Autowired
	GrpRqstTmpCommand grpRqstTmpCommand;
	@Autowired
	GrpRqstExecCommand grpRqstExecCommand;
	
	/********************************/
	/****** [グループ]参加申請画面 ******/
	/********************************/
	@RequestMapping(value = "/group/request/init", method = RequestMethod.GET)
	public String grpRqstInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
	    
		//画面に表示するためにDBに登録されているGroup情報を全て取得
		grpRqstInitCommand.preProc(bean);
		grpRqstInitCommand.exec();
		bean = grpRqstInitCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/request/tmp", method = RequestMethod.POST)
	public String grpRqstTmp(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//セレクトボックスで選択したグループの情報を取得
		grpRqstTmpCommand.preProc(bean);
		grpRqstTmpCommand.exec();
		bean = grpRqstTmpCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/request/exec", method = RequestMethod.POST)
	public String grpRqstExec(@ModelAttribute("rootData") RootBean bean, Model model
			, Principal principal, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		//JoinRequestしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		//JoinRequestとrequest実施アカウントをDBにINSERT
		grpRqstExecCommand.preProc(bean);
		grpRqstExecCommand.exec(userName);
		bean = grpRqstExecCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		sessionStatus.setComplete();
		
		finalize.exec();
		
		return "groupRequestJoin";
	}

}
