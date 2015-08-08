package com.devtwt.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;
import com.devtwt.app.dao.GroupDao;

@Component
public class GroupDaoImpl implements GroupDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public GroupBean selectGroupById(String groupId) {
		// TODO Auto-generated method stub
		GroupBean group = jdbcTemplate.queryForObject(
				"SELECT * FROM COMMUNITY WHERE COMMUNITY_ID = ?"
				, new RowMapper<GroupBean>() {
					public GroupBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						GroupBean g = new GroupBean();
						g.setGroupId(rs.getString("COMMUNITY_ID"));
						g.setGroupName(rs.getString("COMMUNITY_NAME"));
						g.setDevCategoryId(rs.getString("DEV_CATEGORY_COMMUNITY_ID"));
						g.setMemberId(rs.getString("MEMBER_ID"));
						g.setCreateId(rs.getString("CREATE_ID"));
						g.setCreateDate(rs.getString("CREATE_DATE"));
						g.setUpdateId(rs.getString("UPDATE_ID"));
						g.setUpdateDate(rs.getString("UPDATE_DATE"));
						return g;
					}}
				, groupId);
		
		return group;

	}

	@Override
	public void insertData(GroupBean group) {
		
    	//Groupを新規作成
    	jdbcTemplate.update(
                "INSERT INTO COMMUNITY (COMMUNITY_NAME, DEV_CATEGORY_COMMUNITY_ID, MEMBER_ID"
                			+ ", CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE) VALUES (?, ?, ?, ?, ?, ?, ?)"
                , group.getGroupName(), group.getDevCategoryId()
                		, group.getMemberId(), group.getCreateId(), group.getCreateDate()
                		, group.getUpdateId(), group.getUpdateDate());
	}

	@Override
	public List<GroupBean> selectGroupListBymemberId(String memberId) {
		// TODO Auto-generated method stub
		
		List<GroupBean> groupList = jdbcTemplate.query(
				"SELECT * FROM COMMUNITY WHERE MEMBER_ID = ?"
				, new RowMapper<GroupBean>() {
					public GroupBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						GroupBean groupBean = new GroupBean();
						groupBean.setGroupId(rs.getString("COMMUNITY_ID"));
						groupBean.setGroupName(rs.getString("COMMUNITY_NAME"));
						groupBean.setDevCategoryId(rs.getString("DEV_CATEGORY_COMMUNITY_ID"));
						groupBean.setMemberId(rs.getString("MEMBER_ID"));
						groupBean.setCreateId(rs.getString("CREATE_ID"));
						groupBean.setCreateDate(rs.getString("CREATE_DATE"));
						groupBean.setUpdateId(rs.getString("UPDATE_ID"));
						groupBean.setUpdateDate(rs.getString("UPDATE_DATE"));
						return groupBean;
					}}
				, memberId);
		
		return groupList;
	}
	
	

}
