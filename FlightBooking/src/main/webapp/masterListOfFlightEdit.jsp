<%@page import="com.adminbeans.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Flight Details Form</title>
 <link rel="stylesheet" href="bootstrap.min.css">
 
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
 
 
 
</head>
<body>
<!-- Menu Bar  code start here -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">
  <path d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z"/>
</svg> Flight Booking Admin Page</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link active mx-3" href="#">Welcome Back <% if(session.getAttribute("adminname")!=null){
        	  out.print(session.getAttribute("adminname"));}
        	  else{
        		  RequestDispatcher rd=request.getRequestDispatcher("adminLogin.jsp");
        	       rd.forward(request, response);        	  
        	  }%> 
          
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link btn btn-warning text-dark mx-3" href="AdminController">Sing Out <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
  <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
</svg> </a>
        </li>
        
      </ul>
    
    </div>
  </div>
</nav>


<!-- Menu Bar  code end  here -->

<!-- Flight Edit Form code start here -->
<div class="col-md-6 col-lg-4 offset-lg-4 offset-md-3 mt-5">
    <div class="bg-light p-5 border shadow">
        <!--  Form -->
        <form action="FlightController" method="post">                
                  <div class="mb-4">
                   <h5 class="mb-4 text-center">Update Flight Details Form</h5>
                   </div>
                <!-- Printing success message on completion of updation  -->   
              <%  if(request.getAttribute("msg")!=null){
            	    out.print(request.getAttribute("msg"));
                    }
                   %>       
			  <%!Flight bean=null; %>
			  
			    <%  if(request.getAttribute("edit_flight_Record")!=null){
			    	bean=(Flight)request.getAttribute("edit_flight_Record");			    
			         }
			    	%>	
			    
				
				
				<div class="mb-3">
            
            
            <p class="form-text mb-1"> Source City Name</p>
                <input type="text" name="txtsource" placeholder="Enter Source City" class="form-control"  required
                
                <% if(request.getAttribute("msg")!=null){
                	         out.print("disabled=disabled");              } 
                	 %>
                value=<%if(request.getAttribute("msg")!=null){
                	       out.print("");}
                 else{
                	 out.print(bean.getFSource());} %>        >               
       
                
             
                <p class="form-text text-end text-danger"><%if(request.getAttribute("err1")!=null){
                	  out.print(request.getAttribute("err1")); }%></p>
            </div>
            
            <div class="mb-3">
                <p class="form-text mb-1">Destination City Name</p>
                <input type="text" name="txtdestination" required class="form-control" placeholder="Enter Destination City"
                  <% if(request.getAttribute("msg")!=null){
                	         out.print("disabled=disabled");              } 
                	 %>
                 value=<%if(request.getAttribute("msg")!=null){
                	       out.print("");}
                 else{
                	 out.print(bean.getFDestinatiom());} %>
                >
                 
            </div>
            
            <div class="mb-3">
                <p class="form-text mb-1">Airline Name</p>
                <input type="text" name="txtairlinenm" required class="form-control" placeholder="Enter Airline Name"
                  <% if(request.getAttribute("msg")!=null){
                	         out.print("disabled=disabled");              } 
                	 %>
                 value=<%if(request.getAttribute("msg")!=null){
                	       out.print("");}
                 else{
                	 out.print("\""+bean.getAirlineName()+"\"");} %>
                >
                 
            </div>
            
            
             <div class="mb-3">
                <p class="form-text mb-1">Ticket Price</p>
                <input type="text" name="txtprice" required class="form-control" placeholder="Enter Ticket Price"
                  <% if(request.getAttribute("msg")!=null){
                	         out.print("disabled=disabled");              } 
                	 %>
                 value=<%if(request.getAttribute("msg")!=null){
                	       out.print("");}
                 else{
                	 out.print(bean.getTicket_Price());} %>
                >
                 
            </div> 
            
            
            
            
            <input type="hidden" name="fltId" value=<%=bean.getFlight_Id() %>  >
            
            <button name="button" value="update" type="submit"
             <% if(request.getAttribute("msg")!=null){
                	         out.print("disabled=disabled");              } 
                	 %>
             class="btn btn-success w-100 my-3 shadow">Update Flight</button>
            
              </form>
              
          <form action="FlightController" method="post">   
          <button class="btn btn-success w-100 my-3 shadow" name="button" value="masterListOfFlight" type="submit" >
          <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-skip-backward-fill" viewBox="0 0 16 16">
          <path d="M.5 3.5A.5.5 0 0 0 0 4v8a.5.5 0 0 0 1 0V8.753l6.267 3.636c.54.313 1.233-.066 1.233-.697v-2.94l6.267 3.636c.54.314 1.233-.065 1.233-.696V4.308c0-.63-.693-1.01-1.233-.696L8.5 7.248v-2.94c0-.63-.692-1.01-1.233-.696L1 7.248V4a.5.5 0 0 0-.5-.5z"/>
           </svg>
          
              Go Back To Master List Of Flights             
        </button>
       </form> 
        <!--  Form ends here  -->
    </div>
</div>
<footer class="mt-auto bg-primary  footer1 "><p>---------Designed And developed by Sachin Gawade-----------</span></p></footer>


<script src="bootstrap.bundle.min.js"></script>

</body>

</html>