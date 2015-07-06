package com.devtwt.app.controller;

import java.security.Principal;

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

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.AllReplyGetCommand;
import com.devtwt.app.command.AllTwtGetCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.PostReturnCommentCommand;
import com.devtwt.app.command.TwtPostCommand;

@Controller
public class TwtController {
	
	private static final Logger logger = LoggerFactory.getLogger(TwtController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	RootBean bean;
	@Autowired
	TwtPostCommand twtPostCommand;
	@Autowired
	AllTwtGetCommand allTwtGetCommand;
	@Autowired
	PostReturnCommentCommand returnCommentCommand;
	@Autowired
	AllReplyGetCommand allReplyGetCommand;
	
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
		
		allReplyGetCommand.preProc(bean);
		allReplyGetCommand.exec();
		bean = allReplyGetCommand.postProc();
		
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
		bean = twtPostCommand.postProc();

		model.addAttribute("rootData", bean);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//DBから取得した情報(時間、投稿者名など)をajaxに変換
		String json = mapper.writeValueAsString(bean);
		
		return json;
	}
	
	/**/
	@RequestMapping(value = "/twt/reply", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String  replyMomo(@RequestBody RootBean bean, Model model, Principal principal) throws Exception {
		
		initilize.exec();
		
		//twtしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		returnCommentCommand.preProc(bean);
		returnCommentCommand.exec(userName);
		bean = returnCommentCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//DBから取得した情報(時間、投稿者名など)をjsonの文字列に変換
		String json = mapper.writeValueAsString(bean);
		
		return json;
	}

}
