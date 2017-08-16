<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList;"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>History</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/1-col-portfolio.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1 class="my-4">
			DashBoard <small>History</small>
		</h1>




		<% 
		// code to display the new application in grid format.
		String username = (String)session.getAttribute("username");
		if(username==null)
		{
			out.println("<script>alert('please login');window.location.href='index.html'</script>");
		
		}
		
		else{
			
		ArrayList<LoanOfficerApplication> list = LoanOfficerServices.viewAllApplications(username);
		// history button will have the path thirdPartViewAll.jp
		if(list == null)
		{%>
		<script>alert("error occurred, try to reload the page.");
</script>
		<%}
		else if(list.size()==0)
		{
			out.println("no application history to display");
		}
		else
		{
			for(LoanOfficerApplication obj : list)
			{ %>


		<div class="row">
			<div class="col-md-12">

				<h3><%=obj.getApplicationId() %></h3>
				<p></p>


			</div>
		</div>
		</hr>




		<%  }
			
			
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