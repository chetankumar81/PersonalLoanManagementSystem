package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.dao.DatabaseAccess;


public class SubmitLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username= (String)request.getSession().getAttribute("username");
		String flag = request.getParameter("flag");
		String amount = request.getParameter("amount");
		String emi = request.getParameter("emi");
		String appid = request.getParameter("appid");
		String status;
		if(flag.equals("1")){
			status = "Accepted";
			
		}
		else{
			status="Rejected";
		}
		boolean res= new DatabaseAccess().updatedByCreditManager(username, appid, status,amount,emi);
		if(res){
			if(flag.equals("1"))
			out.println("<script>alert('Approved');window.location.href='viewer/credithome.jsp'</script>");
			else
			out.println("<script>alert('Rejected');window.location.href='viewer/credithome.jsp'</script>");
			
		}
		else{
			out.println("<script>alert('Not Approved');window.location.href='home.jsp'</script>");
		}
		//System.out.println(flag +" "+amount+ " "+emi+ " "+appid);
		
		
	}

}
