package com.devtwt.app.command.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.RootBean;
import com.devtwt.app.command.PrflUpldCommand;
import com.devtwt.app.dao.ProfileImageDao;

@Component
public class PrflUpldCommandImpl implements PrflUpldCommand {
	
	@Autowired
	RootBean bean;
	@Autowired
	ProfileImageDao profileImageDao;
	
	byte[] fileContent = null;
	InputStream is = null;

	@Override
	public void preProc(RootBean bean) { this.bean = bean; }
	
	@Override
	public RootBean postProc() { return bean; }

	@Override
	public void exec() {
		
		try{
			
		is = bean.getProfileImage().getFile().getInputStream();
		
		//アップロードしたファイルをバイナリデータに変換
		fileContent = IOUtils.toByteArray(is);
		
		bean.getProfileImage().setBinary(fileContent);
		
		//ファイルをDBのBLOB型のカラムにセット
		profileImageDao.insertData(bean);
		bean.setProfileImage(profileImageDao.selectBinaryById("7"));
		System.out.println("B:" + bean.getProfileImage());
		}catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
		
	}

}
