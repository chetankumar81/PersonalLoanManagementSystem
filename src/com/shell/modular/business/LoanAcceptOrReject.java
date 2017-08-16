package com.shell.modular.business;

import java.sql.Date;

public class LoanAcceptOrReject {
	private int loan_id;
	private int application_id;
	private Date date_of_approval;
	private double amount_sanctioned;
	private double interest_rate;
	private String reasons;
	private String status;
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public Date getDate_of_approval() {
		return date_of_approval;
	}
	public void setDate_of_approval(Date date_of_approval) {
		this.date_of_approval = date_of_approval;
	}
	public double getAmount_sanctioned() {
		return amount_sanctioned;
	}
	public void setAmount_sanctioned(double amount_sanctioned) {
		this.amount_sanctioned = amount_sanctioned;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
