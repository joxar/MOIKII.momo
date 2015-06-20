package com.devtwt.app.dao;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Component;


@Component
public interface SetupDaoInterface {
	
	public void setupTable() throws IOException, SQLException;
	public void setupRecData() throws SQLException;
	
}
