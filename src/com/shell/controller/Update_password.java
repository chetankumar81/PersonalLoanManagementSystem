package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.control;


/**
 * Servlet implementation class Update_password
 */
public class Update_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String username = (String)request.getParameter("user");
	    String question = (String)request.getParameter("usr");
	    String answer = (String)request.getParameter("ans");
	    PrintWriter out = response.getWriter();
	    String ans = null;
		 ans = control.getAnswer(username);
		 if(ans.equals(null))
	      {
	    	  out.println("<script>alert('username does not exist')</script>");
	    	  response.sendRedirect("viewer/Forgot_Password.html");
	      }
		 else
	     {
	         if(ans.equals(answer))
				  {
					    request.setAttribute("userid", username);
					    RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/update_password.jsp");
						dispatcher.include(request,response);	  
					}
				  else
				  {
					  response.sendRedirect("viewer/Forgot_Password.html");
				  }
			  
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
