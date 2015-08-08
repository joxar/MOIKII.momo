package com.devtwt.app.bean;

import java.io.Serializable;

public class JoinRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String requestId = "";
	private String status = "";
	private String communityId = "";
	private String memberId = "";
	private String createId = "";
	private String createDate = "";
	private String updateId = "";
	private String updateDate = "";
	private UserBean requester = new UserBean();
	private GroupBean requestGroup = new GroupBean();
	private Boolean checkRequest;
	
	public Boolean getCheckRequest() {
		return checkRequest;
	}
	public void setCheckRequest(Boolean checkRequest) {
		this.checkRequest = checkRequest;
	}
	public UserBean getRequester() {
		return requester;
	}
	public void setRequester(UserBean requester) {
		this.requester = requester;
	}
	public GroupBean getRequestGroup() {
		return requestGroup;
	}
	public void setRequestGroup(GroupBean requestGroup) {
		this.requestGroup = requestGroup;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommunityId() {
		return communityId;
	}
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
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
	
	@Override
	public String toString() {
		return "JoinRequestBean [requestId=" + requestId + ", status=" + status
				+ ", communityId=" + communityId + ", memberId=" + memberId
				+ ", createId=" + createId + ", createDate=" + createDate
				+ ", updateId=" + updateId + ", updateDate=" + updateDate
				+ ", requester=" + requester + ", requestGroup=" + requestGroup
				+ ", checkRequest=" + checkRequest + "]";
	}
	
	

}
