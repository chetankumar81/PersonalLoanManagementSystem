<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan officer view new application</title>
<link href="${pageContext.request.contextPath}/viewer/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/viewer/assets/bootstrap/css/1-col-portfolio.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<h1 class="my-4">
			DashBoard <small>New Applications</small>
		</h1>

		<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
				out.println("<script>alert('please login');window.location.href='index.html';</script>");
				
			}

			else {

				ArrayList<LoanOfficerApplication> list = LoanOfficerServices.viewNewApplications();
				// history button will have the path thirdPartViewAll.jp
				if (list == null) {
		%>
		<script>
			alert("error occurred, try to reload the page.");window.location.href='LoanOfficerView.jsp';
			
		</script>
		<%
			} else if (list.size() == 0) {
					out.println("no new applications to display");
				} else {
					for (LoanOfficerApplication obj : list) {
						// display the new applications that are to be verified by loan officer in grid format.
		%>
		<div class="row">
			<div class="col-md-12">
				<form action="LoanOfficerApplicationDetailView.jsp" method="get">

					<p>descriptions</p>
					<input type="hidden" value="<%=obj.getApplicationId()%>"
						name="id" /> <input type="submit" value="View" />
				</form>

			</div>
		</div>
		</hr>
		<%
			}

				}

			}
		%>

		<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/popper.min.js"></script>
		<script src="${pageContext.request.contextPath}/viewer/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>