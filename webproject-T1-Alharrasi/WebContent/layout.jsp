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
	<script type="text/javascript" src="HRApp.js"></script>
<title>Insert title here</title>
</head>
<body>
${wronginput}

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		}
		if (session.getAttribute("hr") != null && session.getAttribute("username") != null)
		{
			response.sendRedirect("HRlayout.jsp");
		}
		
		
	%>

	<div class="container">
		<h2>Employee layout</h2>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#menu1">Punch Hours</a></li>
			<li><a data-toggle="tab" href="#menu2">Show Hours</a></li>
			<li><a data-toggle="tab" href="#menu3">Change Password</a></li>

			<li>
				<form action="Logout">
					<button type="submit">Logout</button>
				</form>
			</li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>HOME</h3>
				<p>Welcome back ${user}.</p>
			</div>
			<div id="menu1" class="tab-pane fade">
				<br>
				<a class="btn btn-warning btn-rounded btn-sm my-0" href="/webproject-T1-Alharrasi/Attend"> Punch Hour </a>
			</div>
			<div id="menu2" class="tab-pane fade">
				
				<button onclick="getHours()">Refresh</button>
				<br><br>
				<div id="add_to_me"></div>
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>Change Password</h3>

				<div class="container">
					
					<form action="ChangePass" method="post">
						
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="pass"
								placeholder="Password">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="confirm"
								placeholder="Confirm Password">
						</div>
						<br>
						<div class="input-group">
							<input type="submit" value="Change Password">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	
</body>
</html>