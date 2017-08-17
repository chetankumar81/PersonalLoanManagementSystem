package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.dao.DatabaseAccess;

/**
 * Servlet implementation class UpdateLoanInspector
 */
public class UpdateLoanInspector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLoanInspector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		System.out.println("---------------Inside do GET method................................................");
		String officer_id = (String)request.getParameter("officerId");
		
		String temp = request.getParameter("appid");
		System.out.println("val"+temp+"ok");
		int app_id = Integer.parseInt(request.getParameter("appid"));
		String risk =(String)request.getParameter("risk");
		String comment =(String)request.getParameter("comments");
		boolean result = new DatabaseAccess().updatedByLoanInspector(officer_id, app_id, risk, comment);
		RequestDispatcher dispatcher;
		System.out.println("Executing 45 f UpdateLoanInspector");
		System.out.println(result);
		PrintWriter out= response.getWriter();
		if(result){
			//System.out.println("Executing 47 of UpdateLoanInspector");
			out.println("<script>alert('Forwarded sucessfully!!');window.location.href='GetApplicationsServlet';</script>");
			//dispatcher=request.getRequestDispatcher("viewer/verified.html");
			//dispatcher.forward(request, response);
		}
		else{
			out.println("<script>alert('Forwarding Failed!!');window.location.href='GetApplicationsServlet';</script>");
			//dispatcher=request.getRequestDispatcher("viewer/not_verified.html");
			//dispatcher.forward(request, response);
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
