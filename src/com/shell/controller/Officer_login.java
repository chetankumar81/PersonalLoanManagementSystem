package com.shell.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.control;
import com.shell.modular.dao.DatabaseAccess;

public class Officer_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String username = request.getParameter("usr");
		String password = request.getParameter("pwd");
		if((control.checkp(username, password)) == 1)	
		{

			session = request.getSession(false);
			if (session==null)
				session= request.getSession(true);
			session.setAttribute("username",username);
			try {
				session.setAttribute("officer_id", DatabaseAccess.getOfficerId(username));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setMaxInactiveInterval(600*200*20);
			response.sendRedirect("viewer/LoanOfficerView.jsp");
		}
		else{
			response.sendRedirect("viewer/Officer_login.html");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
