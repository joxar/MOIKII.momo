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

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.ChangeUserRoleCommand;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.GetRoleCommand;
import com.devtwt.app.command.GroupNameAllGetCommand;
import com.devtwt.app.command.GroupShowInfoCommand;
import com.devtwt.app.command.GrpChngRoleExecCommandImpl;
import com.devtwt.app.command.GrpChngRoleInitCommandImpl;
import com.devtwt.app.command.GrpChngRoleTmpCommandImpl;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.MockCommandInterface;

@Controller
@SessionAttributes("rootData")
public class GroupChangeRoleController {
	
private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GroupNameAllGetCommand groupNameAllGetCommand;
	@Autowired
	GroupShowInfoCommand groupShowInfoCommand;
	@Autowired
	GetRoleCommand getRoleCommand;
	@Autowired
	ChangeUserRoleCommand changeUserRoleCommand;
	
	MockCommandInterface mc;
	
	/********************************/
	/***** [グループ]ロール変更画面 *****/
	/********************************/
	@RequestMapping(value = "/group/changeRole/init", method = RequestMethod.GET)
	public String groupChangeRoleInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		groupNameAllGetCommand.preProc(bean);
		groupNameAllGetCommand.exec();
		model.addAttribute("rootData", groupNameAllGetCommand.postProc());
		
		finalize.exec();
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/tmp", method = RequestMethod.POST)
	public String groupChangeRoleTmp(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//groupの所属メンバリスト,devCategoryを取得
		groupShowInfoCommand.preProc(bean);
		groupShowInfoCommand.exec();
		this.bean = groupShowInfoCommand.postProc();
		
		//グループの各メンバにRoleListをセットして取得
		getRoleCommand.preProc(bean);
		getRoleCommand.exec();
		this.bean = getRoleCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec();
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/exec", method = RequestMethod.POST)
	public String groupChangeRoleExec(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
	
		changeUserRoleCommand.preProc(bean);
		changeUserRoleCommand.exec();
	
		model.addAttribute("rootData", bean);
		finalize.exec();
		
		return "groupChangeRole";
	}

}
