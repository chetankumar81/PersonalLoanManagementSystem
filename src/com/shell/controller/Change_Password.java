package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.business.control;



/**
 * Servlet implementation class Change_Password
 */
public class Change_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change_Password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	   String username = request.getParameter("user");
	   String pwd     = request.getParameter("pwd");
	   String cpwd    = request.getParameter("cpwd");
	   PrintWriter out = response.getWriter();
	   if(control.UpdatePassword(username, pwd)==1)
		   {
			  response.sendRedirect("viewer/login1.html");
		   }
		   else
			   out.println("<script>alert('Password has not  been Updated');window.location.href='viewer/login1.html';");
		      
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
