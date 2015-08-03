package com.devtwt.app.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

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

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ServletContext context;

   /* @ModelAttribute
    public FileUploadForm setFileUploadForm() {
        return new FileUploadForm();
    }

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }
*/
   /* @RequestMapping(value = "upload", method = RequestMethod.POST,headers=("content-type=multipart/*"))
    public String uploadComplate(@RequestParam MultipartFile file, Model model)throws IOException {
    	
    	//imagesディレクトリがなければ作成
    	File imageDir = new File(context.getRealPath("/") + "/images");
  
    	if (!imageDir.exists()) {
			imageDir.mkdir();
		}
    	
    	 String fooPath = ArticleController.class.getResource( "ArticleController.class" ).toString();
         System.out.println("a:" + fooPath);
         
    	//コピー先のパスを取得
    	//File profile = new File("classpath:../webapp/resources/bootstrap-3.3.2-dist/profile.png");
    	//File profile = new File("src/main/resources/profile.png");
    	Path path = Paths.get("classpath:profile.png");
    	File profile = path.toFile();
    	System.out.println("profile:" + profile.toPath());
    	if (profile.exists()) {
    		profile.delete();
    		System.out.println("delete!!!");
		}
    	
    	//Path path = Paths.get("src/main/resources/profile.png");
    	URL url = this.getClass().getClassLoader().getResource("classpath:log4j.xml");
    	System.out.println("url;" + url);
    	Resource res = new ClassPathResource("profile.png");
    	File profile = res.getFile();
    	Path path = profile.toPath();
    	//file.transferTo(path.toFile());
    	file.transferTo(profile);
 
        model.addAttribute("fileName", path);
       
        return "uploadRecv";
    }*/
}
