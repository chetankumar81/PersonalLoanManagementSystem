<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Track Application</title>
<%@page import="java.util.ArrayList,com.shell.modular.business.Tracking" %>
</head>
<body>
<%
	
	ArrayList<Tracking> applicationList =(ArrayList) request.getAttribute("appList");
	
%>
<table name="applicationTable" id="appTable">
	<tr>
    <th>APPLICATION_ID</th>
    <th>TIMESTAMP</th>
    <th>STATUS</th>
  </tr>
  <% for(Tracking track:applicationList){
	  out.println("<tr><td>"+track.getAppID()+"</td><td>"+track.getApplied_date()+"</td><td>"+track.getStatus()+"</td>");
  }%>
  
</table>
</body>
</html>