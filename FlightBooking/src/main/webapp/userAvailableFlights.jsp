<%@page import="com.adminbeans.Flight"%>
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

</style>
<title>Available Flights Detail Page</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="userSearchHomePage.jsp"><svg
					xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">
           <path
						d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z" />
</svg> User Searched Flights</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active mx-3" href="#">Welcome
							To Flight Booking App <span class="visually-hidden">(current)</span>
					</a></li>

					

				</ul>

			</div>
		</div>
	</nav>
	<br>
	<br>


	<div class="container ">
		<h1 class="text-primary text-center">
			Available Flight On the Chosen Routes        
			&nbsp; &nbsp; &nbsp;  
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
					<th scope="col">Flight Id</th>
					<th scope="col">Flight Source</th>
					<th scope="col">Flight Destination</th>
                     <th scope="col">Flight Airline Name</th>
                     <th scope="col">Ticket Price</th>       

					<th scope="col">Book Ticket</th>
					
				</tr>
			</thead>



			<tbody>
				<%
            List<Flight> fltlist=(List <Flight>)request.getAttribute("masterListOfFlights");
   
    		for(Flight fd:fltlist){
    			
    		%>

				<tr class="table-light text-dark">
					<th scope="row"><%=fd.getFlight_Id() %></th>
					<td><%=fd.getFSource() %></td>
					<td><%=fd.getFDestinatiom() %></td>
					<td><%=fd.getAirlineName() %> </td>
					<td><%=fd.getTicket_Price() %></td>
					
					
					<td><form method="post" action="UserController">
							<button type="submit" value="bookticket" name="button"
								class="btn btn-primary text-dark">Book Ticket</button>
							<%   out.print("<input type=hidden name=fldid value="+fd.getFlight_Id()+"> ");            
        %>
						</form></td>


					
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
	
<div><br><br><br><br></div>
<footer class="mt-auto bg-primary  footer1 "><p>---------Designed And developed by Sachin Gawade-----------</span></p></footer>

	
	
	
	<script src="bootstrap.bundle.min.js"></script>
</body>
</html>