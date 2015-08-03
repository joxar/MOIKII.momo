package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class ProfileImageBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private byte[] binary;
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public byte[] getBinary() {
		return binary;
	}

	public void setBinary(byte[] binary) {
		this.binary = binary;
	}

	@Override
	public String toString() {
		return "ProfileImageBean [id=" + id + ", binary="
				+ Arrays.toString(binary) + ", file=" + file + "]";
	}
}
