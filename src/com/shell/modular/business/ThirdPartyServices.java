package com.shell.modular.business;

import java.util.ArrayList;

import com.shell.modular.dao.DatabaseAccess;

public class ThirdPartyServices {

	public static boolean validation(String username , String password)
	{
		if(new DatabaseAccess().thirdPartyValidation(username,password)){
			return true;
		}
		else
			return false;

	}

	public static ArrayList<ThirdPartyApplication> viewNewApplications()
	{
		// call a databaseAccess function to display all the new applications.
		ArrayList<ThirdPartyApplication> list = new ArrayList<>();
		list = new DatabaseAccess().thirdPartyViewNewApplication();

		return list;

	}
	
	public static ArrayList<ThirdPartyApplication> viewAllApplications(String username)
	{
		// call a databaseAccess function to display all the new applications.
		ArrayList<ThirdPartyApplication> list = new ArrayList<>();
		list = new DatabaseAccess().thirdPartyViewAllApplication(username);

		return list;
	}
  
	public static boolean updateStatusOfApplication(String username,int applicationId,String comment,String status)
	{
		return new DatabaseAccess().updatedByThirdParty(username,applicationId,comment,status);
	}

}
