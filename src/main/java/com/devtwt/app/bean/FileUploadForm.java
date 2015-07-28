package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm implements Serializable {
	
	 private MultipartFile file; // (1)


		/*	    @NotNull
	    @Size(min = 0, max = 100)*/
	    private String description;
	    
	    public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}


}
