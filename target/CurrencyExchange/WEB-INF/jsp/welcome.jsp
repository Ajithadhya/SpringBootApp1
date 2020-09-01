<!DOCTYPE html >

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>HomePage | home</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link href="${path}static/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">HomePage</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${path}/login">Login</a></li>
					<li><a href="${path}/newregister">Registration</a></li>
					<li><a href="/admin">Admin</a></li>
					<!--		     <li><a href="/show-users">All Request</a></li>-->
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Foreign Currency Exchange Service</h1>
					<h3>Start to Exchange your currency With CurrencyExchangeService</h3>
					<a href="${path}/Start Exchange"><h2>Login
							Page</h2></a>
				</div>
			</div>

		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>New Request</h3>
				<hr>
				<a href="${path}/ShowRequest"><h2>Click Here!!To see all
						the request</h2></a>
				<form class="form-horizontal" method="POST" action="save-user">
				<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<input type="hidden" name="id" value="${exchangevalue.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${exchangevalue.name }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">ContactNumber</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="contactnumber"
								value="${exchangevalue.contactnumber }" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Airport </label>
						<div class="col-md-7">
							<select class="form-control" name="airport"
								value="${exchangevalue.airport}"><option value="5">Select
									your location</option>
								<option>Hartsfield Jackson Atlanta International
									Airport</option>
								<option>Los Angeles International Airport</option>
								<option>Hare International Airport</option>
								<option>Dallas/Fort Worth International Airport</option>
								<option>Denver International Airport</option>

							</select>
							<!--  <input type="text" class="form-control" name="airport"
								value="${exchangevalue.airport }" />-->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Currency_From</label>
						<div class="col-md-7">
							<select class="form-control" name="from"
								value="${exchangevalue.from}"}><option value="3">Select
									the Currency</option>
								<option>USD</option>
								<option>AUD</option>
								<option>INR</option>
							</select>
							<!--							<input type="text" class="form-control" name="from"
								value="${exchangevalue.from }" /> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Currency_To </label>
						<div class="col-md-7">
							<select class="form-control" name="to"
								value="${exchangevalue.to}"}><option value="3">Select
									the Currency</option>
								<option>USD</option>
								<option>AUD</option>
								<option>INR</option>
							</select>
							<!--  						<input type="text" class="form-control" name="to"
								value="${exchangevalue.to }" />-->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Deadline</label>
						<div class="col-md-5">
							<select class="form-control" name="deadline"
								value="${exchangevalue.deadline}"}><option value="3">Select
									your deadline</option>
								<option>1 Hrs</option>
								<option>2 Hrs</option>
								<option>3 Hrs</option>
							</select>
							<!--  							<input type="text" class="form-control" name="deadline"
								value="${exchangevalue.deadline}" />-->
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_REQUESTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Requests</h3>
				<hr>
				<div class="col-sm-5">
					<form th:action="@{${path}/show-users}" method="get">
						Enter Your Location: <input type="text" name="keyword" /> &nbsp;
						<input type="submit" value="search" /> &nbsp;
				</div>
				</form>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								
								<th>Name</th>
								<th>ContactNumber</th>
								<th>Airport</th>
								<th>From</th>
								<th>To</th>
								<th>RegisteredTime</th>
								<th>DeadLine</th>
								
								<!--  	<th>Delete</th> -->
							</tr>

						</thead>


						<tbody>
							<c:forEach var="exchangevalue" items="${exchangevalues}">
								<tr>
									<td>${exchangevalue.name}</td>
									<td>${exchangevalue.contactnumber}</td>
									<td>${exchangevalue.airport}</td>
									<td>${exchangevalue.from}</td>
									<td>${exchangevalue.to}</td>
									<td>${exchangevalue.estimatedTravelTime}</td>
									<td>${exchangevalue.deadline}</td>
									

									<!--	<td><a href="${path}/delete-user?id=${exchangevalue.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>-->
								</tr>
							</c:forEach>
							<a href="${path}/show-request"><h2>To Post a Request</h2></a>
						</tbody>
					</table>
					<a href="${path}/welcome"><h2>Logout</h2></a>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='ADMIN_ALL_REQUESTS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Requests</h3>
				<hr>
				<div class="col-sm-5">
					<form th:action="@{${path}/admin}" method="get">
						Enter Your Location: <input type="text" name="keyword" /> &nbsp;
						<input type="submit" value="search" /> &nbsp;
				</div>
				</form>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>ContactNumber</th>
								<th>Airport</th>
								<th>From</th>
								<th>To</th>
								<th>RegisteredTime</th>
								<th>DeadLine</th>
								<th>Delete</th>
							</tr>

						</thead>


						<tbody>
							<c:forEach var="exchangevalue" items="${exchangevalues}">
								<tr>
									<td>${exchangevalue.id}</td>
									<td>${exchangevalue.name}</td>
									<td>${exchangevalue.contactnumber}</td>
									<td>${exchangevalue.airport}</td>
									<td>${exchangevalue.from}</td>
									<td>${exchangevalue.to}</td>
									<td>${exchangevalue.estimatedTravelTime}</td>
									<td>${exchangevalue.deadline}</td>

									<td><a href="${path}/delete-user?id=${exchangevalue.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="${path}/welcome"><h2>Logout</h2></a>
				</div>
			</div>
		</c:when>


		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update Request</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${exchangevalue.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${exchangevalue.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">ContactNumber</label>
						<div class="col-md-7">
							<input type="number" class="form-control" name="contactnumber"
								value="${exchangevalue.contactnumber }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Airport </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="airport"
								value="${exchangevalue.airport }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Currency_From</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="from"
								value="${exchangevalue.from }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Currency_To </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="to"
								value="${exchangevalue.to }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Deadline</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="deadline"
								value="${exchangevalue.deadline}" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEWREGISTER' }">
			<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-user1">
				<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								value="${user.email }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${exchangevalue.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${exchangevalue.password }" />
						</div>
					</div>
					<a href="${path}/New User"><h2>SignUp</h2></a>
                   
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ADMIN_LOGIN' }">
			<div class="container text-center">
				<h3>Admin Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-admin">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${exchangevalue.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${exchangevalue.password }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>