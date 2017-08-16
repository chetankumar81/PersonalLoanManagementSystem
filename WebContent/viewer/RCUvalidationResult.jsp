<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.shell.modular.business.Application"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RCU validation</title>

</head>
<body>
	<%
	 
	String username = (String)session.getAttribute("username");
	if(username==null)
	{
		out.println("<script>alert('please login');;window.location.href='index.html'</script>");
		
	}
	else
	{
	
	Application app = (Application)request.getAttribute("application");
	%>
	
	<label>Application ID:<input type="number" name="application" value='<%=(int)request.getAttribute("appId") %>' /></label><br><br>
	<label>Loan Amount:<input type="number" name="loan_amount" value='<%=app.getLoan_amount() %>'/></label><br><br>
	<label>Monthly Income:<input type="number" name="monthly_income" value='<%=app.getMonthly_income() %>'/></label><br><br>
	<label>Interest Rate:<input type="number" name="interest_rate" value='<%=app.getInterest_rate()%>'/></label><br><br>
	<label>Duration:<input type="number" name="duration" value='<%=app.getDuration_in_months() %>'/></label><br><br>
	<label>Existing EMI:<input type="number" name="existing_EMI" value='<%=(double)request.getAttribute("emi") %>' /></label><br><br>
	<label>Risk:<input type="text" name="risk" value='<%=(String)request.getAttribute("risk") %>'/></label>
	<%} %>
</body>
</html>