package com.devtwt.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devtwt.app.bean.FileUploadForm;

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ServletContext context;

    @ModelAttribute
    public FileUploadForm setFileUploadForm() {
        return new FileUploadForm();
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public String uploadComplate(@RequestParam MultipartFile file, Model model)throws IOException {
    	
    	//imagesディレクトリがなければ作成
    	File imageDir = new File(context.getRealPath("/") + "/images");
  
    	if (!imageDir.exists()) {
			imageDir.mkdir();
		}
    	
    	//コピー先のパスを取得
    	Path path = Paths.get(context.getRealPath("/") + "/images",
                file.getOriginalFilename());
    	
    	file.transferTo(path.toFile());
    	
        model.addAttribute("fileName", path);
    	
        return "uploadRecv";
    }
}
