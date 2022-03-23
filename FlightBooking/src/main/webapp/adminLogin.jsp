<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<style type="text/css">
.footer1 {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	color: white;
	padding-top: 10px;
	text-align: center;
}
</style>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<!-- Menu Bar  code start here -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand mx-4" href="#"><svg
					xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">
  <path
						d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z" />
</svg> Flight Booking Admin Login Page</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


		</div>
	</nav>
	<!-- Menu Bar  code end  here -->

	<!-- Login Form code start here -->
	<div class="col-md-6 col-lg-4 offset-lg-4 offset-md-3 mt-5">
		<div class="bg-light p-5 border shadow">
			<!-- Login Form -->
			<form action="AdminController" method="post">
				<div class="mb-4">
					<h3 class="mb-4 text-center">Admin Sign In</h3>
				</div>

				<div class="mb-3">

					<p class="form-text mb-1">Enter Admin Username</p>
					<input type="text" name="txtuname" class="form-control" required
						placeholder="Enter Valid Admin Username">
					<p class="form-text text-end text-danger">
						<%
						if (request.getAttribute("err1") != null) {
							out.print(request.getAttribute("err1"));
						}
						%>
					</p>
				</div>
				<div class="mb-3">
					<p class="form-text mb-1">Enter Password</p>
					<input type="password" name="txtpass" required class="form-control"
						placeholder="Enter Password">
					<p class="form-text text-end text-danger">
						<%
						if (request.getAttribute("err2") != null) {
							out.print(request.getAttribute("err2"));
						}
						%>
					</p>
				</div>

				<button name="button" value="adminLogin" type="submit"
					class="btn btn-primary w-100 my-3 shadow">Login</button>
				<button type="reset" class="btn btn-danger w-100 shadow">Clear</button>

			</form>
			<!-- Login Form ends here  -->
		</div>
	</div>

	<footer class="mt-auto bg-primary  footer1 ">
		<p>
			---------Designed And developed by Sachin Gawade-----------</span>
		</p>
	</footer>

	<script src="bootstrap.bundle.min.js"></script>




</body>
</html>