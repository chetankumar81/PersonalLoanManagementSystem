<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->

 <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registration</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/media-queries.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
        
      
</head>
<body>
<!-- Top menu -->
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
		
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a  href="home.html">Home</a></li>
						
						<li><a href="login1.html">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
				
        <!-- Top content -->
        <div class="top-content">
        	<div class="container">
        	
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1 class="wow fadeInLeftBig">Join us Here</h1>
						<div class="description wow fadeInLeftBig">
							<p>
								Your satisfaction is our priority
							</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 r-form-1-box wow fadeInUp">
						<div class="r-form-1-top">
							<div class="r-form-1-top-left">
								<h3>Sign up now</h3>
								<p>Fill in the form below to get instant access:</p>
							</div>
							<div class="r-form-1-top-right">
								<i class="fa fa-pencil"></i>
							</div>
						</div>
						<div class="r-form-1-bottom">
							<form role="form" action="../RegServlet" method="post">
								<div class="form-group">
									<label class="sr-only" for="r-form-1-first-name">First Name</label>
									<input type="text" name="fname" placeholder="FIRST NAME" class="r-form-1-first-name form-control" id="r-form-1-first-name" maxlength="20" pattern="[A-Za-z]{1,20}" title="Name should not contain numbers" required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-middle-name">Middle name</label>
									<input type="text" name="mname" placeholder="MIDDLE NAME (optional)" class="r-form-1-middle-name form-control" id="r-form-1-middle-name" maxlength="20" pattern="[A-Za-z]{0,20}" title="Name should not contain numbers">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-last-name">Last name</label>
									<input type="text" name="lname" placeholder="LAST NAME (optional)" class="r-form-1-last-name form-control" id="r-form-1-last-name" maxlength="20" pattern="[A-Za-z]{0,20}" title="Name should not contain numbers">
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-contact">Contact</label>
									<input type="tel" name="contact" placeholder="CONTACT NUMBER" class="r-form-1-contact form-control" id="r-form-1-contact" pattern="\d{10}" title='Phone Number (Format: 9999999999)' required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-gender">Gender</label>
									<input type="radio" name="gender"  id="r-form-1-gender1" value="Male" checked>  Male
									<input type="radio" name="gender"  id="r-form-1-gender2" value="Female">  Female
									<input type="radio" name="gender"  id="r-form-1-gender3" value="Others">  Others
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-dob">Date of Birth</label>
									<input type="date" name="dob" placeholder="(DD-MON-YYYY)" class="r-form-1-dob form-control" id="r-form-1-dob"  title="Date of Birth (Format: DD-MM-YYYY)" required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-email">Email</label>
									<input type="email" name="email" placeholder="EMAIL-ID" class="r-form-1-email form-control" id="r-form-1-email" maxlength="50" title="email" required>
								</div>

								<div class="form-group">
									<label class="sr-only" for="r-form-1-about-yourself">Address</label>
									<textarea name="address" placeholder="RESIDENTIAL ADDRESS" 
												class="r-form-1-about-yourself form-control" id="r-form-1-about-yourself" required maxlength="200"></textarea>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-username">Username</label>
									<input type="text" name="username" placeholder="USERNAME" class="r-form-1-username form-control" id="r-form-1-username" title="username(minlength:3,maxlength:8,lowercase and numbers only)" pattern="[a-z0-9]{3,8}" required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-password">Password</label>
									<input type="password" name="password" placeholder="PASSWORD" class="r-form-1-password form-control" id="r-form-1-password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" autocomplete="off" maxlength="40" required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-security-question">Question</label>
									<textarea name="question" placeholder="SECURITY QUESTION" 
									class="r-form-1-security-question form-control" id="r-form-1-security-question" required></textarea>
								</div>
								<div class="form-group">
									<label class="sr-only" for="r-form-1-answer">Answer</label>
									<textarea name="answer" placeholder="YOUR ANSWER" 
												class="r-form-1-answer form-control" id="r-form-1-answer" required></textarea>
								</div>
								<button type="submit" class="btn">SIGN UP</button>
							</form>
						</div>
					</div>
				</div>
                
            </div>
        </div>



        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/wow.min.js"></script>
        <script src="assets/js/retina-1.1.0.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>
</html>