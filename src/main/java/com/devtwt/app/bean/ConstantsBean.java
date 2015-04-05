package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.Arrays;

public class ConstantsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public final String[] roleIdList = {"1", "2"};
	public final String[] roleNameList = {"develper", "manager"};
	
	public String[] getRoleIdList() {
		return roleIdList;
	}
	public String[] getRoleNameList() {
		return roleNameList;
	}
	
	@Override
	public String toString() {
		return "ConstantsBean [roleIdList=" + Arrays.toString(roleIdList)
				+ ", roleNameList=" + Arrays.toString(roleNameList) + "]";
	}
	
}
