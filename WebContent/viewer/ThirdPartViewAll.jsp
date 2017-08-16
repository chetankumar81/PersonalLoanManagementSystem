
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.ThirdPartyServices"%>
<%@ page import="com.shell.modular.business.ThirdPartyApplication"%>
<%@ page import="java.util.ArrayList;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Third Party View All Applications</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/1-col-portfolio.css" rel="stylesheet">
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="#">Third Party Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="ThirdPartyView.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item"><a class="nav-link" href="ThirdPartyLogout.jsp">Logout</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<h1 class="my-4">
		 <small>History</small>
		</h1>

		<% 
		// code to display the new application in grid format.
		String username = (String)session.getAttribute("PartyUsername");
		if(username==null)
		{
			out.println("<script>alert('please login');window.location.href='thirdPartyLogin.html';</script>");
			
		}
		
		else{
			
		ArrayList<ThirdPartyApplication> list = ThirdPartyServices.viewAllApplications(username);
		// history button will have the path thirdPartViewAll.jp
		if(list == null)
		{%>
		<script>alert("error occurred, try to reload the page.");;window.location.href='ThirdPartViewAll.jsp';</script>
		<%}
		else if(list.size()==0)
		{
			out.println("no application history to display");
		}
		else
		{
			for(ThirdPartyApplication obj : list)
			{
				// display using getters
			%>
		<div class="row">
			<div class="col-md-12">

				<h3><%= %></h3>
				<p></p>

				
			</div>
		</div>
		</hr>
		<%	}
			
			
		}
		
		
		}%>
	</div>

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2017</p>
	</div>
	<!-- /.container --> </footer>

	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/popper.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>