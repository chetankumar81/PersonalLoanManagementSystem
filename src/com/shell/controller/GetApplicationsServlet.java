package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.GetApplication;

public class GetApplicationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetApplicationsServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);


		try
		{
			String roleId = (String) session.getAttribute("username"); 
			if(roleId!=null)
			{
				ArrayList<Integer> applications = new ArrayList<Integer>();
				applications = GetApplication.getApplicationIdForLoanInspector();
				if(applications==null)
				{	
					out.println("<script>alert('error occurred');window.location.href='/GetApplicationsServlet';</script>");
					
				}
				else if(applications.size()==0)
				{
					out.println("No new applications");
				}
				else{
					request.setAttribute("applications", applications);
					RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/LoanInspector.jsp");
					dispatcher.forward(request, response);
				}
			}
			else
			{
				out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			}

		}catch(Exception e)
		{
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
