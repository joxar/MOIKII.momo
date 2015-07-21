package com.devtwt.app.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author snufkin
 *
 */
@Component
public class ViewBean implements Serializable {
	
	private String viewID = "";
	
	public String getViewID() {
		return viewID;
	}

	public void setViewID(String viewID) {
		this.viewID = viewID;
	}

	@Override
	public String toString() {
		return "ViewBean [viewID=" + viewID + "]";
	}

	private static final long serialVersionUID = 1L;
	
	
		
}
