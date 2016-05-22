<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Books</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
	<form method="post" action="ShowReviews">
				
	<c:forEach items="${bookList}" var="book">
		<br>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="border: 1px solid green;">
				<br>
					<input type="radio" value="${book.isbn}" name="isbn">
					ISBN:&nbsp;&nbsp;
					<c:out value="${book.isbn}"></c:out>
					<br>BookName:&nbsp;&nbsp;
					<c:out value="${book.bookName}"></c:out>
					<br>Author:&nbsp;&nbsp;
					<c:out value="${book.author}"></c:out>
					<br>Location&nbsp;&nbsp;
					<c:out value="${book.location}"></c:out>
					<br>
					<input type="hidden" name="bookName" value="${book.bookName}">
					<input type="submit" name="submit"
						value="Click to View Reviews" class="btn btn-primary"> 
					<input type="submit" name="submit" value="Click to Add a Review"
						class="btn btn-primary">
				
				<br>
			</div>
		</div>
	</c:forEach>
	</form>
</body>
</html>