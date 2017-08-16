package com.shell.modular.business;

import java.sql.Timestamp;
// pojo class
public class Tracking {
	private int appID;
	//private Timestamp applied_date;
	private String status;
	
	
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
