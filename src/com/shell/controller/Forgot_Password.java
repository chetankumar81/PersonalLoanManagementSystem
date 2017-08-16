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
import com.shell.util.DBConnection;



/**
 * Servlet implementation class Forgot_Password
 */
public class Forgot_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forgot_Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid = request.getParameter("usr");
		PrintWriter out = response.getWriter();
		if(control.getQuestion(userid)==null)
		{
			out.println("<script>alert('username does not exist');window.location.href='viewer/Forgot_Password.html';</script>");
		}
		else
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", userid);
			session.setAttribute("question", control.getQuestion(userid));
			response.sendRedirect("viewer/Forgot_Password.jsp");
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
