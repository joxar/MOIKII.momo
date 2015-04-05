package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author snufkin
 *
 */
@Component
public class DevCategoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String devCategoryId = "";
	private String devCategoryName = "";
	private List<String> phNameList = new ArrayList<String>();
	
	public String getDevCategoryId() {
		return devCategoryId;
	}
	public void setDevCategoryId(String devCategoryId) {
		this.devCategoryId = devCategoryId;
	}
	public String getDevCategoryName() {
		return devCategoryName;
	}
	public void setDevCategoryName(String devCategoryName) {
		this.devCategoryName = devCategoryName;
	}
	public List<String> getPhNameList() {
		return phNameList;
	}
	public void setPhNameList(List<String> phNameList) {
		this.phNameList = phNameList;
	}
	
	@Override
	public String toString() {
		return "DevCategoryBean [devCategoryId=" + devCategoryId
				+ ", devCategoryName=" + devCategoryName + ", phNameList="
				+ phNameList + "]";
	}
	
}
