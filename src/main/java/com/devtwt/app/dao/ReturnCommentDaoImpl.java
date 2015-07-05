package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.ReturnCommentBean;

@Component
public class ReturnCommentDaoImpl implements ReturnCommentDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public void insertData(ReturnCommentBean returnComment) {
		// TODO Auto-generated method stub

		//Groupを新規作成
    	jdbcTemplate.update(
                "INSERT INTO RETURN_COMMENT (MOMO_MOMO_NUM, CHILD_NUM, PHASE, RETURN_CONTENTS, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE, USER_MASTER_MEMBER_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                , returnComment.getMomo_momo_num(), returnComment.getChild_num(), returnComment.getPhase()
                , returnComment.getReturn_contents(), returnComment.getCreate_id(), returnComment.getCreate_date()
                , returnComment.getUpdate_id(), returnComment.getUpdate_date(), returnComment.getUser_master_member_id());
	}

	@Override
	public List<ReturnCommentBean> selectReturnCommentListByMomoId(String momoId) {
		// TODO Auto-generated method stub
		
		//過去の投稿を全て取得
				List<ReturnCommentBean> replyList = jdbcTemplate.query(
							"SELECT * FROM RETURN_COMMENT WHERE MOMO_MOMO_NUM = ? ORDER BY CHILD_NUM ASC"
							, new RowMapper<ReturnCommentBean>() {
								public ReturnCommentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
									ReturnCommentBean reply = new ReturnCommentBean();
									reply.setId(rs.getString("ID"));
									reply.setMomo_momo_num(rs.getString("MOMO_MOMO_NUM"));
									reply.setChild_num(rs.getString("CHILD_NUM"));
									reply.setPhase(rs.getString("PHASE"));
									reply.setReturn_contents(rs.getString("RETURN_CONTENTS"));
									reply.setCreate_id(rs.getString("CREATE_ID"));
									reply.setCreate_date(rs.getString("CREATE_DATE"));
									reply.setUpdate_id(rs.getString("UPDATE_ID"));
									reply.setUpdate_date(rs.getString("UPDATE_DATE"));
									reply.setUser_master_member_id(rs.getString("USER_MASTER_MEMBER_ID"));
									return reply;
								}}
							, momoId);

				return replyList;
		
	}
	
	

}
