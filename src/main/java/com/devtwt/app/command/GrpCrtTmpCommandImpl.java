package com.devtwt.app.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.RootBean;

@Component
public class GrpCrtTmpCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		
		DevCategoryBean dev;
		List<String> list = new ArrayList<String>(Arrays.asList("BD", "SD", "CD", "UT", "LT", "ST", "UAT"));
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"ウォーターフォール", "プロトタイピング", "インクリメンタル", "スパイラル", "RAD", "エクストリームプログラミング"};
		
		/*** 開発カテゴリ ***/
		for (int i=0; i<arr1.length; i++) {
			dev = new DevCategoryBean();
			/*** カテゴリID ***/
			dev.setDevCategoryId(arr1[i]);
			/*** カテゴリ名 ***/
			dev.setDevCategoryName(arr2[i]);
			this.bean.getGroup().getDevCategoryList().add(dev);
		}
		
		/*** フェーズ名リスト ***/
		this.bean.getGroup().getDevCategory().setPhNameList(list);
		
		/*** 被選択開発カテゴリ ***/
		this.bean.getGroup().setSlctDevCateId(bean.getGroup().getSlctDevCateId());
	}
}
