package com.devtwt.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

}
