package com.shell.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shell.modular.business.Pdc;
import com.shell.modular.business.PdcUploadServices;


@WebServlet("/UploadPdc")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)

public class UploadPdc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR4="postdatecheques";

	public UploadPdc() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		try
		{
			String username = (String) session.getAttribute("username");
			if (username == null) {
				out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");
			}
			else{

				String savePath4 = "C:" + File.separator + SAVE_DIR4;

				File fileSaveDir4=new File(savePath4);
				if(!fileSaveDir4.exists()){
					fileSaveDir4.mkdir();
				}
				String fileName4=null;
				Part part4 = request.getPart(""); 
				fileName4 = extractFileName(part4);


				Pdc p=new Pdc(fileName4);

				if(PdcUploadServices.forwardToappTable(p)==0)
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
			out.println("<script>alert('please login');window.location.href='viewer/index.html';</script>");

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
