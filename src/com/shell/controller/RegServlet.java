package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shell.modular.business.*;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String fName = request.getParameter("fname");
		String mName = request.getParameter("mname");
		String lName = request.getParameter("lname");
		long contact = Long.parseLong(request.getParameter("contact"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		//
		String dob=request.getParameter("dob");
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		Registration reg = new Registration(fName,mName,lName,email,address,username,password,gender,question,answer,contact,dob);
		
		if(NewRegistration.forwardToRegTable(reg)==0)
		{
			out.println("<script>alert('Error'))</script>");
			response.sendRedirect(request.getHeader("Referer"));
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/home.jsp");
			dispatcher.forward(request, response);
			
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
