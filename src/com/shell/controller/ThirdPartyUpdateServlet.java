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


public class ThirdPartyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ThirdPartyUpdateServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		try{
			String username = (String)session.getAttribute("username");
			if(username==null)
			{
				out.println("<script>alert('please login');window.location.href='viewer/thirdPartyLogin.html'</script>");
				
			}

			else{
					String comment = request.getParameter("comment");
					int applicationId = Integer.parseInt(request.getParameter("applicationId"));
					String status = request.getParameter("ThirdPartyStatus");
					if(ThirdPartyServices.updateStatusOfApplication(username,applicationId,comment,status))
					{
						out.print("<script>alert('operation is successful');window.location.href='viewer/ThirdPartyView.jsp';</script>");
						
						
					}
					else
					{
						out.print("<script>alert('error occurred');window.location.href='viewer/ThirdPartyView.jsp';</script>");
						
					}


			}
		}catch(Exception e)
		{
			out.println("<script>alert('please login');window.location.href='viewer/thirdPartyLogin.html';</script>");
			
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
