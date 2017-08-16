package com.shell.modular.business;

import java.util.ArrayList;

import com.shell.modular.dao.DatabaseAccess;

public class LoanOfficerServices {

	
	public static ArrayList<LoanOfficerApplication> viewNewApplications()
	{
		// call a databaseAccess function to display all the new applications.
		String status="new";
		ArrayList<LoanOfficerApplication> list = new ArrayList<>();
		list = new DatabaseAccess().loanOfficerViewApplication(status);

		return list;

	}
	
	public static ArrayList<LoanOfficerApplication> viewAllApplications(String username)
	{
		// call a databaseAccess function to display all the new applications.
		ArrayList<LoanOfficerApplication> list = new ArrayList<>();
		list = new DatabaseAccess().loanOfficerViewAllApplication(username);

		return list;
	}
  
	public static boolean forwardToInspector(String username,int applicationId,String comment)
	{
		// updates the database with the loan officer's feedback.
		
		return new DatabaseAccess().updatedByLoanOfficer(username,applicationId,comment);
				
	}
	
	public static ArrayList<LoanOfficerApplication> viewForwardApplications()
	{
		// call a databaseAccess function to display all the new applications.
		String status="forwardToUser";
		ArrayList<LoanOfficerApplication> list = new ArrayList<>();
		list = new DatabaseAccess().loanOfficerViewApplication(status);

		return list;

	}
	
	public static boolean forwardToUser(int applicationId)
	{
		// updates the database with the loan officer's feedback.
		
		return new DatabaseAccess().updatedByLoanOfficer(applicationId);
				
	}
	
	public static LoanOfficerApplication detailViewApplications(int id)
	{
		return new DatabaseAccess().viewApplicationById(id);
	}
	
}
