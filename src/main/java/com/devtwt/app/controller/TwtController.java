package com.devtwt.app.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.AllTwtGetCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.TwtPostCommand;

@Controller
public class TwtController {
	
	private static final Logger logger = LoggerFactory.getLogger(TwtController.class);
	
	@Autowired
	InitializeCommand initilize;
	
	@Autowired
	RootBean bean;
	
	@Autowired
	public TwtPostCommand twtPostCommand;
	
	@Autowired
	public AllTwtGetCommand allTwtGetCommand;
	
	/********************************/
	/******** コメント投稿画面 *********/
	/********************************/
	@RequestMapping(value = "/twt")
	public String twtHome(RootBean bean, Model model) throws Exception {
		
		initilize.exec();
		
		List<MomoBean> momoList = allTwtGetCommand.exec();
		bean.setMomoList(momoList);
		
		int size = momoList.size();
		
		model.addAttribute("rootData", bean);
		model.addAttribute("start", 0);
		model.addAttribute("end", --size);
		
		return "twt";
	}
	
    /*setMomoは、ajaxから渡されたMomo_contentsをDBにInsertし、ajaxにJSONを返すメソッドです。*/
	@RequestMapping(value = "/twt/json", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String  setMomo(@RequestBody RootBean bean, Model model) throws Exception {
		
		initilize.exec();

		model.addAttribute("rootData", bean);
		
		twtPostCommand.preProc(bean);
		twtPostCommand.exec();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		
		return json;
	}

}
