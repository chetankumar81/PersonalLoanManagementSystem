<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detailed view of the application</title>
<link href="${pageContext.request.contextPath}/viewer/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/viewer/assets/bootstrap/css/shop-item.css" rel="stylesheet">
<style>
#pan_popup {
	display: none;
	position: absolute;
	margin: 0 auto;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	box-shadow: 0px 0px 50px 2px #000;
}

#aadhar_popup {
	display: none;
	position: absolute;
	margin: 0 auto;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	box-shadow: 0px 0px 50px 2px #000;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<a class="navbar-brand" href="#">Loan Officer Portal</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="LoanOfficerView.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="LoanOfficerViewAll.jsp">History</a></li>
			<li class="nav-item"><a class="nav-link" href="LoanOfficerLogout.jsp">Logout</a></li>
		</ul>
	</div>
	</nav>

	<%
		// code to display the new application in grid format.
		String username = (String) session.getAttribute("username");
		if (username == null) {
			out.println("<script>alert('please login');window.location.href='login.html'</script>");


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

			<div class="col-lg-3">
				<h1 class="my-4"></h1>
				<div class="list-group">

					<button class="btn btn-primary" id="pan">Pan Photo Copy</button>
					<button class="btn btn-primary" id="aadhar">Aadhar Photo
						Copy</button>


				</div>
			</div>
			<!-- /.col-lg-3 -->
			<!--  div that pop up images  -->
			<div id="pan_popup">
				<img src="<%=obj.getPhotoUrl()%>" alt="popup">
				<button id="closePan" class="btn btn-success btn-xs">Close</button>
			</div>
			<div id="aadhar_popup">
				<img src="<%=obj.getDocUrl()%>" alt="popup">
				<button id="closeAadhar" class="btn btn-success btn-xs">Close</button>
			</div>


			<div class="col-lg-9">

				<div class="card mt-4">

					<div class="card-body">
						<h3 class="card-title"></h3>
						<h4>$24.99</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
							facere, soluta. Totam id dolores, sint aperiam sequi pariatur
							praesentium animi perspiciatis molestias iure, ducimus!</p>
						<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
							&#9734;</span> 4.0 stars
					</div>
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Details</div>
					<div class="card-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>

						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>

						<hr>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						
						<form action="${pageContext.request.contextPath}/LoanOfficerUpdateServlet" method="post" id="myform">
							<input type="text" value="<%= obj.getApplicationId() %>"  name="applicationId"/><br />
							
							<textarea rows="2" cols="50" name="comment" form="myform"
								placeholder="enter the comment here" required></textarea>
							<br> <input type="submit" value="Assign"
								class="btn btn-success" />
					</div>
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>




	<%
		}

		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			//select the POPUP FRAME and show it
			$("#pan").on("click", function() {
				$("#pan_popup").hide().fadeIn(1000);
			});

			//close the POPUP if the button with id="close" is clicked
			$("#closePan").on("click", function(e) {
				e.preventDefault();
				$("#pan_popup").fadeOut(1000);
			});

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
