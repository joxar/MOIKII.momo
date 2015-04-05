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
public class GroupBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String groupId = "";
	private String groupName = "";
	private String slctGroupId = "";
	private String slctDevCateId = "";
	private DevCategoryBean devCategory = new DevCategoryBean();
	private List<UserBean> memberList = new ArrayList<UserBean>();
	private List<UserBean> requesterList = new ArrayList<UserBean>();
	private List<DevCategoryBean> devCategoryList = new ArrayList<DevCategoryBean>();
	
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
	public String getSlctGroupId() {
		return slctGroupId;
	}
	public void setSlctGroupId(String slctGroupId) {
		this.slctGroupId = slctGroupId;
	}
	public String getSlctDevCateId() {
		return slctDevCateId;
	}
	public void setSlctDevCateId(String slctDevCateId) {
		this.slctDevCateId = slctDevCateId;
	}
	public DevCategoryBean getDevCategory() {
		return devCategory;
	}
	public void setDevCategory(DevCategoryBean devCategory) {
		this.devCategory = devCategory;
	}
	public List<UserBean> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<UserBean> memberList) {
		this.memberList = memberList;
	}
	public List<UserBean> getRequesterList() {
		return requesterList;
	}
	public void setRequesterList(List<UserBean> requesterList) {
		this.requesterList = requesterList;
	}
	public List<DevCategoryBean> getDevCategoryList() {
		return devCategoryList;
	}
	public void setDevCategoryList(List<DevCategoryBean> devCategoryList) {
		this.devCategoryList = devCategoryList;
	}
	
	@Override
	public String toString() {
		return "GroupBean [groupId=" + groupId + ", groupName=" + groupName
				+ ", slctGroupId=" + slctGroupId + ", slctDevCateId="
				+ slctDevCateId + ", devCategory=" + devCategory
				+ ", memberList=" + memberList + ", requesterList="
				+ requesterList + ", devCategoryList=" + devCategoryList + "]";
	}

}
