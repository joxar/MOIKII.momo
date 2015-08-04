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
import com.devtwt.app.bean.UserBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.InitializeCommand;
import com.devtwt.app.command.PrflUpldCommand;
import com.devtwt.app.dao.ProfileImageDao;
import com.devtwt.app.dao.UserMasterDao;

@RequestMapping("profile")
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
	ProfileImageDao profileImageDao;
	@Autowired
	UserMasterDao userDao;
	
	@ModelAttribute
    public ProfileImageBean setProfileImageBean() {
        return new ProfileImageBean();
    }

	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public String prfl(RootBean bean, Model model) {
		
		return "profile";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public String prflUpld(@RequestParam MultipartFile file, RootBean bean, Model model)throws IOException {
    	
    	//uploadしたファイルをbeanにセットする
    	bean.getProfileImage().setFile(file);
    	
    	prflUpldCommand.preProc(bean);
    	prflUpldCommand.exec();
    	prflUpldCommand.postProc();
    	
    	System.out.println("c:" + bean.getProfileImage());
        model.addAttribute("rootData", bean);
       
        return "uploadRecv";
        
    }
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
    public byte[] prflDwnld(RootBean bean, Model model)throws IOException {
    	
		bean.setProfileImage(profileImageDao.selectBinaryById("30"));
    
        model.addAttribute("rootData", bean);
       
        return bean.getProfileImage().getBinary();
        
    }
	
	@RequestMapping(value = "/download/{userName}", method = RequestMethod.GET)
	@ResponseBody
    public byte[] prflDwnldUsrNm(RootBean bean, Model model, @PathVariable("userName") String userName)throws IOException {
    	
		String userId = userDao.getUserId(userName);
		UserBean user = userDao.getMember(userId);
		
		String imgId = user.getProfileImageId();
		
		bean.setProfileImage(profileImageDao.selectBinaryById(imgId));
    
        model.addAttribute("rootData", bean);
       
        return bean.getProfileImage().getBinary();
        
    }

}
