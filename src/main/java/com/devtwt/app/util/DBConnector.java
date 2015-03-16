package com.devtwt.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	final static String CON_STR = "jdbc:sqlite:/Users/snufkin/MySQLiteDB";
	final static String CON_USER = "MOIKII";
	final static String CON_PW= "MOIKII";
	
	/**
	 * @param args
	 */
	public Connection getConnector() {
		
		Connection conn = null;

		try {
			// JDBCドライバーの指定
			Class.forName("org.sqlite.JDBC");

			// データベースに接続する なければ作成される
			conn = DriverManager.getConnection(CON_STR, CON_USER, CON_PW);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}