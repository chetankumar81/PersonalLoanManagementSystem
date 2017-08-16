package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.ThirdPartyServices;


@WebServlet("/PartyLoginServlet")
public class PartyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PartyLoginServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		
		if(ThirdPartyServices.validation(username, password))
		{ 
			//success
			HttpSession session = request.getSession();
			session.setAttribute("PartyUsername",username); 
			request.getRequestDispatcher("viewer/ThirdPartyView.jsp").forward(request, response);
			
			
		}
		else
		{
			
			// authentication failed
			out.println("<script>alert('invalid credentials') ; window.history.back();</script>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
