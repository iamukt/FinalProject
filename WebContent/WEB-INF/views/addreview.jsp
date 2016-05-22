<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add Review</title>
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
	<div class="row" style="margin-top: 11em">
		<div class="col-md-4"></div>
		<div class="col-md-4" style="padding: 10px;">
		<h4 align="center">
			${message}
			</h4>
			<form method="post" action="AddReview">
				 <textarea name="review" class="form-control" rows="10" cols="50"></textarea>
				<input type="hidden" name="isbn" value="${isbn}"> <br><input
					type="submit" name="Add Review" class="btn btn-default" style="float: right">
			</form>
		</div>
	</div>
</body>
</html>