package com.devtwt.app.controller;

import java.security.Principal;
import java.util.Locale;

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

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.*;
import com.devtwt.app.dao.SetupDaoInterface;
import com.devtwt.app.dao.TableSetupDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	
	MockCommandInterface mc;
	LoginCommandInterface lc;
	SetupDaoInterface sdi;
	
	@ModelAttribute("rootData")
	public RootBean setUpRootBean() {
		RootBean bean = new RootBean();
		return bean;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login/defaultError", method = RequestMethod.GET)
	public String home(RootBean bean, Model model, Principal principal) {
		
		
		return "defaultError";
	}
	
	@RequestMapping(value = "/login/badCredentials", method = RequestMethod.GET)
	public String login(RootBean bean, Model model, Principal principal) {

		return "badCredentials";
	}
	
	@RequestMapping(value = "/login/usernameNotFound", method = RequestMethod.GET)
	@ModelAttribute("test.itm1")
	public String test1(Locale locale, Model model) {
		
		return "usernameNotFound";
	}
	
	@RequestMapping(value = "/login/disabled", method = RequestMethod.GET)
	public String test1_1(Locale locale, Model model) {
		return "disabled";
	}
	@RequestMapping(value = "/login/providerNotFound", method = RequestMethod.GET)
	public String test1_2(Locale locale, Model model) {

		return "providerNotFound";
	}
	@RequestMapping(value = "/login/authenticationService", method = RequestMethod.GET)
	public String test1_2_1(Locale locale, Model model) {

		return "authenticationService";
	}
	
	
}
