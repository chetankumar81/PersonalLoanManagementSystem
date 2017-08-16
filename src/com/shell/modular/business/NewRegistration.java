package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class NewRegistration {


	public static int forwardToRegTable(Registration reg)
	{
		// updates the database with registration Details.
		
		  return new DatabaseAccess().submitRegistration(reg); // write the dao function
		  
	}

}
