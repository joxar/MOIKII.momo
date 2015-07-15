package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.UserBean;

@Component
public class UserMasterDaoImpl implements UserMasterDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
	
    @Override
	public String getUserName(String userId) {
		// TODO Auto-generated method stub
    	String memberName = jdbcTemplate.queryForObject("SELECT MEMBER_NAME FROM USER_MASTER WHERE MEMBER_ID = ?"
    				, String.class, userId);
		return memberName;
	}
		
    @Override
	public UserBean getMember(String userId) {
		// TODO Auto-generated method stub
    	
    	UserBean member = jdbcTemplate.queryForObject(
				"SELECT * FROM USER_MASTER WHERE MEMBER_ID = ?"
				, new RowMapper<UserBean>() {
					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserBean m = new UserBean();
						m.setUserId(rs.getString("MEMBER_ID"));
						m.setUserName(rs.getString("MEMBER_NAME"));
						m.setUserPassword(rs.getString("PASSWORD"));
						m.setRoleId(rs.getString("ROLE_MASTER_ROLE_ID"));
						m.setCreateId(rs.getString("CREATE_ID"));
						m.setCreateDate(rs.getString("CREATE_DATE"));
						m.setUpdateId(rs.getString("UPDATE_ID"));
						m.setUpdateDate(rs.getString("UPDATE_DATE"));
						m.setDeleteFlag(rs.getString("DELETE_FLAG"));
						return m;
					}}
				, userId);
    	
		return member;
	}

	public void exec(RootBean bean) {
    	
    	//ユーザを新規作成
    	//Spring Securityとの関連で一時的に有効なアカウントのDELETE_FLAGを1に設定(無効なアカウントのDELETE_FLAGは、0)
    	jdbcTemplate.update(
                "INSERT INTO USER_MASTER (MEMBER_NAME, PASSWORD, ROLE_MASTER_ROLE_ID, DELETE_FLAG) VALUES (?, ?, ?, ?)"
                , bean.getUser().getUserName(),bean.getUser().getUserPassword(),bean.getUser().getSlctRoleId(), "1");
    }

	@Override
	public void updateRoleId(UserBean bean) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(
                "UPDATE USER_MASTER SET ROLE_MASTER_ROLE_ID=? WHERE MEMBER_ID = ?"
                , bean.getSlctRoleId(), bean.getUserId());
	}

	@Override
	public String getUserId(String userName) {
		// TODO Auto-generated method stub
		String userId = jdbcTemplate.queryForObject("SELECT MEMBER_ID FROM USER_MASTER WHERE MEMBER_NAME = ?"
				, String.class, userName);
	return userId;
	}
	
	
	
}
