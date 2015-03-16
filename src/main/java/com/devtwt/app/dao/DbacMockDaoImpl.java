package com.devtwt.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.devtwt.app.bean.SubDbacMockBean;
import com.devtwt.app.dao.DaoInterface;
import com.devtwt.app.util.DBConnector;

@Component
public class DbacMockDaoImpl implements DaoInterface {
	
	DBConnector dbc = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<SubDbacMockBean> getAllData() throws SQLException {

		List<SubDbacMockBean> resultList = new ArrayList<SubDbacMockBean>();
		dbc = new DBConnector();
		conn = dbc.getConnector();
		
		if (conn != null) {
			
			String sql = "SELECT * FROM TEST_TBL;";
			
			try {
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					
					SubDbacMockBean sdmb = new SubDbacMockBean();
					
					sdmb.setCol1(rs.getString("COL1"));
					sdmb.setCol2(rs.getString("COL2"));
					sdmb.setCol3(rs.getString("COL3"));
					sdmb.setCol4(rs.getString("COL4"));
					sdmb.setCol5(rs.getString("COL5"));
					sdmb.setCol6(rs.getString("COL6"));
					sdmb.setCol7(rs.getString("COL7"));
					sdmb.setCol8(rs.getString("COL8"));
					sdmb.setCol9(rs.getString("COL9"));
					sdmb.setCol10(rs.getString("COL10"));
					
					resultList.add(sdmb);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				conn.close();
			}
			
		} else {
			System.out.println("NG!!!!!");
			
		}
		
		return resultList;
	}
	
	public void dropTable() throws SQLException {
		
		dbc = new DBConnector();
		conn = dbc.getConnector();
		
		if (conn != null) {
			
			String sql = "DROP TABLE TEST_TBL;";
			stmt = conn.createStatement();
			
			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
		}
	}
	
	public void createTable() throws SQLException {
		
		dbc = new DBConnector();
		conn = dbc.getConnector();
		
		if (conn != null) {
			
			String sql = "CREATE TABLE TEST_TBL("
					+ "COL1 char(10),"
					+ "COL2 char(10),"
					+ "COL3 char(10),"
					+ "COL4 char(10),"
					+ "COL5 char(10),"
					+ "COL6 char(10),"
					+ "COL7 char(10),"
					+ "COL8 char(10),"
					+ "COL9 char(10),"
					+ "COL10 char(10)"
					+ ")";
			
			stmt = conn.createStatement();

			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				conn.close();
			}
		}
	}
	
	public void insertData() throws SQLException {
		
		dbc = new DBConnector();

		
		if (conn != null) {
			
			for (int i=1; i<=100; i++) {
				
				conn = dbc.getConnector();
				
				String sql = "INSERT INTO TEST_TBL ("
						+ "COL1,"
						+ "COL2,"
						+ "COL3,"
						+ "COL4,"
						+ "COL5,"
						+ "COL6,"
						+ "COL7,"
						+ "COL8,"
						+ "COL9,"
						+ "COL10"
						+ ")"
						+ "VALUES ("
						+ "'"+i+"_1"+"',"
						+ "'"+i+"_2"+"',"
						+ "'"+i+"_3"+"',"
						+ "'"+i+"_4"+"',"
						+ "'"+i+"_5"+"',"
						+ "'"+i+"_6"+"',"
						+ "'"+i+"_7"+"',"
						+ "'"+i+"_8"+"',"
						+ "'"+i+"_9"+"',"
						+ "'"+i+"_10"+"'"
						+ ")";
				
				stmt = conn.createStatement();
	
				try {
					stmt.execute(sql);
				} catch (SQLException e) {
					e.printStackTrace();
					
				} finally {
					conn.close();
				}
			}
		}
	}
	
}
