<jsp:useBean id="userCount" class="beans.ActiveUserBean" />
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="dashboard">CybageNet</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="AddBookDetails">Add Books</a></li>
			<li><a href="DeleteBook">Delete Books</a></li>
			<li><a href="#">Active User Count: ${userCount.activeUsers}</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome
					${sessionScope.user}</a></li>
			<li><a href="Logout"><span
					class="glyphicon glyphicon-log-in"></span>Logout</a></li>
		</ul>
	</div>
</nav>
