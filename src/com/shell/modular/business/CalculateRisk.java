package com.shell.modular.business;

import com.shell.modular.dao.DatabaseAccess;

public class CalculateRisk {
	public String getRisk(int appId,double emi){
		String res = null;
		Application app;
		//double intrest1;
		double result=0.0;
		double month_aggr;
		app = new DatabaseAccess().getLoanDEtailsFromApplicationId(appId);
		
		if(app==null){
			res="error";
		}
		
		else{
			
			double year = app.getDuration_in_months()/12;
			double interest = app.getLoan_amount()+(app.getLoan_amount()*app.getInterest_rate()*year)/100;
			result= interest/12;
			month_aggr = app.getMonthly_income()-emi;
			
			if(month_aggr>result){
				res="Low Risk";
			}
			else{
				res="High Risk";
			}
		}

		return res;

	}
	public double getEmi(int appId){
		String res = null;
		Application app;
		//double intrest1;
		double result=0.0;
		double month_aggr;
		app = new DatabaseAccess().getLoanDEtailsFromApplicationId(appId);
		
		if(app==null){
			res="error";
		}
		
		else{
			
			double year = app.getDuration_in_months()/12;
			double interest = app.getLoan_amount()+(app.getLoan_amount()*app.getInterest_rate()*year)/100;
			result= interest/12;
			
		}

		return result;

	}
	public double getAmountSanctioned(int appId){
		String res = null;
		Application app;
		//double intrest1;
		double amount=0.0;
		double month_aggr;
		app = new DatabaseAccess().getLoanDEtailsFromApplicationId(appId);
		
		if(app==null){
			res="error";
		}
		
		else{
			double saving=app.getLoan_amount()*0.25;//net saving
			//double year = app.getDuration_in_months()/12;
			double max_amount = saving*app.getDuration_in_months();
			double loan_amount = app.getLoan_amount();
			amount = Math.min(max_amount, loan_amount);
			//result= interest/12;
			
		}

		return amount;

	}


}
