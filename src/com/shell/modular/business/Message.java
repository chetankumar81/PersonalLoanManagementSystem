package com.shell.modular.business;

import java.sql.Date;

public class Message {

	private int loan_id;
	private int app_id;
	private Date approval_date;
	private float amount_sanctioned;
	private float interest_rate;
	private float emi_assigned;
	private String reason;
	private String status;
	private int loan_duration;
	
	
	public int getLoan_id() {
		return loan_id;
	}


	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}


	public int getApp_id() {
		return app_id;
	}


	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}


	public Date getApproval_date() {
		return approval_date;
	}


	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}


	public float getAmount_sanctioned() {
		return amount_sanctioned;
	}


	public void setAmount_sanctioned(float amount_sanctioned) {
		this.amount_sanctioned = amount_sanctioned;
	}


	public float getInterest_rate() {
		return interest_rate;
	}


	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}


	public float getEmi_assigned() {
		return emi_assigned;
	}


	public void setEmi_assigned(float emi_assigned) {
		this.emi_assigned = emi_assigned;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getLoan_duration() {
		return loan_duration;
	}


	public void setLoan_duration(int loan_duration) {
		this.loan_duration = loan_duration;
	}


	
	
	
	
		
}
