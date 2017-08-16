package com.shell.modular.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shell.modular.business.Registration;
import com.shell.modular.business.Application;
import com.shell.modular.business.Applications;
import com.shell.modular.business.Comments;
import com.shell.modular.business.LoanOfficerApplication;
import com.shell.modular.business.Message;
import com.shell.modular.business.NewLoanApplication;
import com.shell.modular.business.Officers;
import com.shell.modular.business.Pdc;
import com.shell.modular.business.ThirdPartyApplication;
import com.shell.modular.business.Tracking;
import com.shell.util.DBConnection;

public class DatabaseAccess {
	private Connection currentCon;
	public boolean updatedByLoanInspector(String username,int applicationId,String risk,String comment)
	{	
		int officerId;
		try
		{
			currentCon = DBConnection.getConnection();
			String queryForOfficerId = "select * from officers where username ='" +username+ "'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(queryForOfficerId);
			if(resultSet.next())
			{
				officerId=resultSet.getInt("officer_id");
				System.out.println(officerId);
			}
			else
			{
				System.out.println("Executing 43 of databaseaccess");
				return false;
			}

			String changeStatus="update loan_application set status = 'creditManager' where application_id='"+applicationId+"'";
			Statement stat2 = currentCon.createStatement();
			if(stat2.executeUpdate(changeStatus)!=0)
			{
		
				String loanOfficerstatus ="insert into loan_officer_assign values (" + applicationId + "," + officerId + "," + "'" + risk + "','" + comment +"' )";
				Statement stat3 = currentCon.createStatement();
				if(stat3.executeUpdate(loanOfficerstatus)!=0)
				{
					return true;
				}
				else
				{
					return false;
				}


			}
			else
			{
				return false;
			}

		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
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

	}
	//function to authenticate the third party
	public boolean thirdPartyValidation(String username ,String password)
	{
		try{
			String query = "select * from officers where username='" +username +"' and password ='" + password + "'" ;
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);
			if(resultSet.next())
			{	
				return true;
			}
			else
			{
				return false;
			}


		}catch(Exception e)
		{
			return false;
		}
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

	}

	public ArrayList<ThirdPartyApplication> thirdPartyViewNewApplication()
	{
		ArrayList<ThirdPartyApplication> list = new ArrayList<ThirdPartyApplication>();
		try{

			String status = "new";  
			String query = "select * from loan_application where status='"+status+"'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);

			while(resultSet.next())
			{
				list.add(new ThirdPartyApplication(resultSet.getString("name"),resultSet.getString("email_id"),resultSet.getString("gender"),resultSet.getString("address"),resultSet.getInt("application_id"),resultSet.getInt("contact_no")));
			}

			return list;
		}catch(Exception e)
		{
			return null;
		}

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
	}

	public ArrayList<ThirdPartyApplication> thirdPartyViewAllApplication(String username)
	{
		ArrayList<ThirdPartyApplication> list = new ArrayList<ThirdPartyApplication>();
		try{
			int officerId;
			String queryForOfficerId = "select * from officers where username ='" +username+ "'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(queryForOfficerId);
			if(resultSet.next())
			{
				officerId=resultSet.getInt("officer_id");
			}
			else
			{
				return null;
			}
			String query = "select * from loan_officer_assign where officer_id="+officerId;
			Statement stat2 = currentCon.createStatement();
			ResultSet result = stat2.executeQuery(query);



			while(result.next())
			{
				list.add(new ThirdPartyApplication(resultSet.getString("comment"),resultSet.getString("status"),resultSet.getInt("application_id")));
			}

			return list;
		}catch(Exception e)
		{
			return null;
		}
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
	}

	public ArrayList<LoanOfficerApplication> loanOfficerViewApplication(String status)
	{
		ArrayList<LoanOfficerApplication> list = new ArrayList<LoanOfficerApplication>();
		try{


			String query = "select * from loan_application where status='"+status+"'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);

			while(resultSet.next())
			{
				list.add(new LoanOfficerApplication(resultSet.getInt("application_id"),resultSet.getInt("contact_no"),resultSet.getInt("age"),resultSet.getInt("office_contact_no"),resultSet.getString("fname"),resultSet.getString("email_id"),resultSet.getString("gender"),resultSet.getString("address"),resultSet.getString("pan_no"),resultSet.getString("company_name"),resultSet.getString("designation"),resultSet.getString("office_address"),resultSet.getString("office_email"),resultSet.getString("existing_loan"),resultSet.getString("photo"),resultSet.getString("address_document"),resultSet.getDouble("loan_amount"),resultSet.getInt("monthly_income")));
			}

			return list;

		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
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



	}

	public ArrayList<LoanOfficerApplication> loanOfficerViewAllApplication(String username)
	{
		ArrayList<LoanOfficerApplication> list = new ArrayList<LoanOfficerApplication>();
		try{
			int officerId;
			String queryForOfficerId = "select * from officers where username ='" +username+ "'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(queryForOfficerId);
			if(resultSet.next())
			{
				officerId=resultSet.getInt("officer_id");
			}
			else
			{
				return null;
			}
			String query = "select * from loan_officer_assign where officer_id="+officerId;
			Statement stat2 = currentCon.createStatement();
			ResultSet result = stat2.executeQuery(query);



			while(result.next())
			{
				list.add(new LoanOfficerApplication(resultSet.getInt("application_id"),resultSet.getString("comment"),resultSet.getString("status")));
			}


		}catch(Exception e)
		{
			return null;
		}
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


		return list;
	}

	public boolean updatedByLoanOfficer(String username,int applicationId,String comment)
	{	
		int officerId;
		try
		{
			currentCon = DBConnection.getConnection();
			String queryForOfficerId = "select * from officers where username ='" +username+ "'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(queryForOfficerId);
			if(resultSet.next())
			{
				officerId=resultSet.getInt("officer_id");
			}
			else
			{
				return false;
			}

			String changeStatus="update loan_application set status = 'loanInspector' where application_id="+applicationId;
			Statement stat2 = currentCon.createStatement();
			if(stat2.executeUpdate(changeStatus)!=0)
			{
				String loanOfficerstatus ="insert into loan_officer_assign values (" + applicationId + "," + officerId + "," + "'" + comment + "'," + " 'verified' )";
				Statement stat3 = currentCon.createStatement();
				if(stat3.executeUpdate(loanOfficerstatus)!=0)
				{
					return true;
				}
				else
				{
					return false;
				}


			}
			else
			{
				return false;
			}

		}catch(Exception e)
		{
			return false;
		}
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

	}


	public LoanOfficerApplication viewApplicationById(int id)
	{
		try
		{
			currentCon = DBConnection.getConnection();
			String query ="select * from loan_application where application_id="+id;
			Statement stat = currentCon.createStatement();
			ResultSet result= stat.executeQuery(query);
			if(result.next()){

				LoanOfficerApplication app = new LoanOfficerApplication(result.getInt("application_id"),result.getInt("contact_no"),result.getInt("age"),result.getInt("office_contact_no"),result.getString("fname"),result.getString("email_id"),result.getString("gender"),result.getString("address"),result.getString("pan_no"),result.getString("company_name"),result.getString("designation"),result.getString("office_address"),result.getString("office_email"),result.getString("existing_loan"),result.getString("photo"),result.getString("address_document"),result.getDouble("loan_amount"),result.getInt("monthly_income"));
				return app;
			}
			else
			{
				return null;
			}
		}catch(Exception e)
		{
			return null;
		}
	}

	public boolean updatedByLoanOfficer(int applicationId)
	{
		try
		{	String status;
		currentCon = DBConnection.getConnection();
		String queryForStatus = "select * from loan_app_or_rej where application_id ='" + applicationId ;
		currentCon = DBConnection.getConnection();
		Statement stat = currentCon.createStatement();
		ResultSet resultSet = stat.executeQuery(queryForStatus);
		if(resultSet.next())
		{
			status=resultSet.getString("status");
			String forwardToUser = "update loan_officer_assign set status ='"+ status + "' where application_id ="+ applicationId;
			Statement stat2 = currentCon.createStatement();
			if(stat2.executeUpdate(forwardToUser)!=0)
			{
				return true;
			}
			else
			{
				return false;
			}


		}
		else
		{
			return false;
		}

		}catch(Exception e)
		{
			return false;
		}
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
	}

	public int submitNewLoanApplication(NewLoanApplication loanapp){

		int row;

		try{
			currentCon = DBConnection.getConnection();
			String query = "insert into loan_application(APPLICATION_ID,EMAIL_ID,GENDER,DATE_OF_BIRTH,AGE,CONTACT_NO,ADDRESS,PAN_NO,LOAN_AMOUNT,MONTHLY_INCOME,COMPANY_NAME,DESIGNATION,OFFICE_ADDRESS,OFFICE_CONTACT_NO,OFFICE_EMAIL,EXISTING_LOAN,PHOTO,STATUS,REG_ID,ACCOUNTNO,SALUTATION,FNAME,MNAME,LNAME,RESIDENTIAL_OWNER,PLAN) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = currentCon.prepareStatement(query);

			pst.setLong(1,loanapp.getAppid());
			pst.setString(2,loanapp.getMail());
			
			pst.setString(3,loanapp.getGender()); 
			pst.setString(4,loanapp.getDate());
			pst.setLong(5,loanapp.getAge());
			pst.setLong(6,loanapp.getPcontact());
			pst.setString(7,loanapp.getPaddress());
			pst.setString(8,loanapp.getPan());
			pst.setLong(9,loanapp.getLoanamt());
			pst.setLong(10,loanapp.getMoninc());
			pst.setString(11,loanapp.getComp());
			pst.setString(12,loanapp.getDesg());
			pst.setString(13,loanapp.getOffaddress());
			pst.setLong(14,loanapp.getOffcontact());
			pst.setString(15,loanapp.getOffmail());
			pst.setString(16,loanapp.getExist_loan());
			pst.setString(17,loanapp.getFilePath());
		//	pst.setString(1,loanapp.getFilePath2());
			pst.setString(18,loanapp.getStatus());
			pst.setInt(19,loanapp.getRegno());
			pst.setLong(20,loanapp.getAccnum());
			pst.setString(21,loanapp.getSalutation());
			pst.setString(22,loanapp.getFname());
			pst.setString(23,loanapp.getMname());
			pst.setString(24,loanapp.getLname());
		
			pst.setString(25,loanapp.getRowner());
			pst.setString(26,loanapp.getPlan());
			System.out.println(loanapp.getAccnum());
			row = pst.executeUpdate();

			if(row!=0)
			{
				return row;
			}
			else
			{
				return 0;
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
			return 0;
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



	}



	public boolean updatedByThirdParty(String username,int applicationId,String comment,String status)
	{	
		int officerId;
		try
		{
			currentCon = DBConnection.getConnection();
			String queryForOfficerId = "select * from officers where username ='" +username+ "'";
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(queryForOfficerId);
			if(resultSet.next())
			{
				officerId=resultSet.getInt("officer_id");
			}
			else
			{
				return false;
			}


			String thirdPartystatus ="insert into loan_officer_assign values (" + applicationId + "," + officerId + "," + "'" + comment + "'," + "'" + status + "')";
			Statement stat3 = currentCon.createStatement();
			if(stat3.executeUpdate(thirdPartystatus)!=0)
			{
				return true;
			}
			else
			{
				return false;
			}

		}catch(Exception e)
		{
			return false;
		}
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

	}

	public int getUserIdFromApplicationId(int applicationId){

		try{
			String query = "SELECT REG_ID FROM LOAN_APPLICATION WHERE APPLICATION_ID="+applicationId;
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);
			int userId=0;

			while(resultSet.next()){
				userId = resultSet.getInt("REG_ID");
			}
			return userId;
		} catch (SQLException e) {
			System.out.println("Error in getting User Id from Application"+e.getMessage());
			return 0;
		}
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
	}

	public Application getLoanDEtailsFromApplicationId(int applicationId){
		try{
			String query = "SELECT * FROM LOAN_APPLICATION WHERE APPLICATION_ID="+applicationId;
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);
			Application app = new Application();

			while(resultSet.next()){
				System.out.println("line 593 database access: "+resultSet.getInt("loan_amount"));
				app.setLoan_amount(resultSet.getInt("LOAN_AMOUNT"));
				String plan=resultSet.getString("PLAN");
				String[] emi_plan = plan.split(" ");
				app.setInterest_rate(Double.parseDouble(emi_plan[0])); // extract the data 
				app.setDuration_in_months(Integer.parseInt(emi_plan[1]));
				app.setMonthly_income(resultSet.getDouble("MONTHLY_INCOME"));
			}
			return app;
		}

		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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

	}



	public double getExistingEMI(int regID){
		try{
			String query = "SELECT *FROM LOAN_APP_OR_REJ WHERE APPLICATION_ID IN (SELECT APPLICATION_ID FROM LOAN_APPLICATION WHERE REG_ID="+regID +") AND STATUS='Accepted'";
			ResultSet resultSet = DBConnection.getResultSet(query);
			double emi=0.0;
			//boolean existing_emi;

			while(resultSet.next()){
				emi+= resultSet.getDouble("INTEREST_RATE");
			}
			
			return emi;
		}

		catch (SQLException e) {
			return 0.0;
		}
		

	}


	public ArrayList<Integer> getApplicationIdForLoanInspector(){

		String query = "SELECT APPLICATION_ID FROM LOAN_APPLICATION WHERE STATUS ='loanInspector'";
		try
		{
			currentCon = DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);

			ArrayList<Integer> applications = new ArrayList<Integer>();

			while(resultSet.next()){
				applications.add(resultSet.getInt("APPLICATION_ID"));
			}

			return applications;
		} catch (SQLException e) {
			return null;
		}
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

	}

	public ArrayList<Tracking> getApplicationDetails(int regID){
		String query = "SELECT * FROM LOAN_APPLICATION WHERE REG_ID="+regID;
		try{
			currentCon =  DBConnection.getConnection();
			Statement stat = currentCon.createStatement();
			ResultSet resultSet = stat.executeQuery(query);
			Tracking track;
			ArrayList<Tracking> applicationList =new ArrayList<Tracking>();

			while(resultSet.next()){
				track=new Tracking();
				track.setAppID(resultSet.getInt("APPLICATION_ID"));
				//track.setApplied_date(resultSet.getTimestamp("APPLIED_DATE"));
				track.setStatus(resultSet.getString("STATUS"));
				applicationList.add(track);
			}	
			return applicationList;
		}

		catch (SQLException e) {
			return null;

		}

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

	}

	
	public ArrayList<Message> viewMessages(int regID){
		int regId=regID;
		try{
		String query = "SELECT LA.APPLICATION_ID,LAR.LOAN_ID,LAR.APPROVAL_DATE,LAR.AMOUNT_SANCTIONED,LAR.INTEREST_RATE,LAR.EMI_ASSIGNED,LAR.REASON,LAR.STATUS,LAR.LOAN_DURATION FROM LOAN_APP_OR_REJ LAR JOIN LOAN_APPLICATION LA ON LAR.APPLICATION_ID=LA.APPLICATION_ID WHERE LAR.STATUS='accepted' AND LA.REG_ID ="+regId;
		currentCon =  DBConnection.getConnection();
		Statement stat = currentCon.createStatement();
		ResultSet resultSet = stat.executeQuery(query);
		Message m;
		ArrayList<Message> messageList =new ArrayList<Message>();
		
			while(resultSet.next()){
				m=new Message();
			    m.setApp_id(resultSet.getInt(1));
			    m.setLoan_id(resultSet.getInt(2));
			    m.setApproval_date(resultSet.getDate(3));
			    m.setAmount_sanctioned(resultSet.getFloat(4));
			    m.setInterest_rate(resultSet.getFloat(5));
			    m.setEmi_assigned(resultSet.getFloat(6));
			    m.setReason(resultSet.getString(7));
			    m.setStatus(resultSet.getString(8));
			    m.setLoan_duration(resultSet.getInt(9));
			    messageList.add(m);
				
			}
			return messageList;
		}catch (SQLException e) {
			return null;
		}
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

		
	}
	
	
	public int submitCheque(Pdc p){
	    Pdc p1=p;
		int row=0;// no insertion	
		try{
		currentCon = DBConnection.getConnection();
	    String query = "insert into loan_application(CHEQUE) values (?)";
	    PreparedStatement pst = currentCon.prepareStatement(query);
		pst.setString(1,p1.getFilePath4());
		row = pst.executeUpdate();
		return row;
		}
		catch (Exception ex) 
		{
			return 0;
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
		
	}

	public ArrayList<Applications> getApplicationIdcm(String status) {
		ArrayList<Applications> applist = new ArrayList<Applications>();
		try
		{
			currentCon = new DBConnection().getConnection();
			String query = "SELECT application_id,loan_amount,fname,lname,salutation FROM loan_application WHERE status = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, status);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				
				int i=1;
				Applications app = new Applications();
				app.application_id = rs.getString(i++);
				app.loan_amount = rs.getString(i++);
				app.fname = rs.getString(i++);
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
			
			int i=1;
			while (rs.next())
			{
				app.application_id = rs.getString(i++);
				app.fname = rs.getString(i++);
				app.mname = rs.getString(i++);
				app.lname = rs.getString(i++);
				app.email_id = rs.getString(i++);
				app.gender = rs.getString(i++);
				app.date_of_birth = rs.getDate(i++);
				app.age = rs.getString(i++);
				app.contact_no = rs.getString(i++);
				app.address = rs.getString(i++);
				app.pan_no = rs.getString(i++);
				app.loan_amount = rs.getString(i++);
				app.monthly_income = rs.getString(i++);
				app.company_name = rs.getString(i++);
				app.designation = rs.getString(i++);
				app.office_address = rs.getString(i++);
				app.office_contact_no = rs.getString(i++);
				app.office_email = rs.getString(i++);
				app.existing_loan = rs.getString(i++);
				app.photo = rs.getString(i++);
				i++; //fetching document address but sending to jsp
				i++; //fetching status but not sending to jsp
				app.reg_id = rs.getString(i++);
				i++; //for identity document
				app.account_no = rs.getString(i++);
				app.salutation = rs.getString(i++);
				app.residential_owner = rs.getString(i++);
				app.plan = rs.getString(i++);
				
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
	
	public int submitRegistration(Registration reg){
		int row;
		String query = "insert into registration(fname,mname,lname,contact_no,gender,date_of_birth,email_id,address,username,password,question,answer) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				//+reg.getfName()+"','"+reg.getmName()+"','"+reg.getlName()+"','"+reg.getEmail()+"','"+reg.getAddress()+"','"+reg.getUsername()+"','"+reg.getPassword()+"','"+reg.getGender()+"','"+reg.getQuestion()+"','"+reg.getAnswer()+"','"+reg.getContact()+"','"+reg.getDob()+"')";
		PreparedStatement pst;
		try {
			currentCon = DBConnection.getConnection();
			pst = currentCon.prepareStatement(query);
			pst.setString(1,reg.getfName());
			pst.setString(2,reg.getmName());
			pst.setString(3,reg.getlName());
			pst.setLong(4,reg.getContact());
			pst.setString(5,reg.getGender()); 
			pst.setString(6,reg.getDob());
			pst.setString(7,reg.getEmail());
			pst.setString(8,reg.getAddress());
			pst.setString(9,reg.getUsername());
			pst.setString(10,reg.getPassword());
			pst.setString(11,reg.getQuestion());
			pst.setString(12,reg.getAnswer());
			row = pst.executeUpdate();
			System.out.println(row);
			if(row!=0)
			{
				return row;
			}
			else
			{
				return 0;
			}
		}
		catch (Exception ex) 
		{	
			ex.printStackTrace();
			return 0;
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
	}
	
	public static int checkpassword(String username,String password)
	 {
		  String query = null;
		  
		  if(username.startsWith("k")|username.startsWith("K"))
			 query = "select password from officers where username='"+username+"'";
		  else
			 query = "select password from registration where username='"+username+"'";
		 
		if(!DBConnection.getResultStatus(query))
			return 2;
		else
		{
		ResultSet result =  DBConnection.getResultSet(query);
	     try {
			if(result.next())
			{
				String pwd = result.getString("password");
				if(pwd.equals(password))
				{
					return 1;
				}
				else
					return 0;
			}
	     }
			catch (SQLException e) {
				// TODO Auto-generated catch block
			return 0;
			}
	     finally
	     {
	    	 try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return 0;
			}
	     }
	 }
		return 0;
		
	}
	  public static String getOfficerId(String username) throws SQLException
	  {
		  String query = "select officer_id from officers where username='"+username+"'";
		  ResultSet result = DBConnection.getResultSet(query);
		  if(result.next())
		  return result.getString("officer_id");
		  else
			  return null;
	  }
	  public static String getQuestion(String username)
	  {
		  String query = "select question from registration where username='"+username+"'";
		  if(!DBConnection.getResultStatus(query))
			{
			  return null;
			}
		    ResultSet result = DBConnection.getResultSet(query);
			String question = null;
			try {
				if(result.next())
				{
					question = result.getString(1);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
				return question;
	  }
	  
	  public static int UpdatePassword(String username,String password)
	  {
		  String query = "update registration set password ='"+password+"' where username='"+username+"'";
		  if(DBConnection.getResultStatus(query))
		  {
			  query = "commit";
			  DBConnection.getResultStatus(query);
			  return 1;
		  }
		  else
			  return 0;
	  }
	  public static String getAnswer(String username) throws SQLException
	  {
		  String query = "select answer from registration where username ='"+username+"'";
		  if(!DBConnection.getResultStatus(query))
			  return null;
		  ResultSet result = DBConnection.getResultSet(query);
		  if(result.next())
			  return result.getString("answer");
		  else
			  return null;
				  
	  }


	
	public Officers getOfficerDetails(String id) {

		Officers  officers = null;
		try
		{
			currentCon =  DBConnection.getConnection();
			String query = "SELECT * from officers where officer_id = ?";
			PreparedStatement pst = currentCon.prepareStatement(query);
			pst.setString(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				int i=1;
				officers = new Officers();
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
