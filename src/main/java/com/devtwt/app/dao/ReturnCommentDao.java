package com.devtwt.app.dao;

import java.util.List;

import com.devtwt.app.bean.ReturnCommentBean;

public interface ReturnCommentDao {
	
	public void insertData(ReturnCommentBean returnComment);
	public List<ReturnCommentBean> selectReturnCommentListByMomoId(String momoId, String groupId);

}
