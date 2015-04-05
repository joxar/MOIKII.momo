package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author snufkin
 *
 */
@Component
public class CommonInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mainMessage = "";
	
	public String getMainMessage() {
		return mainMessage;
	}
	public void setMainMessage(String mainMessage) {
		this.mainMessage = mainMessage;
	}
	
	@Override
	public String toString() {
		return "CommonInfoBean [mainMessage=" + mainMessage + "]";
	}

}
