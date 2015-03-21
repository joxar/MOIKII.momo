package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DbacMockBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String selectedTBL;
	private List<SubDbacMockBean> testDataList = new ArrayList<SubDbacMockBean>();
	
	public String getSelectedTBL() {
		return selectedTBL;
	}
	public void setSelectedTBL(String selectedTBL) {
		this.selectedTBL = selectedTBL;
	}
	public List<SubDbacMockBean> getTestDataList() {
		return testDataList;
	}
	public void setTestDataList(List<SubDbacMockBean> testDataList) {
		this.testDataList = testDataList;
	}
		


}
