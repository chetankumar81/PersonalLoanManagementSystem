package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class GetExistingLoan {
	
	private  int userId;
	private  Application app;
	private double emi;
	private String risk;
	
	public static  GetExistingLoan Details(int appId)
	{
		GetExistingLoan obj = new GetExistingLoan();
		
		if((obj.userId = new DatabaseAccess().getUserIdFromApplicationId(appId))==0)
		{
			return null;
		}
		
		if((obj.app = new DatabaseAccess().getLoanDEtailsFromApplicationId(appId))==null)
		{
			return null;
		}
		if((obj.emi = new DatabaseAccess().getExistingEMI(obj.userId))==0.0)
		{
			return null;
		}
		if((obj.risk = new CalculateRisk().getRisk(appId, obj.emi)).equals("error"))
		{
			return null;
		}
		
		return obj;
	}

	public int getUserId() {
		return userId;
	}

	public Application getApp() {
		return app;
	}

	public double getEmi() {
		return emi;
	}

	public String getRisk() {
		return risk;
	}
	
	
	
}
