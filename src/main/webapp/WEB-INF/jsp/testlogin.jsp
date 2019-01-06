<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
	<link rel="shortcut icon" href="http://sstatic.net/stackoverflow/img/favicon.ico">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/core/css/login.css" var="logincss" />
<spring:url value="/erapay/index" var="home" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>ERA Payment</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="${logincss}" rel="stylesheet" type="text/css" media="all" />

<script>
	$('.carousel').carousel()
	$(function() {

		$('#login-form-link').click(function(e) {
			$("#login-form").delay(100).fadeIn(100);
			$("#register-form").fadeOut(100);
			$('#register-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});
		$('#register-form-link').click(function(e) {
			$("#register-form").delay(100).fadeIn(100);
			$("#login-form").fadeOut(100);
			$('#login-form-link').removeClass('active');
			$(this).addClass('active');
			e.preventDefault();
		});

	});
</script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="50">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">

			<a class="navbar-brand text-center" href="${home}"> <img
				src="${images}/era.png" style="width: 35%;" /></a>

			<div class="collapse navbar-collapse" id="myNavbar"></div>
		</div>
	</nav>

	<div class="container">

		<div style="color: red;" class="col-md-12">
			<div class="col-md-2"></div>
			<div class="col-md-9 text-center">
				<strong class="">
					<%
						out.print(session.getAttribute("SignUpMessage"));
					%>
				</strong>
			</div>

		</div>

		<div class="col-md-5"></div>
		<div style="color: red;" class="col-md-7 pull-left">
			<strong>
				<%
					out.print(session.getAttribute("LoginMessage"));
				%>
			</strong>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-4 "></div>
							<div class="col-xs-4 ">
								<a href="#" class="active" id="login-form-link">LOG IN</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form method="post" modelAttribute="oKycForm" name="frm"
									action="/erapay/testlogin">
									<div class="form-group">
										<input type="text" id="name" name="mailId"
											class="form-control" required> <label
											class="form-control-placeholder" for="name">Email ID</label>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											class="form-control" required> <label
											class="form-control-placeholder" for="password">Password</label>
									</div>



									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember"
											id="remember"> <label for="remember">
											Remember Me</label>
									</div>

									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="/erapay/forgetpassword" tabindex="5"
														class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form:form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav
		class="footer-bottom navbar container-fluid  navbar-default navbar-fixed-bottom ">

		<div>
			<div class="container-fluid text-center ">
				<p style="color: white;">&copy;ERA InfoTech Limited 2010-2020</p>

			</div>
		</div>
	</nav>
</body>
</html>
