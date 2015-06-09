package com.devtwt.app.controller;

import java.security.Principal;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
		
		//過去に投稿したtwtを取得
		allTwtGetCommand.preProc(bean);
		allTwtGetCommand.exec();
		bean = allTwtGetCommand.postProc();
		int size = bean.getMomoList().size();
		
		//過去に投稿したtwtをtwt画面にセット
		model.addAttribute("rootData", bean);
		model.addAttribute("start", 0);
		model.addAttribute("end", --size);
		
		return "twt";
	}
	
    /*setMomoは、ajaxから渡されたMomo_contentsをDBにInsertし、ajaxにJSONを返すメソッドです。*/
	@RequestMapping(value = "/twt/json", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String  setMomo(@RequestBody RootBean bean, Model model, Principal principal) throws Exception {
		
		initilize.exec();
		
		//twtしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		
		
		//twt投稿コマンドを実行
		twtPostCommand.preProc(bean);
		twtPostCommand.exec(userName);
		
		model.addAttribute("rootData", twtPostCommand.postProc());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		
		return json;
	}

}
