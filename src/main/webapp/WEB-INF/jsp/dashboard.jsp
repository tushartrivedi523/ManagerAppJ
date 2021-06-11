<%@page import="com.nagarro.HrMangeApplicationJenkins.datastore.EmpDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.HttpSession,
    								  java.util.ArrayList"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css" integrity="undefined" crossorigin="anonymous">
    
    <title>Dashboard</title>
  </head>
  <body>
    
    <div class="" style="display:flex; justify-content:flex-end; padding:20px">
    	<h6 class="m-2"> Welcome <%=session.getAttribute("name") %></h6>
    	<form action="logout" method="post">
		     <button type="submit" class="btn btn-sm btn-danger mt-1">Logout</button>
		 </form>
    </div>
    <div class="container">
    	<h3 class="mt-4"style="text-align:center"><u><b>Employees Listing</b></u></h3>
    	<div style="display:flex; justify-content:center">
	    	<form class="mt-5 text-center" action="uploadPage" method="post">
				<input class="btn btn-warning" type="submit" value="Upload Employee Details">
			</form>
			<form class="mt-5 text-center" action="fetchData" method="get">
				<input style="margin-left:5px;"class="btn btn-primary" type="submit" value="Download Employee Details">
			</form>
		</div>
	    <table class="table mt-2 mb-4 table table-hover table-striped table-bordered">
		  <thead>
		    <tr>
		      <th scope="col" style="text-align:center">Emp Code</th>
		      <th scope="col" style="text-align:center">Employee Name</th>
		      <th scope="col" style="text-align:center">Location</th>
		      <th scope="col" style="text-align:center">Email</th>
		      <th scope="col" style="text-align:center">Date Of Birth(yyyy-MM-dd)</th>
		      <th scope="col" style="text-align:center">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%
		  		int i=1;
				ArrayList<EmpDetails> employees = (ArrayList<EmpDetails>)request.getAttribute("employees");
		  %>
		  <%
		  	if(request.getAttribute("employees")==null)
		  	{
		  		%>
		  	<!--  <tr rowspan="7"><h4 class="container mt-5" style="text-align:center;color:red">No Employee Enrolled</h4></tr> -->
		  	<% }
		  	else
		  	{
		  	
		  		for(EmpDetails employee : employees)
		  		{
		  			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String dateAsString = df.format(employee.getEmpDob());
					String dateFormatSplit[] = dateAsString.split(" ");
		  			
		  %>
		    <tr>
		      <td style="text-align:center"><%= (int)employee.getEmpId() %></td>
		      <td style="text-align:center"><%= employee.getEmpName() %></td>
		      <td style="text-align:center"><%= employee.getEmpLoc() %></td>
		      <td style="text-align:center"><%= employee.getEmpEmail() %></td>
		      <td style="text-align:center"><%= dateFormatSplit[0] %></td>
		      <td style="text-align:center">
		      <form action="editPage?empId=<%=(int)employee.getEmpId()%>" method="post">
		      <button type="submit" class="btn btn-dark">Edit</button>
		      </form>
		      </td>
		    </tr>
		   <%}
		  		}%>
		  </tbody>
		</table>
    </div>
    
    
   

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    -->
  </body>
</html>