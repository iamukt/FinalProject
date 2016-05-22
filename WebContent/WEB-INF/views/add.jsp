<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add Books</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.role eq 'admin'}">
			<jsp:include page="headeradmin.jsp" />
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>

	
	<br>
	<form method="post" action="AddBook">
		<div class="container" style="margin-top: 8em">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-4"></div>
				<div class="col-md-4" style="border: 1px solid green" >
				<div class="form-group" align="center">
				<label>	${bookDetails.bookName}${message}
				</label>
				</div>
				
				<div class="form-group">
					<input type="text" name="bookname" placeholder="Book Name"
						class="form-control"><br>
				</div>
				<div class="form-group">
					<br> <input type="text" name="author" placeholder="Author"
						class="form-control"><br>
				</div>
				<br> <input type="text" name="location" placeholder="Location"
					class="form-control"><br>
				<div class="form-group" align="center">
					<br> <input type="submit" class="btn btn-primary">
				</div>
			</div>
		</div>
	</div>
	</form>

</body>
</html>