package com.shell.modular.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shell.modular.dao.DatabaseAccess;

import com.google.gson.Gson;

public class GetApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Applications> applist = new DatabaseAccess().getApplicationIdcm("credit manager");
		String json = new Gson().toJson(applist);
		//System.out.println(json);
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
