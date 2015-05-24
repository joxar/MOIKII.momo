package com.devtwt.app.controller;

import java.security.Principal;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.*;
import com.devtwt.app.dao.SetupDaoInterface;
import com.devtwt.app.dao.TableSetupDaoImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	
	MockCommandInterface mc;
	LoginCommandInterface lc;
	SetupDaoInterface sdi;
	
	@ModelAttribute("rootData")
	public RootBean setUpRootBean() {
		RootBean bean = new RootBean();
		return bean;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(RootBean bean, Model model, Principal principal) {
		
		initilize.exec();
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(RootBean bean, Model model, Principal principal) {
		
		initilize.exec();
		this.bean = bean;
		lc = new LoginCommandImpl();
		lc.loginProc(this.bean);
		
		model.addAttribute("rootData", lc.loginProc(this.bean));
	
		return "login";
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
	
	@RequestMapping(value = "/dbAccessMock/init", method = RequestMethod.GET)
	public String dbAccessMockInit(RootBean bean, Model model) throws Exception {
		return "dbAccessMock";
	}
	
	@RequestMapping(value = "/dbAccessMock/setup", method = RequestMethod.POST)
	public String setupTable(RootBean bean, Model model) throws Exception {

		//initilize.exec();
		sdi = new TableSetupDaoImpl();

		sdi.setupTable();
//		model.addAttribute("rootData", dm.postProc());
		
		return "dbAccessMock";
	}
	
	@RequestMapping(value = "/dbAccessMock/show", method = RequestMethod.POST)
	public String dbAccessMockShow(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new DbacMockCommandImpl();
		
		mc.preProc(bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		
		return "dbAccessMock";
	}
	
	/********************************/
	/******** [グループ]作成画面 *******/
	/********************************/
	@RequestMapping(value = "/group/create/init", method = RequestMethod.GET)
	public String groupCreateInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpCrtInitCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupCreate";
	}
	
	@RequestMapping(value = "/group/create/tmp", method = RequestMethod.POST)
	public String groupCreateTmp(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpCrtTmpCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupCreate";
	}
	
	@RequestMapping(value = "/group/create/exec", method = RequestMethod.POST)
	public String groupCreateExec(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpCrtExecCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupCreate";
	}
	
	/********************************/
	/****** [グループ]情報参照画面 ******/
	/********************************/
	@RequestMapping(value = "/group/showInfo/init", method = RequestMethod.GET)
	public String groupShowInfoInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpShwInfInitCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupShowInfo";
	}
	
	@RequestMapping(value = "/group/showInfo/tmp", method = RequestMethod.POST)
	public String groupShowInfoTmp(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpShwInfTmpCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupShowInfo";
	}
	
	/********************************/
	/****** [グループ]参加申請画面 ******/
	/********************************/
	@RequestMapping(value = "/group/reqJoin/init", method = RequestMethod.GET)
	public String groupRequestJoinInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpRqstJoinInitCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/reqJoin/tmp", method = RequestMethod.POST)
	public String groupRequestJoinTmp(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpRqstJoinTmpCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	@RequestMapping(value = "/group/reqJoin/exec", method = RequestMethod.POST)
	public String groupRequestJoinExec(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpRqstJoinExecCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupRequestJoin";
	}
	
	/********************************/
	/**** [グループ]参加申請拒否画面 *****/
	/********************************/
	@RequestMapping(value = "/group/rejectJoin/init", method = RequestMethod.GET)
	public String rejectJoinInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpRjctJoinInitCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	@RequestMapping(value = "/group/rejectJoin/exec", method = RequestMethod.POST)
	public String rejectJoinExec(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpRjctJoinExecCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupRejectJoin";
	}
	
	/********************************/
	/***** [グループ]ロール変更画面 *****/
	/********************************/
	@RequestMapping(value = "/group/changeRole/init", method = RequestMethod.GET)
	public String groupChangeRoleInit(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpChngRoleInitCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/tmp", method = RequestMethod.POST)
	public String groupChangeRoleTmp(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpChngRoleTmpCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupChangeRole";
	}
	
	@RequestMapping(value = "/group/changeRole/exec", method = RequestMethod.POST)
	public String groupChangeRoleExec(RootBean bean, Model model) throws Exception {

		initilize.exec();
		this.bean = bean;
		mc = new GrpChngRoleExecCommandImpl();
		mc.preProc(this.bean);
		mc.exec();
		model.addAttribute("rootData", mc.postProc());
		finalize.exec();
		
		return "groupChangeRole";
	}
	
}
