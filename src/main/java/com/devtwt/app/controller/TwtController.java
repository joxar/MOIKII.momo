package com.devtwt.app.controller;

import java.security.Principal;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.TwtReplyCommand;
import com.devtwt.app.command.TwtCommand;
import com.devtwt.app.command.TwtPostCommand;

@Controller
@RequestMapping(value = "/twt/group/{groupId}")
public class TwtController {
	
	@Autowired
	InitializeCommand initilize;	
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	TwtCommand twtCommand;
	@Autowired
	TwtPostCommand twtPostCommand;
	@Autowired
	TwtReplyCommand twtReplyCommand;
	
	/********************************/
	/******** コメント投稿画面 *********/
	/********************************/
	@RequestMapping(value = "")
	public String twt(RootBean bean, Model model, Principal principal, @PathVariable("groupId") String groupId) throws Exception {
		
		initilize.exec();
		
		//ログインアカウント名を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		/*過去に投稿したtwtを取得
		  過去に投稿した返信を取得
		  ログインアカウント名をキーに所属しているグループのリストを取得*/
		twtCommand.preProc(bean);
		twtCommand.exec(userName, groupId);
		bean = twtCommand.postProc();
		
		finalize.exec(bean, "V001");
		
		//過去に投稿したmomoコメントの数を取得
		int size = bean.getMomoList().size();
		
		model.addAttribute("rootData", bean);
		model.addAttribute("start", 0);
		model.addAttribute("end", --size);
		
		return "twt";
	}
	
    /*setMomoは、ajaxから渡されたMomo_contentsをDBにInsertし、ajaxにJSONを返すメソッド*/
	@RequestMapping(value = "/post", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String  twtPost(@RequestBody RootBean bean, Model model, Principal principal, @PathVariable("groupId") String groupId) throws Exception {
		
		initilize.exec();
		
		//twtしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		//twt投稿コマンドを実行
		twtPostCommand.preProc(bean);
		twtPostCommand.exec(userName, groupId);
		bean = twtPostCommand.postProc();

		model.addAttribute("rootData", bean);
		
		//DBから取得した情報(時間、投稿者名など)をjson形式に変換
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		
		//DBから取得したデータをjsonに変換して、返す
		return json;
	}
	
	/*返信ボタンを押下すると呼び出し*/
	@RequestMapping(value = "/reply", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String  twtReply(@RequestBody RootBean bean, Model model, Principal principal, @PathVariable("groupId") String groupId) throws Exception {
		
		initilize.exec();
		
		//twtしたアカウントの情報を取得
		Authentication authentication = (Authentication) principal;
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String userName = userDetails.getUsername();
		
		twtReplyCommand.preProc(bean);
		twtReplyCommand.exec(userName, groupId);
		bean = twtReplyCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		//DBから取得した情報(時間、投稿者名など)をjson形式に変換
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(bean);
		
		//DBから取得したデータをjsonに変換して、返す
		return json;
	}
}
