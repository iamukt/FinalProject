
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Dashboard</title>
</head>
<body>

	<c:choose>
		<c:when test="${sessionScope.role eq 'admin'}">
			<jsp:include page="headeradmin.jsp" />
			
		</c:when>
		<c:when test="${sessionScope.role eq 'user'}">
			<jsp:include page="headeruser.jsp" />
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>

	<div class="row" style="margin-top: 12em">
				<div class="col-md-4"></div>
				<div class="col-md-4" style="padding: 10px;">
					<h4>${message}</h4>
					<br>
					<p style="font: italic bold 22px/40px Georgia, serif;">CybageNet
						Search Book</p>
					<br>
					<form method="post" action="SearchBook">
						<input type="text" name="bookname" class="form-control" autofocus>
						<br>
						<br> <input type="submit" class="btn btn-primary"
							value="Search" style="float: right">
					</form>
				</div>
			</div>
			<div class="row" style="padding-top: 25px;"></div>

</body>
</html>