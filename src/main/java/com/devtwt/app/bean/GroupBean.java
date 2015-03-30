package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author snufkin
 *
 */
@Component
public class GroupBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String groupId = "";
	private String groupName = "";
	private List<String> memberNameList = new ArrayList<String>();;
	private List<DevCategoryBean> devCategoryList = new ArrayList<DevCategoryBean>();;
	
	@Autowired
	private DevCategoryBean devCategory;
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<String> getMemberNameList() {
		return memberNameList;
	}

	public void setMemberNameList(List<String> memberNameList) {
		this.memberNameList = memberNameList;
	}

	public DevCategoryBean getDevCategory() {
		return devCategory;
	}

	public void setDevCategory(DevCategoryBean devCategory) {
		this.devCategory = devCategory;
	}

	public List<DevCategoryBean> getDevCategoryList() {
		return devCategoryList;
	}

	public void setDevCategoryList(List<DevCategoryBean> devCategoryList) {
		this.devCategoryList = devCategoryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GroupBean [groupId=" + groupId + ", groupName=" + groupName
				+ ", memberNameList=" + memberNameList + ", devCategoryList="
				+ devCategoryList + ", devCategory=" + devCategory
				+ ", getGroupId()=" + getGroupId() + ", getGroupName()="
				+ getGroupName() + ", getMemberNameList()="
				+ getMemberNameList() + ", getDevCategory()="
				+ getDevCategory() + ", getDevCategoryList()="
				+ getDevCategoryList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

	
}
