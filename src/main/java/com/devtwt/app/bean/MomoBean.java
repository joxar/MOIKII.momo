package com.devtwt.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MomoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String momoNum = "";
	private String stream_stream_num = "";
	private String phase = "";
	private String momo_contents = "";
	private String create_id = "";
	private String create_date = "";
	private String update_date = "";
    private String user_master_member_id = "";
	//twt投稿者の情報をセット
	private List<UserBean> userList = new ArrayList<UserBean>();
	private String createName = "";
	private List<ReturnCommentBean> childList = new ArrayList<ReturnCommentBean>();
	private int childCount = 0;
	private String groupId = "";
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	public List<ReturnCommentBean> getChildList() {
		return childList;
	}
	public void setChildList(List<ReturnCommentBean> childList) {
		this.childList = childList;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	private String update_id = "";
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public String getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getMomoNum() {
		return momoNum;
	}
	public void setMomoNum(String momoNum) {
		this.momoNum = momoNum;
	}
	public String getStream_stream_num() {
		return stream_stream_num;
	}
	public void setStream_stream_num(String stream_stream_num) {
		this.stream_stream_num = stream_stream_num;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getMomo_contents() {
		return momo_contents;
	}
	public void setMomo_contents(String momo_contents) {
		this.momo_contents = momo_contents;
	}
	public String getUpdateId() {
		return update_id;
	}
	public void setUpdateId(String updateId) {
		this.update_id = updateId;
	}
	public String getUser_master_member_id() {
		return user_master_member_id;
	}
	public void setUser_master_member_id(String user_master_member_id) {
		this.user_master_member_id = user_master_member_id;
	}
	
	@Override
	public String toString() {
		return "MomoBean [momoNum=" + momoNum + ", stream_stream_num="
				+ stream_stream_num + ", phase=" + phase + ", momo_contents="
				+ momo_contents + ", create_id=" + create_id + ", create_date="
				+ create_date + ", update_date=" + update_date
				+ ", user_master_member_id=" + user_master_member_id
				+ ", userList=" + userList + ", createName=" + createName
				+ ", childList=" + childList + ", childCount=" + childCount
				+ ", groupId=" + groupId + ", update_id=" + update_id + "]";
	}

}
