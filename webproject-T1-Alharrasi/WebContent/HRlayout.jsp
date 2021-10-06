<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- Bootstrap core JavaScript-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Page level plugin JavaScript-->
<script
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>


<script type="text/javascript" src="HRApp.js"></script>

<style type="text/css">
</style>

<title>Insert title here</title>
</head>
<body>


	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		}

		if (session.getAttribute("hr") == null && session.getAttribute("username") != null) {
			response.sendRedirect("layout.jsp");
		}
	%>


	<div class="container">
		<h2>HR layout</h2>
		<p>To make the tabs toggleable, add the data-toggle="tab"
			attribute to each link. Then add a .tab-pane class with a unique ID
			for every tab and wrap them inside a div element with class
			.tab-content.</p>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#menu1">Settings</a></li>
			<li><a data-toggle="tab" href="#menu2">Add Employee</a></li>
			<li><a data-toggle="tab" href="#menu3" >Remove Employee</a></li>

			<li>
				<form action="Logout">
					<button type="submit">Logout</button>
				</form>
			</li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>HOME</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>Menu 1</h3>

				<ul class="list-group">
					<li class="list-group-item">First item
						<button type="button" name="button">show</button>
					</li>
					<li class="list-group-item">Second item</li>
					<li class="list-group-item">Third item</li>
				</ul>

			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>Add Employee</h3>
				<form class="form-horizontal" action="AddEmployee" method="post">



					<div class="form-group">
						<label for="user">Username : </label> <input type="text"
							class="form-control" name="Username"> <br> <label
							for="Fname">First Name : </label> <input type="text"
							class="form-control" name="Fname"> <br> <label
							for="Lname">Last Name : </label> <input type="text"
							class="form-control" name="Lname"> <br> <label
							for="JobRole">Job Role : </label> <input type="text"
							class="form-control" name="JRole"> <br> <label
							for="DoB">DoB : </label> <input type="date" class="form-control"
							name="DoB"> <br> <label for="email">Email :
						</label> <input type="email" class="form-control" name="Email"> <br>
						<button type="submit">Add Employee</button>
					</div>
				</form>
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>Change Password</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi
					architecto beatae vitae dicta sunt explicabo.</p>
				
				<script>
				fetchEmployees();
				</script>
				
				<div id="add_to_me"></div>

				<table id="myTable"
					class="table table-striped table-bordered table-sm" cellspacing="0"
					width="100%">
					<thead>
						<tr>
							<th class="th-sm">Name</th>
							<th class="th-sm">Position</th>
							<th class="th-sm">Office</th>
							<th class="th-sm">Age</th>
							<th class="th-sm">Start date</th>
							<th class="th-sm">Salary</th>
							<th class="th-sm">Remove/Edit</th>

						</tr>
					</thead>

					<tbody>
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>61</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>
						
						<tr>
							<td>Tiger Nixon</td>
							<td>System Architect</td>
							<td>Edinburgh</td>
							<td>71</td>
							<td>2011/04/25</td>
							<td>$320,800</td>
							<td><span class="table-remove"><button
										type="button" class="btn btn-danger btn-rounded btn-sm my-0">
										Remove</button></span> <span class="table-remove"><button
										type="button" class="btn btn-warning btn-rounded btn-sm my-0">
										Edit</button></span></td>
						</tr>

					</tbody>
				</table>



				<script>
					$(document).ready(function() {
						$('#myTable').dataTable();
					});
				</script>

			</div>
		</div>
	</div>
</body>
</html>