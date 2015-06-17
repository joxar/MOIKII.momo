package com.devtwt.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;

@Component
public class JoinRequestDaoImpl implements JoinRequestDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public void insertData(RootBean bean) {
		// TODO Auto-generated method stub
		
		//JoinRequestを新規作成。IDとSTATUSはデフォルトで設定されるため、INSERTしない
    	jdbcTemplate.update(
                "INSERT INTO JOIN_REQUEST (COMMUNITY_COMMUNITY_ID, USER_MASTER_MEMBER_ID"
                			+ ", CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE) VALUES (?, ?, ?, ?, ?, ?)"
                , bean.getGroup().getSlctGroupId(), bean.getJoinRequest().getMemberId(), bean.getJoinRequest().getMemberId()
                		, bean.getGroup().getCreateDate(), bean.getGroup().getUpdateId(), bean.getGroup().getUpdateDate());
		
	}

}
