package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.LoanOfficerServices;

@WebServlet("/LoanOfficerUpdateServlet")
public class LoanOfficerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoanOfficerUpdateServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		try{
			String username = (String)session.getAttribute("LoanOfficerUsername");
			if(username==null)
			{
				out.println("<script>alert('please login');window.location.href='viewer/index.html'</script>");
				
			}

			else{
					String comment = request.getParameter("comment");
					int applicationId = Integer.parseInt(request.getParameter("applicationId"));
					
					if(LoanOfficerServices.forwardToInspector(username,applicationId,comment))
					{
						out.print("<script>alert('forwarded successfully');window.location.href='viewer/LoanOfficerView.jsp'</script>");
						
						
					}
					else
					{
						out.print("<script>alert('error occurred');window.location.href='viewer/LoanOfficerView.jsp';</script>");
						
					}


			}
		}catch(Exception e)
		{
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			
		}


		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
