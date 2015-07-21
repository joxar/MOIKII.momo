package com.devtwt.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.dao.DevCategoryDao;

@Component
public class DevCategoryDaoImpl implements DevCategoryDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public DevCategoryBean getDevCategory(String id) {
		// TODO Auto-generated method stub
		
		DevCategoryBean devCategory = jdbcTemplate.queryForObject(
				"SELECT * FROM DEV_CATEGORY WHERE COMMUNITY_ID = ?"
				, new RowMapper<DevCategoryBean>() {
					public DevCategoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						DevCategoryBean d = new DevCategoryBean();
						d.setDevCategoryId(rs.getString("COMMUNITY_ID"));
						d.setDevCategoryName(rs.getString("DEV_CATEGORY"));
						d.setPhase(rs.getString("PHASE"));
						d.setCreateId(rs.getString("CREATE_ID"));
						d.setCreateDate(rs.getString("CREATE_DATE"));
						d.setUpdateId(rs.getString("UPDATE_ID"));
						d.setUpdateDate(rs.getString("UPDATE_DATE"));
						return d;
					}}
				, id);
		
		return devCategory;
	}

    
}
