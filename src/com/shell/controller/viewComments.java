package com.shell.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shell.modular.business.Comments;
import com.shell.modular.dao.DatabaseAccess;

public class viewComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String appid = request.getParameter("appid");
		System.out.println(appid);
		ArrayList<Comments> commlist = new DatabaseAccess().getCommentsCM(appid);
		//String json = new Gson().toJson(commlist);
		//System.out.println(json);
		request.setAttribute("commlist", commlist);
		getServletContext().getRequestDispatcher("/viewer/viewCommentsCM.jsp").forward(request, response);
	}

}
