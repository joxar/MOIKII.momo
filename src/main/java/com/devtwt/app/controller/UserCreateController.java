package com.devtwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.GetRoleListCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.UserCreateCommand;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserCreateController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserCreateController.class);
	
	@Autowired
	InitializeCommand initilize;
	
	@Autowired
	RootBean bean;
	
	@Autowired
	public UserCreateCommand userCreateCommand;
	@Autowired
	public GetRoleListCommand getRoleListCommand;

	/********************************/
	/******** [アカウント]作成画面 ******/
	/********************************/	
	@RequestMapping(value = "/user/new")
	public String userNew(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		
		//全Roleのリストを取得
		getRoleListCommand.preProc(bean);
		getRoleListCommand.exec();
		model.addAttribute("rootData", getRoleListCommand.postProc());
		
		return "userNew";
	}
	
	@RequestMapping(value = "/user/new", params = "_event_proceed", method = POST)
	public String userCreated(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		
		userCreateCommand.preProc(bean);
		userCreateCommand.exec();
		
		return "userNew";
	}
}
