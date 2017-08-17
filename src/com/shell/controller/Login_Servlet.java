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
import javax.swing.JOptionPane;

import com.shell.modular.business.control;
import com.shell.modular.dao.DatabaseAccess;




/**
 * Servlet implementation class Login_Servlet
 */
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("usr");
		String password = request.getParameter("pwd");
//		System.out.println(username+""+password);
//		String query = "select password from registration where username = '"+username+"'";
//		
////				System.out.println(query);
//		if(!DBConnection.getResultStatus(query))
//		{
////			JOptionPane.showMessageDialog(null, "thank you for using java");
//			
////			out.println("<script type=\"text/javascript\">alert(\"username doesn't exist\");</script>");
//			response.sendRedirect("viewer/login.jsp");
//			
//		}
//		else
//		{
//		ResultSet result =  DBConnection.getResultSet(query);
//
//		try {
//			if(result.next())
//			{
//
//				String pwd = result.getString("password");
//				if(pwd.equals(password))
//				{
//					HttpSession session = request.getSession(true);
//					session.setAttribute("userid",username);
//					session.setMaxInactiveInterval(60);
//					
//			        response.sendRedirect("SessionDemo");
//			        }
//				else
//				{
////					JOptionPane.showMessageDialog(null, "thank you for using java");
//					response.sendRedirect("login1.html");
//				}
//			}
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendRedirect("login1.html");
//		}
		
		if(control.checkp(username, password)==1)	
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("username",username);
			try {
				session.setAttribute("userid", DatabaseAccess.getregId(username));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//session.setMaxInactiveInterval(60);
			System.out.println(session.getAttribute("userid"));
	        response.sendRedirect("viewer/CustomerDashboard.jsp");
		}
		else if((control.checkp(username, password)) == 2)
		{
			response.sendRedirect("viewer/login.jsp");
		}
		else
			response.sendRedirect("viewer/home.jsp");
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
