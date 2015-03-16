package com.devtwt.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropLoader {
	
	private Properties prop = null;
	private InputStream is = null;
	private File inFile = null;
	
	public PropLoader(String inFileName) {
		
		System.out.println(inFileName);
		this.inFile = new File(inFileName);
	}
	
	public Properties fileLoader() throws Exception {
		try {
			is = new FileInputStream(this.inFile);
			System.out.println(is);
			prop.load(is);
			is.close();
		} catch (Exception e) {
		}
		
		return prop;
	}
	
}
