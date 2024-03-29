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
<title>Department Sign Up Page</title>
</head>
<body style="text-align: center;">
<div class="container">
	<h3>Add a new department</h3>
	<form action="/departments/add" method="post">
		Name: <input type="text" name="name" placeholder="Enter department name"
			required><br>
		<br> 
		Location: <input type="text" name="location"
			placeholder="Enter department location" required><br>
		<br> 
		<br> <input type="submit" class="btn btn-primary" value="Add">
	</form>
<br><br>
<a href="/views/index.jsp"> Go to home page</a>
</div>
</body>
</html>