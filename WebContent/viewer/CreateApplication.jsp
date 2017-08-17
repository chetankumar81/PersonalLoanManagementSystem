<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.google.gson.Gson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>New Application</title>

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
		<jsp:include page='side-nav-customer.jsp' /> <!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row" >
					<div class="col-lg-12">
						<h1 class="page-header">
							Customer <small>New Application</small>
						</h1>
						<ol class="breadcrumb">
							<li><i class="fa fa-dashboard"></i> <a href="CustomerDashboard.jsp">Home</a>
							</li>
						</ol>
					</div>
					<div class="col-lg-6">



						<div class="panel-body">

							<form class="form-horizontal"
								action="${pageContext.request.contextPath}/SubmitLoanApplicationForm"
								method="post">



								<div class="form-group">
									<label class="col-sm-2 control-label">Account Number</label>
									<div class="col-sm-10">
										<input type="text" name="account" class="form-control"
											required><br>

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">EMI Plan</label>
									<div class="col-lg-10">
										<div class="col-lg-6">
											<select class="form-control" name="Plan" required>
												<option value="6 3">6% 3MONTHS</option>
												<option value="9 6">9% 6MONTHS</option>
												<option value="12 9">12% 9MONTHS</option>
												<option value="15 12">15% 12MONTHS</option>
												<option value="18 15">18% 15MONTHS</option>
												<option value="21 18">21% 18MONTHS</option>
												<option value="24 21">24% 21MONTHS</option>
												<option value="27 24">27% 24MONTHS</option>

											</select><br>

										</div>
									</div>
								</div>


								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Name</label>
									<div class="col-lg-9">

										<div class="row">
											<div class="col-lg-3">
												<select class="form-control" name="salutation" required>
													<option>Mr</option>
													<option>Ms</option>
													<option>Mrs</option>
												</select><br>

											</div>

											<div class="col-lg-3">

												<input type="text" class="form-control"
													placeholder=".First Name" name="fname" required>
											</div>
											<div class="col-lg-3">
												<input type="text" class="form-control"
													placeholder=".Middle Name" name="mname">
											</div>
											<div class="col-lg-3">
												<input type="text" class="form-control"
													placeholder=".Last Name" name="lname">
											</div>
										</div>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">PAN Number</label>
									<div class="col-sm-10">
										<input type="text" name="pan" class="form-control" required>

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">E-mail</label>
									<div class="col-sm-10">
										<input type="email" name="email" class="form-control" required><br>

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Gender</label>
									<div class="col-sm-10">
										<select class="form-control" name="gender" required>
											<option>Male</option>
											<option>Female</option>
											<option>Others</option>
										</select><br>



									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Date of Birth</label>
									<div class="col-sm-10">
										<input type="date" name="dob" class="form-control" required><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Age</label>
									<div class="col-sm-10">
										<input type="text" name="age" class="form-control" required><br>

									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Contact Number</label>
									<div class="col-sm-10">
										<input type="text" name="pcontact" class="form-control"
											pattern="\d{10}" required><br>

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">Residential
										Address</label>
									<div class="col-sm-10">
										<textarea name="paddress" cols="80" rows="5" required></textarea>


									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Residence
										Ownership</label>
									<div class="col-sm-10">
										<select class="form-control" name="residential_owner" required>
											<option>Self Owned</option>
											<option>Parental</option>
											<option>Owned Mortgage</option>
											<option>Company Provided</option>
											<option>Paying Guest</option>
											<option>Rental</option>
											<option>Relatives</option>
										</select><br>
									</div>
								</div>




								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Employment
										Type</label>
									<div class="col-lg-10">

										<div class="row">
											<div class="col-lg-5">
												<select class="form-control" name="emptype" required>
													<option>Salaried</option>
													<option>Self Employed</option>

												</select><br>




											</div>
										</div>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Company/Business</label>
									<div class="col-sm-10">
										<input type="text" name="compname" class="form-control"
											required><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Designation</label>
									<div class="col-sm-10">
										<input type="text" name="desgn" class="form-control" required><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Office Address</label>
									<div class="col-sm-10">
										<textarea name="office_address" cols="80" rows="5" required></textarea>


									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Office Contact</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="office_contact"
											pattern="\d{10}" required><br>

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">Office E-mail</label>
									<div class="col-sm-10">
										<input type="email" name="office_email" class="form-control"
											required><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Loan Amount</label>
									<div class="col-sm-10">
										<input type="text" name="loan_amount" class="form-control"
											required><br>

									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Monthly
										Income(INR)</label>
									<div class="col-sm-10">
										<input type="text" name="mon_inc" class="form-control"
											required><br>

									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Existing
										Loan</label>

									<div class="col-lg-2">
										<input type="radio" name="exist_loan" value="yes"> Yes
										<input type="radio" name="exist_loan" value="no"> No
									</div>
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</form>

						</div>
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
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
