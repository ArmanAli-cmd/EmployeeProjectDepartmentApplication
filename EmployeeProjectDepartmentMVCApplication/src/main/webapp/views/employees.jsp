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
<title>List of the employees</title>
</head>
<body>
<%
 	String message = (String)request.getAttribute("msz");
	if(message != null){%>
		<script> 
			var userResponse = confirm("<%= message %>");
	        
		</script>
		<%
		request.removeAttribute("msz");
	}
%>
	<div class="container">
	<h3>List of employees</h3><br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Designation</th>
					<th>Date of joining</th>
					<th>Salary</th>
					<th>Department ID</th>
					<th>Project ID</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Employee> employees = (List<Employee>) request.getAttribute("employees");
				for (Employee employee : employees) {
				%>
				<tr>
					<td><a href="/employee-details/<%= employee.getId()%>"><%=employee.getId()%></a></td>
					<td><%=employee.getName()%></td>
					<td><%=employee.getEmail()%></td>
					<td><%=employee.getPassword()%></td>
					<td><%=employee.getDesignation()%></td>
					<td><%=employee.getDateOfJoining()%></td>
					<td><%=employee.getSalary()%></td>
					<td><%=employee.getDepartmentId()%></td>
					<td><%=employee.getProjectId()%></td>
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
				<p style="text-align: right;"><a href="/views/employee-signup.jsp"
					class="btn btn-primary" role="button">Add Employee</a></p>
			</div>
		</div>
	</div>

</body>
</html>