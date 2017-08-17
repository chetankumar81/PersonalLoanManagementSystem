package com.shell.modular.business;

public class LoanOfficerApplication {
	private int applicationId,age;
	private long officeContactNo,contactNo;
	private String name,emialId,gender,address,panNo,companyName,designation,officeAddress,officeEmail,existingLoan,photoUrl,docUrl;
	private double loanAmount,monthlyIncome;
	private String comment,statusByOfficer;
	
	
	public String getComment() {
		return comment;
	}
	
	public String getStatusByOfficer() {
		return statusByOfficer;
	}

	public LoanOfficerApplication(int applicationId, String comment, String statusByOfficer) {
		super();
		this.applicationId = applicationId;
		this.comment = comment;
		this.statusByOfficer = statusByOfficer;
	}


	public LoanOfficerApplication(int applicationId, long contactNo, int age, long officeContactNo, String name,
			String emialId, String gender, String address, String panNo, String companyName,
			String designation, String officeAddress, String officeEmail, String existingLoan, String photoUrl,
			String docUrl, double loanAmount, double monthlyIncome) {
		super();
		this.applicationId = applicationId;
		this.contactNo = contactNo;
		this.age = age;
		this.officeContactNo = officeContactNo;
		this.name = name;
		this.emialId = emialId;
		this.gender = gender;
		
		this.address = address;
		this.panNo = panNo;
		this.companyName = companyName;
		this.designation = designation;
		this.officeAddress = officeAddress;
		this.officeEmail = officeEmail;
		this.existingLoan = existingLoan;
		this.photoUrl = photoUrl;
		this.docUrl = docUrl;
		this.loanAmount = loanAmount;
		this.monthlyIncome = monthlyIncome;
	}


	public int getApplicationId() {
		return applicationId;
	}


	public long getContactNo() {
		return contactNo;
	}


	public int getAge() {
		return age;
	}


	public long getOfficeContactNo() {
		return officeContactNo;
	}


	public String getName() {
		return name;
	}


	public String getEmialId() {
		return emialId;
	}


	public String getGender() {
		return gender;
	}


	


	public String getAddress() {
		return address;
	}


	public String getPanNo() {
		return panNo;
	}


	public String getCompanyName() {
		return companyName;
	}


	public String getDesignation() {
		return designation;
	}


	public String getOfficeAddress() {
		return officeAddress;
	}


	public String getOfficeEmail() {
		return officeEmail;
	}


	public String getExistingLoan() {
		return existingLoan;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public String getDocUrl() {
		return docUrl;
	}


	public double getLoanAmount() {
		return loanAmount;
	}


	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	
	
	
	
}
