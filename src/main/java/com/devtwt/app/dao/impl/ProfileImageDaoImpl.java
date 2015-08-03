package com.devtwt.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.bean.ProfileImageBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.ProfileImageDao;

@Component
public class ProfileImageDaoImpl implements ProfileImageDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public void insertData(RootBean bean) {
		
		jdbcTemplate.update(
                "INSERT INTO PROFILE_IMAGE (BINARY) VALUES (?)"
                , bean.getProfileImage().getBinary());
	}

	@Override
	public ProfileImageBean selectBinaryById(String Id) {
		
		ProfileImageBean profile = jdbcTemplate.queryForObject(
				"SELECT * FROM PROFILE_IMAGE WHERE ID = ?"
				, new RowMapper<ProfileImageBean>() {
					public ProfileImageBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						ProfileImageBean p = new ProfileImageBean();
						p.setId(rs.getString("ID"));
						p.setBinary(rs.getBytes("BINARY"));
						return p;
					}}
				, Id);
		
		return profile;
		
	}
	
	

}
