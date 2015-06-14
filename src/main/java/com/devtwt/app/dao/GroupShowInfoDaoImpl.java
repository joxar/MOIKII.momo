package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;

@Component
public class GroupShowInfoDaoImpl implements GroupShowInfoDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public List<String> getAllGroupName() {
		// TODO Auto-generated method stub
		
		//登録されているGroup Nameの一覧を取得
		List<String> groupNameList = jdbcTemplate.queryForList(
				"SELECT DISTINCT COMMUNITY_NAME FROM COMMUNITY", String.class);
		
		return groupNameList;
	}

	@Override
	public List<GroupBean> getGroupInfo(String slctGroupName) {
		// TODO Auto-generated method stub
		
		//Group Create画面に表示するDevCategoryを取得
				List<GroupBean> groupList = jdbcTemplate.query(
						"SELECT * FROM COMMUNITY WHERE COMMUNITY_NAME = ?"
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
						, slctGroupName);

		return groupList;
	}	

}
