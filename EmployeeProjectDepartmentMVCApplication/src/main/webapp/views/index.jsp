<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<%@ page import="java.util.Date"%>
<body style="text-align: center;">
	<%
	String message = (String) request.getAttribute("msz");
	if (message != null) {
	%>
	<script> 
			var userResponse = confirm("<%=message%>");
	</script>
	<%
	request.removeAttribute("msz");
	}
	%>
	<div class="container">


		<h3>Welcome to Employee Project Department Management Application</h3>
		<br>
		<div class="row">
			<div class="col-sm-4" style="border: 2px solid black;">
			<br>
				<h4>Employee Section</h4>
				<p>
					Click <a href="/views/employee-signup.jsp">here</a> to add new employee
					<br> <br>
					 Click <a href="/employees">here</a> to
					view the list of employees
					<br>
				</p>
			</div>
			<div class="col-sm-4" style="border: 2px solid black;">
			<br>
				<h4>Project Section</h4>
				<p>
					Click <a href="/views/project-signup.jsp">here</a> to add a new
					project <br> <br> Click <a href="/projects">here</a> to
					view the list of projects
				</p>
			</div>
			<div class="col-sm-4" style="border: 2px solid black;">
			<br>
				<h4>Department Section</h4>
				<p>
					Click <a href="/views/department-signup.jsp">here</a> to add a new
					department <br>
					<br> Click <a href="/departments">here</a> to view the list of
					departments<br>
				</p>
			</div>
		</div>
	</div>
</body>
</html>