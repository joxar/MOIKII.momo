package com.devtwt.app.bean;

import java.io.Serializable;

public class RoleBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String roleId = "";
	private String roleName = "";
	
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
		return "RoleBean [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
