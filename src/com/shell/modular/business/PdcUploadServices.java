package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class PdcUploadServices {


	public static int forwardToappTable(Pdc p)
	{
		// updates the database with the loan officer's feedback.
		
		  return new DatabaseAccess().submitCheque(p);
				
	}

	
	
}
