<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Deletion</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="headeradmin.jsp" />
	<c:choose>
		<c:when test="${not empty message}">
			<center style="color: red">${message}</center>
		</c:when>
		<c:otherwise>
			<center style="color: red">Select the book to view or add
				the reveiw</center>
			<br>
			<br>
		</c:otherwise>
	</c:choose>
	<c:forEach items="${booklist}" var="book">
		<br>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="border: 1px solid green;">
				<br>
				<form method="post" action="ConfirmBookDel">
					<input type="radio" value="${book.isbn}" name="isbn">
					ISBN:&nbsp;&nbsp;
					<c:out value="${book.isbn}"></c:out>
					BookName:&nbsp;&nbsp;
					<c:out value="${book.bookName}"></c:out>
					Author:&nbsp;&nbsp;
					<c:out value="${book.author}"></c:out>
					Location:&nbsp;&nbsp;
					<c:out value="${book.location}"></c:out>
					<input type="submit" value="Click to Confirm Delete">
				</form>
				<br>
			</div>
		</div>
	</c:forEach>
</body>
</html>