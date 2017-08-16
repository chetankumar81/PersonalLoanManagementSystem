<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reset Password</title>

<!-- CSS -->
<link rel="stylesheet"
	href="viewer/l_assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="viewer/l_assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="viewer/l_assets/css/form-elements.css">
<link rel="stylesheet" href="viewer/l_assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="l_assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="l_assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="l_assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="l_assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="l_assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
	<%!String username = null; %>
	<% username = (String)request.getAttribute("userid"); %>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text"></div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-0 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<br />

								<h3>
									<b>Update Password</b>
								</h3>

							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="Change_Password" method="post"
								class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-password">password</label> <input
										type="password" name="pwd" placeholder="Enter password"
										class="form-password form-control" id="form-password"
										pattern="(?=.*\d)(?=.[a-z])(?=.*[A-Z]).{8,}"
										autocomplete="off" maxlength="40" required>
								</div>
								<input type="hidden" name="user" value=<%=username%>>
								<div class="form-group">
									<label class="sr-only" for="form-password">Confirm
										Password </label> <input type="password" name="cpwd"
										placeholder="Confirm password"
										class="form-password form-control" id="form-cpassword"
										pattern="(?=.*\d)(?=.[a-z])(?=.*[A-Z]).{8,}"
										autocomplete="off" maxlength="40" oninput="check(this)" required>
		<script language='javascript' type='text/javascript'>
        function check(input) {
        if (input.value != document.getElementById('form-password').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
        }
        </script>
								
								
								
								</div>
		
								<button type="submit" class="btn">
									<b><strong>Enter</strong></b>
								</button>
								<br />
							</form>
						</div>
					</div>

				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="l_assets/js/jquery-1.11.1.min.js"></script>
	<script src="l_assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="l_assets/js/jquery.backstretch.min.js"></script>
	<script src="l_assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

</html>