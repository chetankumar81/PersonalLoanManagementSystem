package com.shell.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.business.Applications;
import com.shell.modular.dao.DatabaseAccess;

public class viewApplicationCM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appid = request.getParameter("appid");
		Applications app = new DatabaseAccess().viewApplicationCM(appid);
		//String obj = new Gson().toJson(app);
		request.setAttribute("app", app);

		getServletContext().getRequestDispatcher("/viewer/viewApplicationCM.jsp").forward(request, response);
	}

}
