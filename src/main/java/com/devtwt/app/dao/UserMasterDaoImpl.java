package com.devtwt.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import com.devtwt.app.bean.RootBean;

@Component
public class UserMasterDaoImpl implements UserMasterDao {
	
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		
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
    	jdbcTemplate.update(
                "INSERT INTO USER_MASTER (MEMBER_ID, MEMBER_NAME, PASSWORD, ROLE_MASTER_ROLE_ID, DELETE_FLAG) VALUES (?, ?, ?, ?, ?)"
                , bean.getUser().getUserId(), bean.getUser().getUserName(),bean.getUser().getUserPassword(),bean.getUser().getRoleId(), "0");
    }
}
