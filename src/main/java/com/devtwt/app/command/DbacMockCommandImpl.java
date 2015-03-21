package com.devtwt.app.command;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.bean.SubDbacMockBean;
import com.devtwt.app.dao.CopyOfDbacMockDaoImpl;
import com.devtwt.app.dao.DaoInterface;
import com.devtwt.app.dao.DbacMockDaoImpl;

@Component
public class DbacMockCommandImpl implements MockCommandInterface {

	private DaoInterface dao = new DbacMockDaoImpl();
	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		String num = bean.getDbacMock().getSelectedTBL();
		
		try {
			
			if (num.equals("1")) {
				dao.dropTable();
				dao.createTable();
				dao.insertData();
				
			} else if (num.equals("2")) {
				List<SubDbacMockBean> resultList;
				resultList = dao.getAllData();
				((RootBean)this.bean).getDbacMock().setTestDataList(resultList);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
