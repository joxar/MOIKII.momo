package com.devtwt.app.command.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.PrflUpldCommand;
import com.devtwt.app.dao.ProfileImageDao;
import com.devtwt.app.dao.UserMasterDao;

@Component
public class PrflUpldCommandImpl implements PrflUpldCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	ProfileImageDao profileImageDao;
	@Autowired
	UserMasterDao userDao;
	
	byte[] fileContent = null;
	InputStream is = null;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec(String userName) {
		
		try{
			
		is = bean.getProfileImage().getFile().getInputStream();
		
		//アップロードしたファイルをバイナリデータに変換
		fileContent = IOUtils.toByteArray(is);
		
		bean.getProfileImage().setBinary(fileContent);
		
		//ファイルをDBのBLOB型のカラムにセット
		profileImageDao.insertData(bean);
		
		int tmp = profileImageDao.selectMaxId();
		String maxId = Integer.toString(tmp);
		String userId = userDao.getUserId(userName);
		userDao.updateProfileId(userId, maxId);
	
		
		}catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
		
	}

}
