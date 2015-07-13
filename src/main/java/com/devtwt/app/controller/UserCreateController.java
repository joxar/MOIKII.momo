package com.devtwt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.UserNewCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.UserCreateCommand;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class UserCreateController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	RootBean bean;
	@Autowired
	public UserCreateCommand userCreateCommand;
	@Autowired
	public UserNewCommand userNewCommand;

	/********************************/
	/******** [アカウント]作成画面 ******/
	/********************************/	
	@RequestMapping(value = "/user/new")
	public String userNew(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		
		//全Roleのリストを取得
		userNewCommand.preProc(bean);
		userNewCommand.exec();
		bean = userNewCommand.postProc();
		model.addAttribute("rootData", bean);
		
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
