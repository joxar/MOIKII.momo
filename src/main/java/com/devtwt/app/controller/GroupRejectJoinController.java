package com.devtwt.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.devtwt.app.command.GroupRejectJoinInitCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.RejectJoinApproveCommand;
import com.devtwt.app.command.RejectJoinRefuseCommand;

@Controller
@SessionAttributes("rootData")
public class GroupRejectJoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(GroupRejectJoinController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GroupRejectJoinInitCommand groupRejectCommand;
	@Autowired
	RejectJoinRefuseCommand refuseCommand;
	@Autowired
	RejectJoinApproveCommand approveCommand;

	/********************************/
	/**** [グループ]参加申請拒否画面 *****/
	/********************************/
	@RequestMapping(value = "/group/rejectJoin/init", method = RequestMethod.GET)
	public String rejectJoinInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//status=REQUESTのJoinRequestを全て取得し、画面に表示
		groupRejectCommand.preProc(bean);
		groupRejectCommand.exec();
		bean = groupRejectCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	//Approveボタン押下時に呼び出し
	@RequestMapping(value = "/group/rejectJoin/exec", params = "_approve", method = RequestMethod.POST)
	public String rejectJoinApprove(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		//選択したJoinRequestのstatusに'APPROVE'をセット、Groupにリクエストメンバを追加
		approveCommand.preProc(bean);
		approveCommand.exec();
		
		//status=REQUESTのJoinRequestを全て取得し、画面に表示
		groupRejectCommand.preProc(bean);
		groupRejectCommand.exec();
		bean = groupRejectCommand.postProc();
		
		model.addAttribute("rootData", bean);

		sessionStatus.setComplete();
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	//Refuseボタン押下時に呼び出し
	@RequestMapping(value = "/group/rejectJoin/exec", params = "_refuse", method = RequestMethod.POST)
	public String rejectJoinRefuse(@ModelAttribute("rootData") RootBean bean, Model model
			, SessionStatus sessionStatus) throws Exception {

		initilize.exec();
		
		//選択したJoinRequestのstatusに'REFUSE'をセット
		refuseCommand.preProc(bean);
		refuseCommand.exec();
		
		//status=REQUESTのJoinRequestを全て取得し、画面に表示
		groupRejectCommand.preProc(bean);
		groupRejectCommand.exec();
		bean = groupRejectCommand.postProc();
		
		model.addAttribute("rootData", bean);
		sessionStatus.setComplete();
		
		finalize.exec();
		
		return "groupRejectJoin";
	}

}
