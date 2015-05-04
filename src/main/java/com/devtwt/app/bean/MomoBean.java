package com.devtwt.app.bean;

import java.io.Serializable;

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

	private String update_date = "";
    private String user_master_member_id = "";
    
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
				+ momo_contents + ", create_id=" + create_id + ", update_id="
				+ update_id + ", update_date=" + update_date
				+ ", user_master_member_id=" + user_master_member_id + "]";
	}

}
