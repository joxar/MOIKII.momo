package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId = "";
	private String userName = "";
	private String userPassword = "";
	private String roleId = "";
	private String roleName = "";
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", roleId=" + roleId
				+ ", roleName=" + roleName + "]";
	}

}
