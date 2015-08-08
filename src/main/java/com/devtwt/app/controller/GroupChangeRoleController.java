package com.devtwt.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.GrpChngRoleExecCommand;
import com.devtwt.app.command.GrpChngRoleInitCommand;
import com.devtwt.app.command.GrpChngRoleTmpCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.constants.CommonConstants;

@Controller
@SessionAttributes("rootData")
public class GroupChangeRoleController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	GrpChngRoleInitCommand grpChngRoleInitCommand;
	@Autowired
	GrpChngRoleTmpCommand grpChngRoleTmpCommand;
	@Autowired
	GrpChngRoleExecCommand grpChngRoleExecCommand;
	
	/********************************/
	/***** [グループ]ロール変更画面 *****/
	/********************************/
	@RequestMapping(value = "/group/changeRole/init", method = RequestMethod.GET)
	public String grpChngRoleInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//全グループ名を含むセレクトリストを表示するための処理
		grpChngRoleInitCommand.preProc(bean);
		grpChngRoleInitCommand.exec();
		this.bean = grpChngRoleInitCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec(bean, CommonConstants.VIEW_GROUP_CHANGE_ROLE);
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/tmp", method = RequestMethod.POST)
	public String grpChngRoleTmp(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
		
		//セレクトリストで選択したグループのメンバとロールを表示するための処理
		grpChngRoleTmpCommand.preProc(bean);
		grpChngRoleTmpCommand.exec();
		this.bean = grpChngRoleTmpCommand.postProc();
		
		model.addAttribute("rootData", bean);
		
		finalize.exec(bean, CommonConstants.VIEW_GROUP_CHANGE_ROLE);
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/exec", method = RequestMethod.POST)
	public String grpChngRoleExec(@ModelAttribute("rootData") RootBean bean, Model model) throws Exception {

		initilize.exec();
	    
		//変更したロールをDBに反映する処理を実施
		grpChngRoleExecCommand.preProc(bean);
		grpChngRoleExecCommand.exec();
		this.bean = grpChngRoleExecCommand.postProc();
	
		model.addAttribute("rootData", bean);
		finalize.exec(bean, CommonConstants.VIEW_GROUP_CHANGE_ROLE);
		
		return "groupChangeRole";
	}

}
