<%@page import="com.adminbeans.Airline_Names"%>
<%@page import="com.adminbeans.Source_To_Destination"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, shrink-to-fit=yes">

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

<title>Master List Of Airlines Page</title>
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
</svg> Flight Booking Admin</a>
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


	<div class="container ">
		<h1 class="text-primary text-center">
			Master List Of Airlines &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				type="button" href="masterListOfAirlinesInsertNew.jsp"
				class="btn btn-success btn-sm ml-6">Add New Airlines</a>
		</h1>

	</div>

	<%  if(request.getAttribute("msg")!=null){%>
	<div class="container">

		<% 	    out.print(request.getAttribute("msg"));
                    }
                   %>
	</div>

	<!-- Table of availab routes  -->
	<div class="container mt-3">
		<table class="table table-hover">
			<thead>
				<tr class="table-info text-dark">
					<th scope="col">Airline Id</th>
					<th scope="col">Airline Name</th>

					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>



			<tbody>
				<!-- Fetching the airlines details -->
				<%
            List <Airline_Names> arlist=(List <Airline_Names>)request.getAttribute("masterListOfAirlines");
   
    		for(Airline_Names ar:arlist){
    			
    		%>

				<tr class="table-light text-dark">
					<th scope="row"><%=ar.getAirlineId() %></th>
					<td><%=ar.getAirlineName() %></td>

					<td><form method="post" action="AirlineController">
							<button type="submit" value="airEdit" name="button"
								class="btn btn-warning text-dark">Edit</button>
							<%   out.print("<input type=hidden name=lblairid value="+ar.getAirlineId()+"> ");            
        %>
						</form></td>


					<td><form method="post" action="AirlineController">
							<button type="submit" value="delete" name="button"
								class="btn btn-danger text-dark">Delete</button>
							<%   out.print("<input type=hidden name=lblairid value="+ar.getAirlineId()+">");
                                %>
						</form></td>
				</tr>
				<% } %>
			</tbody>
		</table>

	</div>

	<div>
		<br>
		<br>
		<br>
		<br>
	</div>


	<footer class="mt-auto bg-primary  footer1 ">
		<p>
			---------Designed And developed by Sachin Gawade-----------</span>
		</p>
	</footer>



	<script src="bootstrap.bundle.min.js"></script>
</body>
</html>