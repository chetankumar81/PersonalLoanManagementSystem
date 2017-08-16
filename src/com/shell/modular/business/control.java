package com.shell.modular.business;

import java.sql.SQLException;

import com.shell.modular.dao.DatabaseAccess;

public class control {
	
	public static int checkp(String username,String password)
	{
		if((DatabaseAccess.checkpassword(username, password)) == 1)
			return 1;
		else if((DatabaseAccess.checkpassword(username, password)) == 2)
			return 2;
		else
			return 0;
	}
	
	public static String getQuestion(String username)
	{
		return DatabaseAccess.getQuestion(username);
	}
	
	public static String getAnswer(String username) 
	{
		try {
			return DatabaseAccess.getAnswer(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	public static int UpdatePassword(String username,String password)
	{
		if(DatabaseAccess.UpdatePassword(username, password)==1)
			return 1;
		else
			return 0;
	}
}
