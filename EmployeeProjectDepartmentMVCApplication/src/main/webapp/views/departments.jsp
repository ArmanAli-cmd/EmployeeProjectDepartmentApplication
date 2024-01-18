<%@page import="com.deloitte.dto.Department"%>
<%@page import="com.deloitte.dto.Project"%>
<%@page import="com.deloitte.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
<title>List of the departments</title>
</head>
<body>
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
		<h3>List of Projects</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Location</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Department> departments = (List<Department>) request.getAttribute("departments");
				for (Department department : departments) {
				%>
				<tr>
					<td><%=department.getId()%></td>
					<td><%=department.getName()%></td>
					<td><%=department.getLocation()%></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>

		<br>
		<div class="row">
			<div class="col-sm-6">
				<a href="/views/index.jsp"> Go to home page</a>
			</div>
			<div class="col-sm-6">
				<p style="text-align: right;">
					<a href="/views/department-signup.jsp" class="btn btn-primary"
						role="button">Add Department</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>