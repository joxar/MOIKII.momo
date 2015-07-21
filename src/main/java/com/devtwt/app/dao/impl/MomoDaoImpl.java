package com.devtwt.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.MomoBean;
import com.devtwt.app.bean.RootBean;
import com.devtwt.app.dao.MomoDao;

@Component
public class MomoDaoImpl implements MomoDao {
	
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
	
	@Override
	public List<MomoBean> getAllData(String groupId) {
		// TODO Auto-generated method stub
		
		//過去の投稿を全て取得
		List<MomoBean> momoList = jdbcTemplate.query(
					"SELECT * FROM MOMO WHERE COMMUNITY_COMMUNITY_ID = ? ORDER BY MOMO_NUM DESC"
					, new RowMapper<MomoBean>() {
						public MomoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
							MomoBean momo = new MomoBean();
							momo.setMomoNum(rs.getString("MOMO_NUM"));
							momo.setStream_stream_num(rs.getString("STREAM_STEREAM_NUM"));
							momo.setPhase(rs.getString("PHASE"));
							momo.setMomo_contents(rs.getString("MOMO_CONTENTS"));
							momo.setCreate_id(rs.getString("CREATE_ID"));
							momo.setCreate_date(rs.getString("CREATE_DATE"));
							momo.setUpdate_id(rs.getString("UPDATE_ID"));
							momo.setUpdate_date(rs.getString("UPDATE_DATE"));
							momo.setUser_master_member_id(rs.getString("USER_MASTER_MEMBER_ID"));
							momo.setGroupId(rs.getString("COMMUNITY_COMMUNITY_ID"));
							return momo;
						}}
					, groupId);

		return momoList;
	}

	@Override
	public void exec(RootBean bean, String userName) {
		// TODO Auto-generated method stub
		
    	String DATE_PATTERN ="yyyy-MM-dd HH:mm:ss";
    	
    	//ログインアカウント名から、ユーザIDを取得し、beanの各プロパティにセット
    	String memberId = jdbcTemplate.queryForObject("SELECT MEMBER_ID FROM USER_MASTER WHERE MEMBER_NAME = ?", String.class, userName);
		bean.getMomo().setUser_master_member_id(memberId);
		bean.getMomo().setCreate_id(memberId);
		bean.getMomo().setUpdate_id(memberId);
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		
		bean.getMomo().setCreate_date(sdf.format(date));
		bean.getMomo().setUpdate_date(sdf.format(date));
		
    	//MOMOをテーブルにINSERT
		jdbcTemplate.update(
                "INSERT INTO MOMO (STREAM_STEREAM_NUM, PHASE, MOMO_CONTENTS, CREATE_ID"
                + ", CREATE_DATE, UPDATE_ID, UPDATE_DATE, USER_MASTER_MEMBER_ID, COMMUNITY_COMMUNITY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                , bean.getMomo().getStream_stream_num(), bean.getMomo().getPhase(),
                bean.getMomo().getMomo_contents(), bean.getMomo().getCreate_id(), bean.getMomo().getCreate_date(),
                bean.getMomo().getUpdate_id(), bean.getMomo().getUpdate_date(), bean.getMomo().getUser_master_member_id(),
                bean.getMomo().getGroupId());
	}

}
