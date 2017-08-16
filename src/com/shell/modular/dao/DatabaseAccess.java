package com.shell.modular.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shell.modular.business.*;

public class DatabaseAccess {
	private Connection currentCon;

	public Officers getOfficerDetails(String id) {

		Officers  officers = null;
		try
		{
			currentCon = new DBConnection().getConnection();
			String query = "SELECT * from officers where officer_id = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				int i=1;
				officers = new Officers();
				System.out.println(rs.getString(3));
				officers.officer_id = rs.getInt(i++);
				officers.role_id = rs.getInt(i++);
				officers.name = rs.getString(i++);
				officers.email_id = rs.getString(i++);
				officers.contact_no = rs.getString(i++);
				officers.username = rs.getString(i++);
				officers.password = rs.getString(i++);
				
			}

		}
		catch (Exception ex) 
		{
			System.out.println("Unable to retrive data: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return 	officers;
	}
	
	public ArrayList<Applications> getApplicationIdcm(String status) {
		ArrayList<Applications> applist = new ArrayList<Applications>();
		try
		{
			currentCon = new DBConnection().getConnection();
			String query = "SELECT application_id,loan_amount,name FROM loan_application WHERE status = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, status);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				
				int i=1;
				Applications app = new Applications();
				app.application_id = rs.getString(i++);
				app.loan_amount = rs.getString(i++);
				app.name = rs.getString(i++);
				applist.add(app);
			}

		}
		catch (Exception ex) 
		{
			System.out.println("Unable to retrive data: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return 	applist;
	}
	
	public Applications viewApplicationCM(String appid) {
		Applications app = new Applications();
		try
		{
			currentCon = new DBConnection().getConnection();
			String query = "SELECT * FROM loan_application WHERE application_id = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, appid);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				app.application_id = rs.getString(1);
				app.name = rs.getString(2);
				app.email_id = rs.getString(3);
				app.gender = rs.getString(4);
				app.date_of_birth = rs.getDate(5);
				app.age = rs.getString(6);
				app.contact_no = rs.getString(7);
				app.address = rs.getString(8);
				app.pan_no = rs.getString(9);
				app.loan_amount = rs.getString(10);
				app.monthly_income = rs.getString(11);
				app.company_name = rs.getString(12);
				app.designation = rs.getString(13);
				app.office_address = rs.getString(14);
				app.office_contact_no = rs.getString(15);
				app.office_email = rs.getString(16);
				app.existing_loan = rs.getString(17);
				app.photo = rs.getString(18);
				app.status = rs.getString(20);
				app.reg_id = rs.getString(21);
			}

		}
		catch (Exception ex) 
		{
			System.out.println("Unable to retrive data: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return 	app;
	}
		
	public ArrayList<Comments> getCommentsCM(String appid) {
		ArrayList<Comments> commlist = new ArrayList<Comments>();
		try
		{
			currentCon = new DBConnection().getConnection();
			String query = "select l.feedback,o.name,r.role_name from roles r,officers o,loan_officer_assign l where r.role_id = o.role_id and o.officer_id = l.officer_id and application_id = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, appid);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				Comments comm = new Comments();
				comm.feedback = rs.getString(1);
				comm.name = rs.getString(2);
				comm.role_name = rs.getString(3);
				commlist.add(comm);
			}

		}
		catch (Exception ex) 
		{
			System.out.println("Unable to retrive data: An Exception has occurred! " + ex);
		} 

		//some exception handling
		finally 
		{

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return 	commlist;
	}
}
