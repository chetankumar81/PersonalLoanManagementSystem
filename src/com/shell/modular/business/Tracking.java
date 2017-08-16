package com.shell.modular.business;

import java.sql.Timestamp;
// pojo class
public class Tracking {
	private int appID;
	private Timestamp applied_date;
	private String status;
	
	
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	public Timestamp getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Timestamp applied_date) {
		this.applied_date = applied_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
