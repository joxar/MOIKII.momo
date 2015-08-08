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
	UserBean user = new UserBean();
	@Autowired
	ViewBean view = new ViewBean();
	@Autowired
	GroupBean group = new GroupBean();
	@Autowired
	CommonInfoBean common = new CommonInfoBean();
	@Autowired
	List<GroupBean> groupList = new ArrayList<GroupBean>();
	ConstantsBean constants = new ConstantsBean();
	List<RoleBean> roleList = new ArrayList<RoleBean>();
	MomoBean momo = new MomoBean();
	List<MomoBean> momoList = new ArrayList<MomoBean>();
	//Invite Member画面で選択したUserの名称がセットされる
	List<String> selectUserName = new ArrayList<String>();
	List<String> groupNameList = new ArrayList<String>();
	DevCategoryBean devCategory = new DevCategoryBean();
	JoinRequestBean joinRequest = new JoinRequestBean();
	List<JoinRequestBean> joinRequestList = new ArrayList<JoinRequestBean>();
    ReturnCommentBean returnComment = new ReturnCommentBean();
    ProfileImageBean profileImage = new ProfileImageBean();
	
	public ViewBean getView() {
		return view;
	}
	public void setView(ViewBean view) {
		this.view = view;
	}
	public ReturnCommentBean getReturnComment() {
		return returnComment;
	}
	public void setReturnComment(ReturnCommentBean returnComment) {
		this.returnComment = returnComment;
	}
	public List<JoinRequestBean> getJoinRequestList() {
		return joinRequestList;
	}
	public void setJoinRequestList(List<JoinRequestBean> joinRequestList) {
		this.joinRequestList = joinRequestList;
	}
	public JoinRequestBean getJoinRequest() {
		return joinRequest;
	}
	public void setJoinRequest(JoinRequestBean joinRequest) {
		this.joinRequest = joinRequest;
	}
	public DevCategoryBean getDevCategory() {
		return devCategory;
	}
	public void setDevCategory(DevCategoryBean devCategory) {
		this.devCategory = devCategory;
	}
	public List<String> getGroupNameList() {
		return groupNameList;
	}
	public void setGroupNameList(List<String> groupNameList) {
		this.groupNameList = groupNameList;
	}
	public List<String> getSelectUserName() {
		return selectUserName;
	}
	public void setSelectUserName(List<String> selectUserName) {
		this.selectUserName = selectUserName;
	}
	public List<MomoBean> getMomoList() {
		return momoList;
	}
	public void setMomoList(List<MomoBean> momoList) {
		this.momoList = momoList;
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
	public List<RoleBean> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleBean> roleList) {
		this.roleList = roleList;
	}
	public ProfileImageBean getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(ProfileImageBean profileImage) {
		this.profileImage = profileImage;
	}
	
	@Override
	public String toString() {
		return "RootBean [user=" + user + ", view=" + view + ", group=" + group
				+ ", common=" + common + ", groupList=" + groupList
				+ ", constants=" + constants + ", roleList=" + roleList
				+ ", momo=" + momo + ", momoList=" + momoList
				+ ", selectUserName=" + selectUserName + ", groupNameList="
				+ groupNameList + ", devCategory=" + devCategory
				+ ", joinRequest=" + joinRequest + ", joinRequestList="
				+ joinRequestList + ", returnComment=" + returnComment
				+ ", profileImage=" + profileImage + "]";
	}
	
}
