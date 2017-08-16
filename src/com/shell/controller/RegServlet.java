package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.business.NewRegistration;
import com.shell.modular.business.Registration;
import com.shell.modular.dao.DatabaseAccess;


public class  RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String fName = request.getParameter("fName");
		String mName = request.getParameter("mName");
		String lName = request.getParameter("lName");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
		Date dob;
		try {
			dob = formatter1.parse(request.getParameter("dob"));
	

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		Registration reg = new Registration(fName,mName,lName,email,address,username,password,gender,question,answer,contact,dob);
		NewRegistration.forwardToRegTable(reg);
		}
		catch(Exception e)
		{
			out.println("<script>alert('date format error');window.history.back();</script>");
		}
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}