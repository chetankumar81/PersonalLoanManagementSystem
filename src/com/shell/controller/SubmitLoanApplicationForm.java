package com.shell.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import com.shell.modular.business.NewLoanApplication;
import com.shell.modular.business.NewLoanApplicationServices;

//@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)


@WebServlet("/SubmitLoanApplicationForm")
public class SubmitLoanApplicationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="images";
	private static final String SAVE_DIR2="addresses";
	private static final String SAVE_DIR3="identities";


	public SubmitLoanApplicationForm() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("CustomerUsername");
		
		if(username!=null)
		{

			int appid = Integer.parseInt(request.getParameter("appnum"));
			Long accnum = Long.parseLong(request.getParameter("account"));
			String salutation = request.getParameter("salutation");
			String fname = request.getParameter("fname");
			String mname = request.getParameter("mname");
			String lname = request.getParameter("lname");
			String pan = request.getParameter("pan");
			String mail = request.getParameter("email");
			String gender = request.getParameter("gender");
			String date=request.getParameter("dob");
			int age = Integer.parseInt(request.getParameter("age"));
			Long pcontact = Long.parseLong(request.getParameter("pcontact"));
			String paddress = request.getParameter("paddress");
			String rowner = request.getParameter("residential_owner");
			String emptype = request.getParameter("emptype");
			String comp = request.getParameter("compname");
			String desg = request.getParameter("desgn");
			String plan = request.getParameter("Plan");
			String offaddress = request.getParameter("office_address");
			Long offcontact = Long.parseLong(request.getParameter("office_contact"));
			String offmail = request.getParameter("office_email");
			Long loanamt = Long.parseLong(request.getParameter("loan_amount"));
			Long moninc = Long.parseLong(request.getParameter("mon_inc"));
			String exist_loan = request.getParameter("exist_loan");
			String savePath = "C:" + File.separator + SAVE_DIR;
			String savePath2 = "C:" + File.separator + SAVE_DIR2;
			String savePath3 = "C:" + File.separator + SAVE_DIR3;
			
			File fileSaveDir=new File(savePath);
			
			if(!fileSaveDir.exists()){
				fileSaveDir.mkdir();
			}
			
			File fileSaveDir2=new File(savePath2);
			if(!fileSaveDir2.exists()){
				fileSaveDir2.mkdir();
			}
			
			File fileSaveDir3=new File(savePath);
			if(!fileSaveDir3.exists()){
				fileSaveDir3.mkdir();
			}

			String fileName=null;
			String fileName2=null;
			String fileName3=null;
			Part part = request.getPart("photo"); 
			fileName = extractFileName(part);
			Part part2=request.getPart("paddress");
			fileName2=extractFileName2(part2);
			Part part3 = request.getPart("pid"); 
			fileName3 = extractFileName(part3);
			File f=new File(fileName);
			File f2=new File(fileName2);
			File f3=new File(fileName3);
			part.write(savePath + File.separator + f.getName());
			part2.write(savePath2 + File.separator + f2.getName());
			part3.write(savePath3 + File.separator + f3.getName());
			String filePath=savePath+File.separator + f.getName();
			String filePath2=savePath2+File.separator + f2.getName();
			//check savepath
			String filePath3=savePath3+File.separator+f3.getName();
			//session work
			int regno=(int) session.getAttribute("username");
			//check this while integration
			String status="pending";
			NewLoanApplication loanapp=new NewLoanApplication(appid,age,regno,accnum,
					pcontact,offcontact,loanamt,moninc,
					salutation,fname,mname,lname,
					pan,mail,gender,date,
					paddress,rowner,emptype,comp,
					desg,offaddress,offmail,exist_loan,
					filePath,filePath2,filePath3,status,plan);
			
			// invoking the service the inserts the data .
			
			if(NewLoanApplicationServices.forwardToAppTable(loanapp) != 0)
			{
				out.println("<script>alert('successfully applied');window.location.href='viewer/CustomerDashboard.jsp'</script>");
				
			}
			
			else
			{
				out.println("<script>alert('successfully applied'); window.history.back();</script>");
				
			}
		}
		
		else
		{
			out.println("<script>alert('please login');window.location.href='viewer/index.html'</script>");
			
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
	
	private String extractFileName2(Part part2) {
		String contentDisp = part2.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}
}
