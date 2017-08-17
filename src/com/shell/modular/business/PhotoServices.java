package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class PhotoServices {

	public static int forwardToappTable(Photo p)
	{
		// updates the database with the loan officer's feedback.
		
		  return new DatabaseAccess().submitPhoto(p);
}
}
