<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.shell.modular.business.LoanOfficerServices"%>
<%@ page import="com.shell.modular.business.LoanOfficerApplication"%>
<%@ page import="java.util.ArrayList;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String username = (String) session.getAttribute("LoanOfficerUsername");
		if (username == null) {
			out.println("<script>alert('please login');;window.location.href='login.html'</script>");
			
		}

		else {

			ArrayList<LoanOfficerApplication> list = LoanOfficerServices.viewForwardApplications();
			// history button will have the path thirdPartViewAll.jp
			if (list == null) {
	%>
	<script>
		alert("error occurred, try to reload the page.");window.location.href='LoanOfficerViewForwardApplication.jsp';
	</script>
	<%
		} else if (list.size() == 0) {
				out.println("no forward application to display");
			} else {
				for (LoanOfficerApplication obj : list) {
					// display the forward applications that are to be forwarded by loan officer in grid format.
	%>

	<form action="../LoanOfficerForwardServlet" method="post" id="myform">
		<input type="hidden" value="<%=obj.getApplicationId()%>"
			name="applicationId" /> <input type="submit" value="forward"
			name="LoanOfficerStatus" />
	</form>
	

	<%
		}

			}

		}
	%>





</body>
</html>