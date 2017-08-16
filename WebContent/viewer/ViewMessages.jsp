<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Messages</title>
<%@page import="java.util.ArrayList,com.shell.modular.business.Message"%>
</head>
<body>
	<%
	String username = (String) session.getAttribute("username");
     if(username == null)
     {
    	 out.println("<script>alert('please login');window.location.href='index.html';</script>");
			
     }
     else
     {
	ArrayList<Message> messageList =(ArrayList)request.getAttribute("messageList");
	
	%>
	<table name="messageTable" id="messageTable">
		<tr>
			<th>APPLICATION ID</th>
			<th>LOAN ID</th>
			<th>APPROVAL DATE</th>
			<th>LOAN AMOUNT SANCTIONED</th>
			<th>INTEREST RATE</th>
			<th>EMI ASSIGNED</th>
			<th>REASON</th>
			<th>STATUS</th>
			<th>LOAN DURATION</th>
		</tr>
		<% for(Message m:messageList){
	  out.println("<tr><form action=UploadPdc method=post><td>"+m.getApp_id()+"</td><td>"+m.getLoan_id()+"</td><td>"+m.getApproval_date()+"</td><td>"+m.getAmount_sanctioned()+"</td><td>"+m.getInterest_rate()+"</td><td>"+m.getEmi_assigned()+"</td><td>"+m.getLoan_duration()+"</td><td>"+m.getReason()+"</td><td>"+m.getStatus()+"</td><td><input type=\"file\" name=\"pdc\"><input type=\"submit\" name=\"submit\" value=\"Upload PDC\"></td></form></tr>");
  }
  }%>

	</table>
</body>
</html>