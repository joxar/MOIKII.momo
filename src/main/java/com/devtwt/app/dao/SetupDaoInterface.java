package com.devtwt.app.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.SubDbacMockBean;

@Component
public interface SetupDaoInterface {
	
	public void setupTable() throws IOException, SQLException;
	public void setupRecData() throws SQLException;
	
}
