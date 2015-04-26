package com.devtwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.InitializeCommand;

@Controller
public class TwtController {
	
	private static final Logger logger = LoggerFactory.getLogger(TwtController.class);
	
	@Autowired
	InitializeCommand initilize;
	
	@Autowired
	RootBean bean;
	
	@RequestMapping(value = "/twt")
	public String userNew(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		
		return "twt";
	}

}
