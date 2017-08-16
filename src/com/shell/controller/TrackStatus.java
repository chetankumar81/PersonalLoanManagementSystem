package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.TrackApplication;
import com.shell.modular.business.Tracking;


public class TrackStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TrackStatus() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		try{

			int regId = (Integer)session.getAttribute("CustomerUsername");//Integer.parseInt(request.getParameter("uname"));

			TrackApplication track1 = new TrackApplication();
			track1.trackLoan(regId);

			ArrayList<Tracking> applicationList =new ArrayList<Tracking>();
			applicationList = track1.getApplications();
			
			if(applicationList == null)
			{
				out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
				
			}
			else if(applicationList.size()==0)
			{
				out.println("no application to track");
			}
			else
			{
				request.setAttribute("appList", applicationList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/tracking.jsp");
				dispatcher.forward(request, response);

			}

		}

		catch(Exception e)
		{
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
