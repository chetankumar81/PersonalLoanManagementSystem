package com.shell.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.shell.modular.business.Photo;
import com.shell.modular.business.PhotoServices;

/**
 * Servlet implementation class UploadPhoto
 */

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="photoss";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		try{
		String username = (String) session.getAttribute("username");
		
		System.out.println(username);
			if (username == null) {
				out.println("<script>alert('please login');window.location.href='viewer/login.jsp';</script>");
			}
			else{

				String savePath4 = "C:" + File.separator + SAVE_DIR;

				File fileSaveDir4=new File(savePath4);
				if(!fileSaveDir4.exists()){
					fileSaveDir4.mkdir();
				}
				String fileName4=null;
				Part part4 = request.getPart("photo"); 
				fileName4 = extractFileName(part4);


				Photo p=new Photo(fileName4);
                System.out.println(fileName4);
				if(PhotoServices.forwardToappTable(p)==0)
				{
					out.println("<script>alert('upload operation unsuccessful,try again'); window.history.back();</script>");
					
				}
				else
				{
					out.println("<script>alert('upload was successful');window.location.href='viewer/CustomerDashboard.jsp';</script>");
					
				}
			}
		
	}catch(Exception e)
	{
		out.println("<script>alert('please login');window.location.href='viewer/login.jsp';</script>");

	}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String extractFileName(Part part4) {
		String contentDisp = part4.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}

}
