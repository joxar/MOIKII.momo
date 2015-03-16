package com.devtwt.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.SubDbacMockBean;

@Component
public interface DaoInterface {
	
	public List<SubDbacMockBean> getAllData() throws SQLException;
	public void dropTable() throws SQLException;
	public void createTable() throws SQLException;
	public void insertData() throws SQLException;
	
}
