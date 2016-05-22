<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap.min.css"/>
<title>CybageNet</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<center>
	<h3 style="color: grey">Welcome To Cybage Net</h3>
	</center>
	<br>
	<br>
	<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<form method="post" action="Home">
		<br>
		<input type="text" name="username" placeholder="username" class="form-control" autofocus required> 
		<br>	
		<input type="password" name="password" placeholder="password" class="form-control" required>
		<br>
		<center style="color:red">${message}</center> 
		<br>
		<center><input type="submit" value="Sign In" class="btn btn-primary"></center>
		<br>
		
	</form>
	</div>
	</div>
</body>
</html>