package com.shell.modular.business;

import java.sql.Date;
import java.sql.Timestamp;

public class Application {
	private int application_id;
	private String name;
	private String email_id;
	private String gender;
	private Date date_of_birth;
	private int age;
	private long contact_no;
	private String address;
	private String pan_no;
	private double loan_amount;
	private double monthly_income;
	private String company_name;
	private String designation;
	private String office_address;
	private long office_contact_no;
	private String office_email;
	private boolean existing_loan;
	private String status;
	private int reg_Id;
	private Timestamp applied_date;
	private double interest_rate;
	private int duration_in_months;
	
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public int getDuration_in_months() {
		return duration_in_months;
	}
	public void setDuration_in_months(int duration_in_months) {
		this.duration_in_months = duration_in_months;
	}
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public double getLoan_amount() {
		return loan_amount;
	}
	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}
	public double getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(double monthly_income) {
		this.monthly_income = monthly_income;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOffice_address() {
		return office_address;
	}
	public void setOffice_address(String office_address) {
		this.office_address = office_address;
	}
	public long getOffice_contact_no() {
		return office_contact_no;
	}
	public void setOffice_contact_no(long office_contact_no) {
		this.office_contact_no = office_contact_no;
	}
	public String getOffice_email() {
		return office_email;
	}
	public void setOffice_email(String office_email) {
		this.office_email = office_email;
	}
	public boolean isExisting_loan() {
		return existing_loan;
	}
	public void setExisting_loan(boolean existing_loan) {
		this.existing_loan = existing_loan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getReg_Id() {
		return reg_Id;
	}
	public void setReg_Id(int reg_Id) {
		this.reg_Id = reg_Id;
	}
	public Timestamp getApplied_date() {
		return applied_date;
	}
	public void setApplied_date(Timestamp applied_date) {
		this.applied_date = applied_date;
	}
	
	

}
