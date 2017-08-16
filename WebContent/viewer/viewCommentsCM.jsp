<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.google.gson.Gson,com.shell.modular.business.Comments,java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Comments</title>

<!-- Bootstrap Core CSS -->
<link href="viewer/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="viewer/css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="viewer/font-awesome/css/font-awesome.min.css" rel="stylesheet"
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
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html"></a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i> <%=session.getAttribute("username") %> <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
							Out</a></li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<jsp:include page='side-nav.jsp' /> <!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row" >
					<div class="col-lg-12">
						<h1 class="page-header">
							Credit Manager <small>Comment page</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="viewer/credithome.jsp">Home</a>
							</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="table-responsive" style="height:370px;">
					<table class="table table-bordered table-hover table-striped" >
						<thead>
							<tr>
								<th>FEEDBACK</th>
								<th>NAME</th>
								<th>ROLE</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<Comments> commlist = (ArrayList<Comments>) request.getAttribute("commlist");
								for (int i = 0; i < commlist.size(); i++) {
							%>
							<tr>
								<td><%=commlist.get(i).feedback%></td>
								<td><%=commlist.get(i).name%></td>
								<td><%=commlist.get(i).role_name%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<button type="button" class="btn btn-danger pull-right" onclick="viewcomments()">Reject</button>
					</div>
					<div class="col-lg-6">
						<button type="button" class="btn btn-success" onclick="viewcomments()">Approve</button>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="viewer/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="viewer/js/bootstrap.min.js"></script>
	

</body>

</html>
