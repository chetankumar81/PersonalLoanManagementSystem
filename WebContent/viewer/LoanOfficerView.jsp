<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.google.gson.Gson"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>CM Home</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page='header.jsp' />
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<jsp:include page='side-nav-loanofficer.jsp' /> <!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row" >
					<div class="col-lg-12">
						<h1 class="page-header">
							Loan Officer<small>Home page</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="LoanOfficerView.jsp">Home</a>
							</li>
						</ol>
					</div>
					<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
				out.println("<script>alert('please login');window.location.href='home.html';</script>");
				
			}

			else {

				ArrayList<LoanOfficerApplication> list = LoanOfficerServices.viewNewApplications();
				// history button will have the path thirdPartViewAll.jp
				if (list == null) {
		%>
		<script>
			alert("error occurred, try to reload the page.");window.location.href='LoanOfficerView.jsp';
			
		</script>
		<%
			} else if (list.size() == 0) {
					out.println("no new applications to display");
				} else {
					for (LoanOfficerApplication obj : list) {
						// display the new applications that are to be verified by loan officer in grid format.
		%>
		<div class="row"><br/><br/>
		<form action="LoanOfficerApplicationDetailView.jsp" method="get">
			<div class="col-md-6" style="padding-left:10%">
				
					
					<p><b>Application Id :</b> <%=obj.getApplicationId() %></p>
				</div>
				<div class="col-md-6">	
					<input type="hidden" value="<%=obj.getApplicationId()%>"
						name="id" /> <input type="submit" class="btn btn-primary" value="view application" />
				

			</div><br/><br/>
			</form>
		</div>
		</hr>
		<%
			}

				}
				

			}
		%>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/select/1.2.1/js/dataTables.select.min.js"></script>

</body>

</html>
