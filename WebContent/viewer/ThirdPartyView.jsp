
<!-- this page list the new applications for third party to review -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.ThirdPartyServices"%>
<%@ page import="com.shell.modular.business.ThirdPartyApplication"%>
<%@ page import="java.util.ArrayList;"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Third Party View Contents</title>

<link href="${pageContext.request.contextPath}/viewer/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/viewer/bootstrap/css/1-col-portfolio.css" rel="stylesheet">
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
			<li class="nav-item active"><a class="nav-link"
				href="ThirdPartyView.jsp">Home <span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item"><a class="nav-link"
				href="ThirdPartyLogout.jsp">Logout</a></li>
		</ul>
	</div>
	</nav>
	<!--  end of navbar -->

	<div class="container">
		<h1 class="my-4">
			DashBoard <small>New Applications</small>
		</h1>

		<%
			// code to display the new application in grid format.
			String username = (String) session.getAttribute("username");
			if (username == null) {
				out.println("<script>alert('please login');window.location.href='thirdPartyLogin.html';</script>");
				
			}

			else {

				ArrayList<ThirdPartyApplication> list = ThirdPartyServices.viewNewApplications();
				// history button will have the path thirdPartViewAll.jp
				if (list == null) {
		%>
		<script>
			alert("error occurred, try to reload the page.");window.location.href='ThirdPartyView.jsp';
		</script>
		<%
			}

				else if (list.size() == 0) {
					out.println("no new application to display");
				} else {
					for (ThirdPartyApplication obj : list) {
						// display the new applications that are to be verified by third party in grid format.
		%>

		<div class="row">
			<div class="col-md-12">

				<h3><%= obj.getApplicationId() %> </h3>
				<p><b>Customer name</b> : <%= obj.getName() %> </p>
				<p><b>Customer address</b> : <%= obj.getAddress() %> </p>
				<p><b>Customer contact:</b> : <%= obj.getContact_no() %> </p>
				<form action="${pageContext.request.contextPath}/ThirdPartyUpdateServlet" method="post" id="myform">
					<textarea rows="4" cols="50" name="comment" form="myform"
						placeholder="enter the comment here" required></textarea>
					<input type="hidden" value="<%=obj.getApplicationId()%>"
						name="applicationId" /> <input type="submit" value="verified"
						name="ThirdPartyStatus" /> <input type="submit" value="not verified"
						name="ThirdPartyStatus" />
				</form>
			</div>
		</div>
		<hr/>

		<%
			}

				}

			}
		%>

	</div>

	<!-- Footer -->

	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your
			Website 2017</p>
	</div>
	<!-- /.container --> </footer>

	<script src="${pageContext.request.contextPath}/viewer/bootstrap/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/viewer/bootstrap/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/viewer/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>