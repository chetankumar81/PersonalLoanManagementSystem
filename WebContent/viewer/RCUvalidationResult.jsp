<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.shell.modular.business.Application"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RCU validation</title>
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
							Loan Inspector <small>Detailed View</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="${pageContext.request.contextPath}/viewer/LoanInspector.jsp">Home</a>
							</li>
						</ol>
					</div>
				</div>
	<%
	 
	//String username = (String)session.getAttribute("username");
	String username="kumaresh";
	int userId=7;
	if(username==null)
	{
		out.println("<script>alert('please login');</script>");
		response.sendRedirect("index.html");
	}
	else
	{
	
	Application app = (Application)request.getAttribute("application");
	int appId= (Integer)request.getAttribute("appId");
	double emi = (Double)(request.getAttribute("emi"));
	%>
	
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Application Id</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=appId %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Loan Amount</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.getLoan_amount() %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Monthly Income</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.getMonthly_income() %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Interest Rate</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.getInterest_rate() %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Duration</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=app.getDuration_in_months() %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Existing EMI</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><%=emi %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Risk</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well" name="risk"><%=(String)request.getAttribute("risk") %></div>
					</div>
	</div>
	<div class="row">
					<div class="col-lg-4">
						<div class="well"><b>Comments</b></div>
					</div>
					<div class="col-lg-8">
						<div class="well"><input type="text" id="comments"/></div>
					</div>
	</div>
	<div class="row">
						<button type="button" class="btn btn-warning center-block" onclick="submitdetails()">Submit comment</button>
				</div>
	
	</div>
	</div>
	</div>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/viewer/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		function submitdetails(){
			var comment=document.getElementById("comments").value;
			
			window.location=  "UpdateLoanInspector?appid="+<%=appId%>+"&officerId="+'<%=username%>'+"&risk="+'<%=(String)request.getAttribute("risk")%>'+"&comments="+comment;
		
		}
	</script>
	<%} %>
</body>
</html>