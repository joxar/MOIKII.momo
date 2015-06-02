package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DbacMockBean dbacMock = new DbacMockBean();
	@Autowired
	UserBean user = new UserBean();
	@Autowired
	GroupBean group = new GroupBean();
	@Autowired
	CommonInfoBean common = new CommonInfoBean();
	@Autowired
	List<GroupBean> groupList = new ArrayList<GroupBean>();
	ConstantsBean constants = new ConstantsBean();
	MomoBean momo = new MomoBean();
	List<MomoBean> momoList = new ArrayList<MomoBean>();
	List<String> selectUserId = new ArrayList<String>();

	public List<String> getSelectUserId() {
		return selectUserId;
	}
	public void setSelectUserId(List<String> selectUserId) {
		this.selectUserId = selectUserId;
	}
	public List<MomoBean> getMomoList() {
		return momoList;
	}
	public void setMomoList(List<MomoBean> momoList) {
		this.momoList = momoList;
	}
	public DbacMockBean getDbacMock() {
		return dbacMock;
	}
	public void setDbacMock(DbacMockBean dbacMock) {
		this.dbacMock = dbacMock;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public GroupBean getGroup() {
		return group;
	}
	public void setGroup(GroupBean group) {
		this.group = group;
	}
	public CommonInfoBean getCommon() {
		return common;
	}
	public void setCommon(CommonInfoBean common) {
		this.common = common;
	}
	public List<GroupBean> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<GroupBean> groupList) {
		this.groupList = groupList;
	}
	public ConstantsBean getConstants() {
		return constants;
	}
	public void setConstants(ConstantsBean constants) {
		this.constants = constants;
	}
	public MomoBean getMomo() {
		return momo;
	}
	public void setMomo(MomoBean momo) {
		this.momo = momo;
	}
	
	@Override
	public String toString() {
		return "RootBean [dbacMock=" + dbacMock + ", user=" + user + ", group="
				+ group + ", common=" + common + ", groupList=" + groupList
				+ ", constants=" + constants + ", momo=" + momo + ", momoList="
				+ momoList + ", selectUserId=" + selectUserId + "]";
	}
	
}
