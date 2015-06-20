package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RoleBean;

@Component
public class RoleDaoImpl implements RoleDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public List<RoleBean> getAllData() {
		// TODO Auto-generated method stub
		
		//過去の投稿を全て取得
				List<RoleBean> roleList = jdbcTemplate.query(
							"SELECT * FROM ROLE_MASTER ORDER BY ROLE_ID ASC"
							, new RowMapper<RoleBean>() {
								public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
									RoleBean role = new RoleBean();
									role.setRoleId(rs.getString("ROLE_ID"));
									role.setRoleName(rs.getString("ROLE_NAME"));
									return role;
								}
							});
		
		return roleList;
	}

	@Override
	public String getRoleName(String roleId) {
		// TODO Auto-generated method stub
		String roleName = jdbcTemplate.queryForObject("SELECT ROLE_NAME FROM ROLE_MASTER WHERE ROLE_ID = ?"
				, String.class, roleId);
		return roleName;
	}
	

}
