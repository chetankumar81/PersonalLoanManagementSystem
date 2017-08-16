<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>New Loan Application</title>

<!-- Bootstrap Core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="bootstrap/css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>

<body>
<% 
	String username = (String) session.getAttribute("CustomerUsername");
	
	if(username==null)
	{
		out.println("<script>alert('please login');window.location.href='login.html';</script>");
		
	}
	
	else
	{
%>


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
			<a class="navbar-brand" href="index.html">Logo</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">
				<ul class="dropdown-menu message-dropdown">
					<li class="message-preview"><a href="#">
							<div class="media">
								<span class="pull-left"> </span>
								<div class="media-body"></div>
							</div>
					</a></li>

				</ul></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i><%=username %><b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					

					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Change
							Password</a></li>
					<li class="divider"></li>
					<li><a href="CustomerLogout.jsp"><i class="fa fa-fw fa-power-off"></i>
							Log Out</a></li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="CustomerDashboard.jsp"><i
						class="fa fa-fw fa-home"></i> Dashboard</a></li>
				<li><a href="tables.html"><i class="fa fa-fw fa-search"></i>
						Track Application</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">



						<div class="panel-body">

							<form class="form-horizontal" action="../SubmitLoanApplicationForm"
								method="post" enctype="multipart/form-data">


								<div class="form-group">
									<label class="col-sm-2 control-label">Application
										Number</label>
									<div class="col-sm-10">
										<input type="number" name="appnum" class="form-control"
											disabled><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Account Number</label>
									<div class="col-sm-10">
										<input type="text" name="account" class="form-control"><br>

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">EMI Plan</label>
									<div class="col-sm-10">
										<div class="col-lg-3">
												<select class="form-control">
													<option name="Plan">Mr.</option>
													<option name="Plan">Ms.</option>
													<option name="Plan">Mrs.</option>
												</select><br>

											</div>
									</div>
								</div>
								
								
								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Name</label>
									<div class="col-lg-10">

										<div class="row">
											<div class="col-lg-3">
												<select class="form-control">
													<option name="salutation">Mr.</option>
													<option name="salutation">Ms.</option>
													<option name="salutation">Mrs.</option>
												</select><br>

											</div>

											<div class="col-lg-3">

												<input type="text" class="form-control"
													placeholder=".First Name" name="fname">
											</div><br/>
											<div class="col-lg-3">
												<input type="text" class="form-control"
													placeholder=".Middle Name" name="mname">
											</div><br/>
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
										<input type="text" name="pan" class="form-control">

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">E-mail</label>
									<div class="col-sm-10">
										<input type="email" name="email" class="form-control"><br>

									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">Gender</label>
									<div class="col-sm-10">
										<select class="form-control">
											<option name="gender">Male</option>
											<option name="gender">Female</option>
											<option name="gender">Others</option>
										</select><br>



									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Date of Birth</label>
									<div class="col-sm-10">
										<input type="date" name="dob" class="form-control"><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Age</label>
									<div class="col-sm-10">
										<input type="number" name="age" class="form-control"><br>

									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Contact Number</label>
									<div class="col-sm-10">
										<input type="number" name="pcontact" class="form-control"><br>

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">Residential
										Address</label>
									<div class="col-sm-10">
										<textarea name="paddress" cols="80" rows="5"></textarea>


									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Residence
										Ownership</label>
									<div class="col-sm-10">
										<select class="form-control">
											<option name="residential_owner">Self Owned</option>
											<option name="residential_owner">Parental</option>
											<option name="residential_owner">Owned Mortgage</option>
											<option name="residential_owner">Company Provided</option>
											<option name="residential_owner">Paying Guest</option>
											<option name="residential_owner">Rental</option>
											<option name="residential_owner">Relatives</option>
										</select><br>
									</div>
								</div>




								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Employment
										Type</label>
									<div class="col-lg-10">

										<div class="row">
											<div class="col-lg-2">
												<select class="form-control">
													<option name="emptype">Salaried</option>
													<option name="emptype">Self Employed</option>

												</select><br>




											</div>
										</div>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Company/Business</label>
									<div class="col-sm-10">
										<input type="text" name="compname" class="form-control"><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Designation</label>
									<div class="col-sm-10">
										<input type="text" name="desgn" class="form-control"><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Office Address</label>
									<div class="col-sm-10">
										<textarea name="office_address" cols="80" rows="5"></textarea>


									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Office Contact</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"
											name="office_contact"><br>

									</div>
								</div>



								<div class="form-group">
									<label class="col-sm-2 control-label">Office E-mail</label>
									<div class="col-sm-10">
										<input type="email" name="office_email" class="form-control"><br>

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">Loan Amount</label>
									<div class="col-sm-10">
										<input type="number" name="loan_amount" class="form-control"><br>

									</div>
								</div>


								<div class="form-group">
									<label class="col-sm-2 control-label">Monthly
										Income(INR)</label>
									<div class="col-sm-10">
										<input type="number" name="mon_inc" class="form-control"><br>

									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-lg-2" for="inputSuccess">Existing
										Loan</label>

									<div class="col-lg-2">
										<input type="radio" name="exist_loan"> Yes <input
											type="radio" name="exist_loan"> No




									</div>
								</div>


								<div class="form-group">

									<label class="col-sm-2 control-label" for="exampleInputFile">Upload
										Photo</label>
									<div class="col-sm-10">
										<input type="file" name="photo" id="exampleInputFile3">
										<br>
										<br>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="exampleInputFile">Upload
										Residential Address Proof</label>
									<div class="col-sm-10">
										<input type="file" name="paddress" id="exampleInputFile3">
										<br>
										<br>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" for="exampleInputFile">Upload
										ID Proof(PAN/Aadhar/VoterID)</label>
									<div class="col-sm-10">
										<input type="file" name="pid" id="exampleInputFile3">
										<br>
										<br>
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
	<script src="bootstrap/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
<%} %>
</body>

</html>

