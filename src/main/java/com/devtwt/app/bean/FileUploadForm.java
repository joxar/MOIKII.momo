package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private MultipartFile file; // (1)

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
