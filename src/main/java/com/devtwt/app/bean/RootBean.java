package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RootBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DbacMockBean dbacMock = new DbacMockBean();
	private String data1;
	
	public DbacMockBean getDbacMock() {
		return dbacMock;
	}
	public void setDbacMock(DbacMockBean dbacMock) {
		this.dbacMock = dbacMock;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
