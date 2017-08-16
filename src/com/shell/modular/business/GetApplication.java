package com.shell.modular.business;

import java.util.ArrayList;

import com.shell.modular.dao.DatabaseAccess;

public class GetApplication {

	public static ArrayList<Integer> getApplicationIdForLoanInspector()
	{
		return new DatabaseAccess().getApplicationIdForLoanInspector();
	}
	
}
