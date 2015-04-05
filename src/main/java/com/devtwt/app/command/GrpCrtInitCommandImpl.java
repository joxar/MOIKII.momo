package com.devtwt.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtwt.app.bean.DevCategoryBean;
import com.devtwt.app.bean.RootBean;

@Component
public class GrpCrtInitCommandImpl implements MockCommandInterface {

	@Autowired
	private RootBean bean;
	
	public void preProc(RootBean bean) { this.bean = bean; }
	public RootBean postProc() { return this.bean; }
	
	public void exec() {
		DevCategoryBean dev;
		String[] arr1 = {"01", "02", "03", "04", "05", "06"};
		String[] arr2 = {"ウォーターフォール", "プロトタイピング", "インクリメンタル", "スパイラル", "RAD", "エクストリームプログラミング"};
		
		for (int i=0; i<arr1.length; i++) {
			dev = new DevCategoryBean();
			/*** カテゴリID ***/
			dev.setDevCategoryId(arr1[i]);
			/*** カテゴリ名 ***/
			dev.setDevCategoryName(arr2[i]);
			bean.getGroup().getDevCategoryList().add(dev);
		}
	}
}
