<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.google.gson.Gson,com.shell.modular.business.Applications"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>App Details</title>

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
				data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
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
							Credit Manager <small>Detailed View</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="viewer/credithome.jsp">Home</a>
							</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<%	Applications app = (Applications)request.getAttribute("app");	%>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Application Id</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.application_id %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Name</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.salutation%>&nbsp;<%=app.fname %>&nbsp;<%=app.lname %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Email ID</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.email_id %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Gender</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.gender %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Date of Birth</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.date_of_birth %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Age</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.age %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Contact No</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.contact_no %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Address</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.address %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Pan No</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.pan_no %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Loan Amount</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.loan_amount %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Monthly Income</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.monthly_income %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Company Name</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.company_name %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Designation</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.designation %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Office Address</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.office_address %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Office Contact No</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.office_contact_no %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Office Email Id</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.office_email %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Existing Loan</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.existing_loan %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Photo</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.photo %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Status</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.status %></div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Registration Id</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.reg_id %></div>
					</div>
				</div>
				<div class="row">
						<button type="button" class="btn btn-warning center-block" onclick="viewcomments()">View Comments</button>
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
	
	<script type="text/javascript">
		function viewcomments(){
			window.location = "viewcommentscm?appid=<%=app.application_id %>";
		}
	</script>

</body>

</html>
