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

<title>Loan Officer</title>

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
		<jsp:include page='side-nav-loanofficer.jsp' />
		<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<%
				// code to display the new application in grid format.
				String username = (String) session.getAttribute("username");
				if (username == null) {
					out.println("<script>alert('please login');window.location.href='home.html'</script>");

				}

				else {
					int id = Integer.parseInt(request.getParameter("id"));
					LoanOfficerApplication obj = LoanOfficerServices.detailViewApplications(id);

					if (obj == null) {
			%>
			<script>
				alert("error occurred, try to reload the page.");
			</script>
			<%
				}

					else {
			%>

			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b><%=obj.getName()%></b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getApplicationId()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Gender :</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getGender()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Email Id:</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getEmialId()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Address:</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getAddress()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Designation:</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getDesignation()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Company Name:</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getCompanyName()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Age:</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getAge()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Contact Number</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getContactNo()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Loan Amount</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getLoanAmount()%></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well">
							<b>Monthly Income</b>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=obj.getMonthlyIncome()%></div>
					</div>
				</div>

				<div class="row">
					<!-- /.col-lg-3 -->
					<!--  div that pop up images  -->

					


								<form
									action="${pageContext.request.contextPath}/LoanOfficerUpdateServlet"
									method="post" id="myform">
									<input type="hidden" value="<%=obj.getApplicationId()%>"
										name="applicationId" /><br />

									<textarea rows="2" cols="50" name="comment" form="myform"
										placeholder="enter the comment here" required></textarea>
									<br> <input type="submit" value="Assign"
										class="btn btn-success" />
							</div>

				</div>

			</div>




			<%
				}

				}
			%>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			//select the POPUP FRAME and show it

			$("#aadhar").on("click", function() {
				$("#aadhar_popup").hide().fadeIn(1000);
			});

			//close the POPUP if the button with id="close" is clicked
			$("#closeAadhar").on("click", function(e) {
				e.preventDefault();
				$("#aadhar_popup").fadeOut(1000);
			});
		});
	</script>

</body>

</html>
