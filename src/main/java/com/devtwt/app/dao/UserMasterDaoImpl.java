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
    	
    	String memberId;
    	int tmp,cnt;
    	
    	cnt = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USER_MASTER");
    	
    	//テーブルUSER_MASTERのデータが0件の場合
    	if(cnt == 0) {
    		memberId = "0";
    	} else {
    		memberId = jdbcTemplate.queryForObject("SELECT MAX(MEMBER_ID) FROM USER_MASTER", String.class);
    	}
        
    	//USER_IDをインクリメント
    	tmp = Integer.parseInt(memberId);
    	bean.getUser().setUserId(String.valueOf(++tmp));
    	
    	//AllowNullがfalseのカラムに値を設定
    	bean.getUser().setRoleId("1");
    	
    	cnt = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM ROLE_MASTER WHERE ROLE_ID = 1");
    	
    	//テーブルROLE_MASTERにROLE_ID:1のデータがない場合
    	if(cnt == 0){
    		jdbcTemplate.update("INSERT INTO ROLE_MASTER (ROLE_ID) VALUES(1)");
    	}
    	
    	//ユーザを新規作成
    	//Spring Securityとの関連で一時的に有効なアカウントのDELETE_FLAGを1に設定(無効なアカウントのDELETE_FLAGは、0)。
    	jdbcTemplate.update(
                "INSERT INTO USER_MASTER (MEMBER_ID, MEMBER_NAME, PASSWORD, ROLE_MASTER_ROLE_ID, DELETE_FLAG) VALUES (?, ?, ?, ?, ?)"
                , bean.getUser().getUserId(), bean.getUser().getUserName(),bean.getUser().getUserPassword(),bean.getUser().getRoleId(), "1");
    }
}
