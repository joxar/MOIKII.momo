package com.devtwt.app.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.devtwt.app.bean.RootBean;

@Component
public class MomoDaoImpl implements MomoDao {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-jdbc.xml");
    
    // JdbcTemplateのオブジェクトを取得
    JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

	@Override
	public void exec(RootBean bean) {
		// TODO Auto-generated method stub
		
		String momoNum;
    	int tmp,cnt;
		
        cnt = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM MOMO");
    	
    	//テーブルMOMOのデータが0件の場合
    	if(cnt == 0) {
    		momoNum = "0";
    	} else {
    		momoNum  = jdbcTemplate.queryForObject("SELECT MAX(MOMO_NUM) FROM MOMO", String.class);
    	}
    	
    	System.out.println("NUM!1" + momoNum);
    	
    	//MOMO_NUMをインクリメント
    	System.out.println("NUM!a" + bean.getMomo().getMomoNum());
    	tmp = Integer.parseInt(momoNum);
    	bean.getMomo().setMomoNum(String.valueOf(++tmp));
    	System.out.println("NUM!b" + bean.getMomo().getMomoNum());
    	
    	//AllowNullがfalseのカラムに値を設定
    	bean.getMomo().setStream_stream_num("1");
    	bean.getMomo().setUpdate_id("1");
		
    	//MOMOをテーブルにINSERT
		jdbcTemplate.update(
                "INSERT INTO MOMO (MOMO_NUM, STREAM_STEREAM_NUM, PHASE, MOMO_CONTENTS, CREATE_ID"
                + ", CREATE_DATE, UPDATE_ID, UPDATE_DATE, USER_MASTER_MEMBER_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
                , bean.getMomo().getMomoNum(), bean.getMomo().getStream_stream_num(), bean.getMomo().getPhase(),
                bean.getMomo().getMomo_contents(), bean.getMomo().getCreate_id(), bean.getMomo().getCreate_date(),
                bean.getMomo().getUpdate_id(), bean.getMomo().getUpdate_date(), bean.getMomo().getUser_master_member_id());
	}

}
