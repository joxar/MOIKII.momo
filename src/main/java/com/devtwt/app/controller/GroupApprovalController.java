package com.devtwt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.GrpApprvlApprvCommand;
import com.devtwt.app.command.GrpApprvlInitCommand;
import com.devtwt.app.command.GrpApprvlRfsCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
@SessionAttributes("rootData")
public class GroupApprovalController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GrpApprvlInitCommand grpApprvlInitCommand;
	@Autowired
	GrpApprvlApprvCommand grpApprvlApprvCommand;
	@Autowired
	GrpApprvlRfsCommand grpApprvlRfsCommand;

	/********************************/
	/**** [グループ]参加申請拒否画面 *****/
	/********************************/
	@RequestMapping(value = "/group/approval/init", method = RequestMethod.GET)
	public String grpApprvlInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//status=REQUESTのJoinRequestを全て取得し、画面に表示
		grpApprvlInitCommand.preProc(bean);
		grpApprvlInitCommand.exec();
		bean = grpApprvlInitCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	//Approveボタン押下時に呼び出し
	@RequestMapping(value = "/group/approval/exec", params = "_approve", method = RequestMethod.POST)
	public String grpApprvlApprv(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		/*選択したJoinRequestのstatusに'APPROVE'をセット、Groupにリクエストメンバを追加
		  その後再び、status=REQUESTのJoinRequestを全て取得し、画面に表示*/
		grpApprvlApprvCommand.preProc(bean);
		grpApprvlApprvCommand.exec();
		bean = grpApprvlApprvCommand.postProc();
		
		model.addAttribute("rootData", bean);

		sessionStatus.setComplete();
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	//Refuseボタン押下時に呼び出し
	@RequestMapping(value = "/group/approval/exec", params = "_refuse", method = RequestMethod.POST)
	public String grpApprvlRfs(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		/*選択したJoinRequestのstatusに'REFUSE'をセット、Groupにリクエストメンバを追加
		  その後再び、status=REQUESTのJoinRequestを全て取得し、画面に表示*/
		grpApprvlRfsCommand.preProc(bean);
		grpApprvlRfsCommand.exec();
		bean = grpApprvlRfsCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		sessionStatus.setComplete();
		
		finalize.exec();
		
		return "groupRejectJoin";
	}

}
