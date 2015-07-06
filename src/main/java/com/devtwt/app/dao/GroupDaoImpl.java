package com.devtwt.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.GroupBean;

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
		// TODO Auto-generated method stub
		String communityId;
    	int tmp,cnt;
    	
    	cnt = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM COMMUNITY");
    	
    	//テーブルCOMMUNITYのデータが0件の場合
    	if(cnt == 0) {
    		communityId = "0";
    	} else {
    		communityId = jdbcTemplate.queryForObject("SELECT MAX(COMMUNITY_ID) FROM COMMUNITY", String.class);
    	}
        
    	//COMMUNITY_IDをインクリメント
    	tmp = Integer.parseInt(communityId);
    	group.setGroupId(String.valueOf(++tmp));
    	
    	//Groupを新規作成
    	jdbcTemplate.update(
                "INSERT INTO COMMUNITY (COMMUNITY_ID, COMMUNITY_NAME, DEV_CATEGORY_COMMUNITY_ID, MEMBER_ID"
                			+ ", CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
                , group.getGroupId(), group.getGroupName(), group.getDevCategoryId()
                		, group.getMemberId(), group.getCreateId(), group.getCreateDate()
                		, group.getUpdateId(), group.getUpdateDate());
	}

}
