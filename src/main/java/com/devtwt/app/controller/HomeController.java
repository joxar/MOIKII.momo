package com.devtwt.app.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	MockCommandInterface dm;
	
	RootBean bean;
	
	@ModelAttribute("rootData")
	public RootBean setUpRootBean() {
		RootBean bean = new RootBean();
		return bean;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home";
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	@ModelAttribute("test.itm1")
	public String test1(Locale locale, Model model) {
		logger.info("Move to test1! The client locale is {}.", locale);
		
		System.out.println(model.getClass());
		model.addAttribute("receivedData", "test.itm1");
		return "test1";
	}
	
	@RequestMapping(value = "/test1_1", method = RequestMethod.POST)
	public String test1_1(Locale locale, Model model) {
		logger.info("test1_1 has been called");
		return "test1_1";
	}
	@RequestMapping(value = "/test1_2", method = RequestMethod.POST)
	public String test1_2(Locale locale, Model model) {
		logger.info("test1_2 has been called");
		return "test1_2";
	}
	@RequestMapping(value = "/test1_2_1", method = RequestMethod.POST)
	public String test1_2_1(Locale locale, Model model) {
		logger.info("1-2-1 has been called");
		return "test1_2_1";
	}
	@RequestMapping(value = "/tk_sandbox", method = RequestMethod.POST)
	public String kt_sandbox(Locale locale, Model model) {
		logger.info("tk_sandbox has been called");
		return "tk_sandbox";
	}
	@RequestMapping(value = "/aaa", method = RequestMethod.GET)
	public String aaa(Locale locale, Model model) {
		logger.info("test1_1 has been called");
		return "test1_1";
	}
	
	@RequestMapping(value = "/dbAccessMock/init", method = RequestMethod.POST)
	public String dbAccessMockInit(RootBean bean, Model model) throws Exception {
		return "dbAccessMock";
	}
	
	@RequestMapping(value = "/dbAccessMock/show", method = RequestMethod.POST)
	public String dbAccessMockShow(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		
		dm.preProc(bean);
		dm.exec();
		model.addAttribute("rootData", dm.postProc());
		
		return "dbAccessMock";
	}
	
}
