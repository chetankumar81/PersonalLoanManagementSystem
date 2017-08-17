<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.google.gson.Gson,com.shell.modular.business.Comments,java.util.ArrayList,com.shell.modular.business.CalculateRisk"%>

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
<link href="viewer/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

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
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Credit Manager <small>Comment page</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a
								href="viewer/credithome.jsp">Home</a></li>
						</ol>
					</div>
				</div>
				<!-- /.row -->
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
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
							String applicationid = null;
								for (int i = 0; i < commlist.size(); i++) {
							%>
							<tr>
								<td><%=commlist.get(i).feedback%></td>
								<td><%=commlist.get(i).name%></td>
								<td><%=commlist.get(i).role_name%></td>
							</tr>
							<%
								applicationid = commlist.get(i).appid;
								}
							%>
						</tbody>
					</table>
				</div>
				<% double emi = new CalculateRisk().getEmi(Integer.parseInt(applicationid));
				 double amount = new CalculateRisk().getAmountSanctioned(Integer.parseInt(applicationid));
				%>
				<div class="row">
					<form id="myform" action="${pageContext.request.contextPath}/submitloan" method="post">
						<div class="col-lg-12">
							<ol class="breadcrumb">
								<li><i></i>Loan Sanctioned Form</li>
							</ol>

							<div class="form-group">
								
								<label for="disabledSelect">Loan Amount Sanctioned</label> <input
									class="form-control" id="disabledInput" type="text" 
									value="<%=amount %>" placeholder="Disabled input"
									disabled=""><input type="hidden" value="<%=amount %>" name="amount">
							</div>
							<div class="form-group">
								<label for="disabledSelect">EMI for Loan</label> <input
									class="form-control" id="disabledInput" type="text" 
									value="<%=emi %>" placeholder="Disabled input"
									disabled=""><input type="hidden" value="<%=amount %>" name="emi">
							</div>
						</div>
						<input id="flag" type="hidden" name="flag" />
						<input type="hidden" name="appid" value="<%=applicationid %>"/>
						<div class="col-lg-6">
							<button id="reject" type="button" class="btn btn-danger pull-right">Reject</button>
						</div>
						<div class="col-lg-6">
							<button id="approve" type="button" class="btn btn-success">Approve</button>
						</div>
					</form>
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
		$("#approve").click(function(){
			document.getElementById("flag").value = "1";
			$("#myform").submit();
		})
		function submitLoanReject(){
			
			form.submit();
		}
		
		$("#reject").click(function(){
			document.getElementById("flag").value = "0";
			$("#myform").submit();
		})
		function submitLoanReject(){
			
			form.submit();
		}
	</script>
</body>

</html>
