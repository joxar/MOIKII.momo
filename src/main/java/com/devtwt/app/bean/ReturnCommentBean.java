package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ReturnCommentBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id = "";
	private String momo_momo_num = "";
	private String child_num = "";
	private String phase = "";
	private String return_contents = "";
	private String create_id = "";
	private String create_date = "";
	private String update_id = "";
	private String update_date = "";
    private String user_master_member_id = "";
    private String createName = "";
    private String groupId = "";
    
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMomo_momo_num() {
		return momo_momo_num;
	}
	public void setMomo_momo_num(String momo_momo_num) {
		this.momo_momo_num = momo_momo_num;
	}
	public String getChild_num() {
		return child_num;
	}
	public void setChild_num(String child_num) {
		this.child_num = child_num;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getReturn_contents() {
		return return_contents;
	}
	public void setReturn_contents(String return_contents) {
		this.return_contents = return_contents;
	}
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
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
	public String getUser_master_member_id() {
		return user_master_member_id;
	}
	public void setUser_master_member_id(String user_master_member_id) {
		this.user_master_member_id = user_master_member_id;
	}
	
	@Override
	public String toString() {
		return "ReturnCommentBean [id=" + id + ", momo_momo_num="
				+ momo_momo_num + ", child_num=" + child_num + ", phase="
				+ phase + ", return_contents=" + return_contents
				+ ", create_id=" + create_id + ", create_date=" + create_date
				+ ", update_id=" + update_id + ", update_date=" + update_date
				+ ", user_master_member_id=" + user_master_member_id
				+ ", createName=" + createName + ", groupId=" + groupId + "]";
	}
	

}
