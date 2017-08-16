package com.shell.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shell.modular.business.Message;
import com.shell.modular.business.MessageFetch;


@WebServlet("/ViewMessages")
public class ViewMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewMessages() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		try{

			int regId = (Integer)session.getAttribute("username");
			MessageFetch m = new MessageFetch();
			ArrayList<Message> messageList=m.fetchMessages(regId);

			if(messageList==null)
			{
				out.println("<script>alert('error occurred');window.location.href='viewer/CustomerDashboard.jsp';</script>");
				
			}

			else if(messageList.size()==0)
			{
				out.println("<script>alert('no new messages to show');window.location.href='viewer/CustomerDashboard.jsp';</script>");
				
			}

			else
			{
				request.setAttribute("messageList", messageList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewer/ViewMessages.jsp");
				dispatcher.forward(request, response);
			}
		}
		catch(Exception e)
		{
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
