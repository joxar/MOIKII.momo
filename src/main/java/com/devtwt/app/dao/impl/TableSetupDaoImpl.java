package com.devtwt.app.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.devtwt.app.dao.SetupDaoInterface;
import com.devtwt.app.util.DBConnector;

@Component
public class TableSetupDaoImpl implements SetupDaoInterface {
	
	DBConnector dbc = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	public void setupTable() throws IOException, SQLException {
		
		dbc = new DBConnector();
		conn = dbc.getConnector();
		String sql = "";
		String line = "";
		String sqlFileName = "/Users/snufkin/git/MOIKII/MOIKII.momo/src/main/java/com/devtwt/app/dao/out.sql";
		
		sql = inputSqlFile(sqlFileName);
		
		if (conn != null) {
			stmt = conn.createStatement();
			
			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				stmt.close();
				conn.close();
			}
		}
	}
	
	private String inputSqlFile(String fName) throws IOException {
		File file = new File(fName);
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		String result = "";
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while ( (line=br.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
			fr.close();
		}
		return result;
	}
	
	public void setupRecData() throws SQLException {
	}
	
}
