package com.shell.modular.business;

public class ThirdPartyApplication {
	private String name,email_id,gender,address,comment,status;
	private int applicationId,contact_no;
	public ThirdPartyApplication(String name, String email_id, String gender, String address, int application_id,
			int contact_no) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.gender = gender;
		this.address = address;
		this.applicationId = application_id;
		this.contact_no = contact_no;
	}
	public ThirdPartyApplication(String comment, String status, int application_id) {
		super();
		this.comment = comment;
		this.status = status;
		this.applicationId = application_id;
	}
	public String getComment() {
		return comment;
	}
	public String getStatus() {
		return status;
	}
	public String getName() {
		return name;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getApplicationId() {
		return applicationId;
	}
	
	public int getContact_no() {
		return contact_no;
	}
	
	
	
	
}
