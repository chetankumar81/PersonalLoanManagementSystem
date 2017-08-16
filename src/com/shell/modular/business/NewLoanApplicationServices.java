package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class NewLoanApplicationServices {

	public static int forwardToAppTable(NewLoanApplication loanapp)
	{
		// updates the database with the loan officer's feedback.
		
		  return new DatabaseAccess().submitNewLoanApplication(loanapp);
				
	}

}

