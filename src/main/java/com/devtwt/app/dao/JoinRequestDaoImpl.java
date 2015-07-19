package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.JoinRequestBean;
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

	@Override
	public List<JoinRequestBean> getAllRequestData() {
		// TODO Auto-generated method stub
		
		//過去の投稿を全て取得
				List<JoinRequestBean> requestList = jdbcTemplate.query(
							"SELECT * FROM JOIN_REQUEST WHERE STATUS = 'REQUEST' ORDER BY REQUEST_ID DESC"
							, new RowMapper<JoinRequestBean>() {
								public JoinRequestBean mapRow(ResultSet rs, int rowNum) throws SQLException {
									JoinRequestBean req = new JoinRequestBean();
									req.setRequestId(rs.getString("REQUEST_ID"));
									req.setStatus(rs.getString("STATUS"));
									req.setCommunityId(rs.getString("COMMUNITY_COMMUNITY_ID"));
									req.setMemberId(rs.getString("USER_MASTER_MEMBER_ID"));
									req.setCreateId(rs.getString("CREATE_ID"));
									req.setCreateDate(rs.getString("CREATE_DATE"));
									req.setUpdateId(rs.getString("UPDATE_ID"));
									req.setUpdateDate(rs.getString("UPDATE_DATE"));
									return req;
								}
							});
		return requestList;
	}

	@Override
	public void updateStatus(JoinRequestBean req) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(
                "UPDATE JOIN_REQUEST SET STATUS=? WHERE REQUEST_ID = ?"
                , req.getStatus(), req.getRequestId());
	}

}
