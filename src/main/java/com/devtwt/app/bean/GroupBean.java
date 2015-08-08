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
	private String devCategoryId = "";
	private String memberId = "";
	private String createId = "";
	private String createDate = "";
	private String updateId = "";
	private String updateDate = "";
	private DevCategoryBean devCategory = new DevCategoryBean();
	private List<UserBean> memberList = new ArrayList<UserBean>();
	private List<UserBean> requesterList = new ArrayList<UserBean>();
	private List<DevCategoryBean> devCategoryList = new ArrayList<DevCategoryBean>();
	private String slctGroupName = "";
	
	public String getDevCategoryId() {
		return devCategoryId;
	}
	public void setDevCategoryId(String devCategoryId) {
		this.devCategoryId = devCategoryId;
	}
	public String getSlctGroupName() {
		return slctGroupName;
	}
	public void setSlctGroupName(String slctGroupName) {
		this.slctGroupName = slctGroupName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
				+ slctDevCateId + ", devCategoryId=" + devCategoryId
				+ ", memberId=" + memberId + ", createId=" + createId
				+ ", createDate=" + createDate + ", updateId=" + updateId
				+ ", updateDate=" + updateDate + ", devCategory=" + devCategory
				+ ", memberList=" + memberList + ", requesterList="
				+ requesterList + ", devCategoryList=" + devCategoryList
				+ ", slctGroupName=" + slctGroupName + "]";
	}

}
