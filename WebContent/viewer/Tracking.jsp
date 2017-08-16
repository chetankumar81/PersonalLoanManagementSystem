<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Track Application</title>
<%@page import="java.util.ArrayList,com.shell.modular.business.Tracking"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/1-col-portfolio.css" rel="stylesheet">
</head>
<body>
	<%
		ArrayList<Tracking> applicationList = (ArrayList) request.getAttribute("appList");
	%>
	<div class="container">
		<table name="applicationTable" id="appTable" class="table table-bordered">
			<tr>
				<th>APPLICATION_ID</th>

				<th>STATUS</th>
			</tr>
			<%
				for (Tracking track : applicationList) {
					out.println("<tr><td>" + track.getAppID() + "</td><td>" + track.getStatus() + "</td>");
				}
			%>

		</table>
	</div>
</body>
</html>