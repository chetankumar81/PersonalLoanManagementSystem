<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList,com.shell.modular.business.Tracking"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tracking</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/viewer/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/viewer/css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/viewer/font-awesome/css/font-awesome.min.css" rel="stylesheet"
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
		<jsp:include page='side-nav.jsp' /> <!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row" >
					<div class="col-lg-12">
						<h1 class="page-header">
							Customer <small>Track Application Page</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="viewer/CustomerDashboard.jsp">Home</a>
							</li>
						</ol>
					</div>
					<%
		ArrayList<Tracking> applicationList = (ArrayList) request.getAttribute("appList");
	%>
					<div id="table" style="height:550px;" >
						<table class="table table-bordered table-hover table-striped" >
							<thead>
								<tr>
									<th>APPLICATION ID</th>
									<th>STATUS</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Tracking track : applicationList) {%>
										<tr>
											<td><%=track.getAppID()%></td>
											<td><%=track.getStatus() %></td>
										
										</tr>
			<%	}
			%>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/viewer/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/viewer/js/bootstrap.min.js"></script>
</body>

</html>
