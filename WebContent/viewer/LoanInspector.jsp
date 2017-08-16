<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Inspector</title>
<%@page import="java.util.ArrayList" %>
</head>
<body>
	<%
	
		String username =(String) session.getAttribute("username");
		if(username==null)
		{
			out.println("<script>alert('please login');window.location.href='index.html';</script>");
			
		}
		else{
			
		ArrayList<Integer> applications = (ArrayList<Integer>)request.getAttribute("applications");
		
		//displaying the applications in grid format
		
		for(Integer app:applications){%>
			<form action="../GetExistingLoanServlet" method="get">
				<input type="hidden" name="appId" value="<%=app %>"/>
				<h2> <%= app %></h2>
				<input type="submit" value="validate risk"/>
			</form>
			
	
		<% }
		}
	%>
	
</body>
</html>