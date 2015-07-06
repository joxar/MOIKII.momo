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
	private String phase = "";
	private String createId = "";
	private String createDate = "";
	private String updateId = "";
	private String updateDate = "";
	
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
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
				+ phNameList + ", phase=" + phase + ", createId=" + createId
				+ ", createDate=" + createDate + ", updateId=" + updateId
				+ ", updateDate=" + updateDate + "]";
	}
	
}
