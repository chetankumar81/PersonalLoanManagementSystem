package com.shell.modular.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shell.modular.business.Officers;

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
}
