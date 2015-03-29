package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DbacMockBean dbacMock;
	@Autowired
	UserBean user;
	@Autowired
	GroupBean group;
	@Override
	public String toString() {
		return "RootBean [dbacMock=" + dbacMock + ", user=" + user + ", group="
				+ group + ", common=" + common + ", getCommon()=" + getCommon()
				+ ", getGroup()=" + getGroup() + ", getUser()=" + getUser()
				+ ", getDbacMock()=" + getDbacMock() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Autowired
	CommonInfoBean common;
	
	public CommonInfoBean getCommon() {
		return common;
	}
	public void setCommon(CommonInfoBean common) {
		this.common = common;
	}
	public GroupBean getGroup() {
		return group;
	}
	public void setGroup(GroupBean group) {
		this.group = group;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public DbacMockBean getDbacMock() {
		return dbacMock;
	}
	public void setDbacMock(DbacMockBean dbacMock) {
		this.dbacMock = dbacMock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
