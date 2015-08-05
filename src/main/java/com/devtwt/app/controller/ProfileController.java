package com.devtwt.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.devtwt.app.bean.ProfileImageBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.PrflDwnldCommand;
import com.devtwt.app.command.PrflUpldCommand;

@RequestMapping("profile/{userName}")
@Controller
public class ProfileController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	@Autowired
	PrflUpldCommand prflUpldCommand;
	@Autowired
	PrflDwnldCommand prflDwnldCommand;
	
	@ModelAttribute
    public ProfileImageBean setProfileImageBean() {
        return new ProfileImageBean();
    }

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String prfl(RootBean bean, Model model, @PathVariable("userName") String userName) {
		model.addAttribute("userName",userName);
		return "profile";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public String prflUpld(@RequestParam MultipartFile file, RootBean bean, Model model, @PathVariable("userName") String userName)throws IOException {
    	
    	//uploadしたファイルをbeanにセットする
    	bean.getProfileImage().setFile(file);
    	
    	prflUpldCommand.preProc(bean);
    	prflUpldCommand.exec(userName);
    	prflUpldCommand.postProc();
    	
        model.addAttribute("rootData", bean);
        model.addAttribute("userName",userName);
       
        return "profile";
        
    }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
    public byte[] prflDwnld(RootBean bean, Model model, @PathVariable("userName") String userName)throws IOException {
    	
		prflDwnldCommand.preProc(bean);
		prflDwnldCommand.exec(userName);
		prflDwnldCommand.postProc();
    
        model.addAttribute("rootData", bean);
        model.addAttribute("userName",userName);
       
        return bean.getProfileImage().getBinary();
        
    }

}
