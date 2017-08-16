package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.GetExistingLoan;

public class GetExistingLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		System.out.println("Before try");

		try{
			System.out.println("try executed");

			//String username = (String) session.getAttribute("username");
			String username="Apurva";
			if(username==null)
			{
				System.out.println("In do get if part");

				out.println("<script>alert('login again')</script>");
				response.sendRedirect("viewer/index.html");	
			}
			else{

					System.out.println("In do get else part");
				int appId= Integer.parseInt(request.getParameter("appId"));
				//System.out.println("hello");
				//out.println(appId);
				System.out.println(appId);
				//out.println(appId);
				GetExistingLoan obj = GetExistingLoan.Details(appId);
				if(obj==null)
				{
					System.out.println("Inside if of else");
					System.out.println("hello");
					System.out.println(appId);
					out.println("<script>alert('Error occurred');window.history.back();</script>");
					
				}
				else{
					System.out.println("inside else of else");
				request.setAttribute("appId", appId);
				request.setAttribute("application", obj.getApp());
				request.setAttribute("emi", obj.getEmi());
				request.setAttribute("risk",obj.getRisk());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/RCUvalidationResult.jsp");
				dispatcher.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			out.println("<script>alert('login again')</script>");
			response.sendRedirect("viewer/index.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
