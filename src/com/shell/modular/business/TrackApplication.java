package com.shell.modular.business;

import java.util.ArrayList;

import com.shell.modular.dao.DatabaseAccess;

public class TrackApplication {
	
	ArrayList<Tracking> applicationList = new ArrayList<Tracking>();
	public void trackLoan(int regID){		
			applicationList = new DatabaseAccess().getApplicationDetails(regID);

	}
	
	public ArrayList<Tracking> getApplications(){
		return applicationList;
	}

}
