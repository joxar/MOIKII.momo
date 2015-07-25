package com.devtwt.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.*;
import com.devtwt.app.constants.CommonConstants;
import com.devtwt.app.dao.SetupDaoInterface;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	
	SetupDaoInterface sdi;
	
	@ModelAttribute("rootData")
	public RootBean setUpRootBean() {
		RootBean bean = new RootBean();
		return bean;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(@ModelAttribute RootBean bean, Model model, Principal principal) {
		
		initilize.exec();
		finalize.exec(bean, CommonConstants.VIEW_HOME);
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(RootBean bean, Model model, Principal principal) {
		
		initilize.exec();
	
		return "login";
	}
	
	@RequestMapping(value = "/portal", method = RequestMethod.GET)
	public String portal(RootBean bean, Model model, Principal principal) {
		
		return "easterEgg_login";
	}
	
}
