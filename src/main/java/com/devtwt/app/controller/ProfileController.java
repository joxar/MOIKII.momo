package com.devtwt.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devtwt.app.bean.FileUploadForm;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.FinalizeCommand;
import com.devtwt.app.command.InitializeCommand;

@Controller
public class ProfileController {
	
	@Autowired
	InitializeCommand initilize;
	@Autowired
	FinalizeCommand finalize;
	@Autowired
	RootBean bean;
	
	  @ModelAttribute
	    public FileUploadForm setFileUploadForm() {
	        return new FileUploadForm();
	    }

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileInit(RootBean bean, Model model) {
		return "profile";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public String uploadComplate(@RequestParam MultipartFile file, Model model)throws IOException {
    	
    	Resource res = new ClassPathResource("profile.png");
    	File profile = res.getFile();
    	Path path = profile.toPath();

    	file.transferTo(profile);
 
        model.addAttribute("fileName", path);
       
        return "uploadRecv";
    }

}
