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
	private boolean updatable = false;
	private boolean requestable_join = false;
	

	public boolean isUpdatable() {
		return updatable;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}

	public boolean isRequestable_join() {
		return requestable_join;
	}

	public void setRequestable_join(boolean requestable_join) {
		this.requestable_join = requestable_join;
	}

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
