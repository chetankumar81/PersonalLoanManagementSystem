package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.Application;
import com.shell.modular.business.CalculateRisk;
import com.shell.modular.business.GetExistingLoan;
import com.shell.modular.dao.DatabaseAccess;

public class GetExistingLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public GetExistingLoanServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		try{
			String username = (String) session.getAttribute("username");
			if(username==null)
			{
				out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			}
			else{


				int appId= Integer.parseInt(request.getParameter("appId"));
				
				GetExistingLoan obj = GetExistingLoan.Details(appId);
				if(obj==null)
				{
					out.println("<script>alert('Error occurred');window.history.back();</script>");
					
				}
				else{
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
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
