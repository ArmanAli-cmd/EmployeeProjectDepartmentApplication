<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Employee Sign Up Page</title>
</head>
<body style="text-align: center;">
<div class="container">
	<h3>Register new employee</h3>
	<form action="/employees/add" method="post">
		Name: <input type="text" name="name" placeholder="Enter employee name"
			required><br>
		<br> Email: <input type="email" name="email"
			placeholder="Enter employee email" required><br>
		<br> Designation: <input type="text" name="designation"
			placeholder="Enter employee designation" required><br>
		<br> Salary: <input type="text" name="salary"
			placeholder="Enter employee salary" required="required"><br>
		<br> Date of Joining: <input type="text" name="dateOfJoining"
			placeholder="Enter employee date of joining" required><br>
		<br> Password: <input type="password" name="password"
			placeholder="Enter employee password" required><br>
		<br> Department Id: <input type="number" name="departmentId"
			placeholder="Enter department id" required><br>
		<br> Project Id: <input type="number" name="projectId"
			placeholder="Enter project id" required><br>
		<br> <input type="submit" class="btn btn-primary" value="Register">
	</form>
<br><br>
<a href="/views/index.jsp"> Go to home page</a>
</div>
</body>
</html>