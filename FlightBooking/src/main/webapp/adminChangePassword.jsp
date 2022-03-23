<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Admin Password Change Page</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="adminHome.jsp"><svg
					xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">
           <path
						d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z" />
</svg> Flight Booking Admin Page</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active mx-3" href="#">Welcome
							Back <%
					if (session.getAttribute("adminname") != null) {
						out.print(session.getAttribute("adminname"));
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
						rd.forward(request, response);
					}
					%> <span class="visually-hidden">(current)</span>
					</a></li>

					<li class="nav-item"><a
						class="nav-link btn btn-warning text-dark mx-3"
						href="AdminController">Sing Out <svg
								xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-box-arrow-right"
								viewBox="0 0 16 16">
  <path fill-rule="evenodd"
									d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z" />
  <path fill-rule="evenodd"
									d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
</svg>
					</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<br>
	<br>


	<!--  Form code start here -->
	<div class="col-md-6 col-lg-4 offset-lg-4 offset-md-3 mt-5">
		<div class="bg-light p-5 border shadow">
			<!-- Login Form -->
			<form action="AdminController" method="post">
				<div class="mb-4">
					<h4 class="mb-4 text-center">
						<u>Admin Password Change Form</u>
					</h4>
				</div>

				<div class="mb-3">

					<p class="form-text mb-1">Enter Old Password</p>
					<input type="password" name="txtpassold" class="form-control"
						required placeholder="Enter Old Password">
					<p class="form-text text-end text-danger">
						<%
						if (request.getAttribute("oldPassErr") != null) {
							out.print(request.getAttribute("oldPassErr"));
						}
						%>
					</p>
				</div>
				<div class="mb-3">
					<p class="form-text mb-1">Enter New Password</p>
					<input type="password" name="txtpassnew1" required
						class="form-control" placeholder="Enter New Password">
					<p class="form-text text-end text-danger">
						<%
						if (request.getAttribute("newPassError1") != null) {
							out.print(request.getAttribute("newPassError1"));
						}
						%>
					</p>
				</div>

				<div class="mb-3">
					<p class="form-text mb-1">Re-Enter New Password</p>
					<input type="password" name="txtpassnew2" required
						class="form-control" placeholder="Re-Enter New Password">
					<p class="form-text text-end text-danger">
						<%
						if (request.getAttribute("newPassError2") != null) {
							out.print(request.getAttribute("newPassError2"));
						}
						%>
					</p>
				</div>


				<button name="button" value="changePassConfirmation" type="submit"
					class="btn btn-primary w-100 my-3 shadow">Change Password</button>
				<button type="reset" class="btn btn-danger w-100 shadow">Clear</button>

			</form>
			<!--  Form ends here  -->
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