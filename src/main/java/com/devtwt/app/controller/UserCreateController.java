package com.devtwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.UserCreateCommand;
import com.devtwt.app.dao.UserMasterDaoImpl;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@SessionAttributes("createUser")
public class UserCreateController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserCreateController.class);
	
	@Autowired
	InitializeCommand initilize;
	
	@Autowired
	RootBean bean;
	
	@Autowired
	public UserCreateCommand userCreateCommand;

		
	@RequestMapping(value = "/user/new")
	public String userNew(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		model.addAttribute("createUser", bean);
		
		return "userNew";
	}
	
	@RequestMapping(value = "/user/new", params = "_event_proceed", method = POST)
	public String userNewRedirect(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		model.addAttribute("createUser", bean);
		
		return "redirect:confirm";
	}
	
	@RequestMapping(value = "/user/confirm", method = GET)
	public String userNewConfirm(@ModelAttribute("createUser") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		return "userConfirm";
	}
	
	@RequestMapping(value = "/user/confirm", params = "_event_revise")
	public String userNewConfirmRedirect(SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		sessionStatus.setComplete();
		
		return "redirect:new";
	}
	
	@RequestMapping(value = "/user/confirm", params = "_event_confirmed", method = POST)
	public String userNewReviese(@ModelAttribute("createUser") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//ユーザを新規作成
		userCreateCommand.preProc(bean);
		userCreateCommand.exec();

		return "redirect:created";
	}
	
	@RequestMapping(value = "/user/created", method = GET)
	public String userNewCreated(SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		sessionStatus.setComplete();
		
		return "userCreated";
	}

}
