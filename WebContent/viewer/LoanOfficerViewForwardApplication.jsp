<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forward applications</title>
<link
	href="${pageContext.request.contextPath}/viewer/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/viewer/bootstrap/css/1-col-portfolio.css"
	rel="stylesheet">
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
		if (username == null) {
			out.println("<script>alert('please login');window.location.href='home.html'</script>");

		}

		else {

			ArrayList<LoanOfficerApplication> list = LoanOfficerServices.viewForwardApplications();
			// history button will have the path thirdPartViewAll.jp
			if (list == null) {
	%>
	<script>
		alert("error occurred, try to reload the page.");
		forward();
	</script>
	<%
		} else if (list.size() == 0) {
				out.println("no forward application to display");
			} else {
				for (LoanOfficerApplication obj : list) {
					// display the forward applications that are to be forwarded by loan officer in grid format.
	%>

	<div class="row">
		<div class="col-md-12">

			<form action="/LoanOfficerForwardServlet" method="post" >

				<input type="hidden" value="<%=obj.getApplicationId()%>"
					name="applicationId" /> <input type="submit" value="forward"
					name="LoanOfficerStatus" class="btn btn-primary btn-xs"/>
			</form>
		</div>
	</div>
	<hr />

	<%
		}

			}

		}
	%>



	<script type="text/javascript">
		function forward() {
			window.location.href = 'LoanOfficerViewForwardApplication.jsp';
		}
	</script>

</body>
</html>