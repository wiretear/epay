
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/images" var="dbimages" />
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<spring:url value="/resources/core/css/nav.css" var="navcss" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />
<link href="${css}" rel="stylesheet" type="text/css" media="all" />
<link href="${navcss}" rel="stylesheet" type="text/css" media="all" />
<%
	String sCusCode = (String) session.getAttribute("CUSCODE");
%>

<title>Password Recovery</title>

<!-- Bootstrap CSS CDN -->
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />


<!------ Include the above in your HEAD tag ---------->
<head>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="http://1000hz.github.io/bootstrap-validator/dist/validator.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>

<style>
/*
    DEMO STYLE
*/
@import
	"https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";

body {
	font-family: 'Poppins', sans-serif;
	background: #F7F9FA;
}

#sidebar .sidebar-header {
	padding: 20px;
	background: #6d7fcc;
}

.title {
	font-family: Verdana;
	font-weight: 600;
	font-size: 60px;
	color: #ffffff;
	text-align: center;
}

.subtitle {
	font-family: Verdana;
	font-size: 15px;
	font-color: black;
}

p {
	font-family: 'Poppins', sans-serif;
	font-size: 1.1em;
	font-weight: 300;
	line-height: 1.7em;
	color: #999;
}

a, a:hover, a:focus {
	color: inherit;
	text-decoration: none;
	transition: all 0.3s;
}

.line {
	width: 100%;
	border-bottom: 1px dashed #ddd;
}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
.wrapper {
	display: flex;
	align-items: stretch;
}

#sidebar {
	min-width: 250px;
	max-width: 250px;
	background: #021b52;
	min-height: 90vh;
}

#sidebar.active {
	margin-left: -250px;
}

#sidebar .sidebar-header {
	background: #14264E;
}

#sidebar ul p {
	color: #fff;
	padding: 10px;
}

#sidebar ul li a {
	color: white !important;
	font-family: 'Montserrat';
	font-weight: bold;
	font-size: 14px;
	display: block;
}

#sidebar ul li a:hover {
	color: #14264E;
	background: #071638;
}

#sidebar ul li.active>a, a[aria-expanded="true"] {
	color: white !important;
	font-family: 'Montserrat';
	font-weight: bold;
	font-size: 13px;
	background: #14264E;
}

a[data-toggle="collapse"] {
	position: relative;
}

a[aria-expanded="false"]::before, a[aria-expanded="true"]::before {
	content: '\e259';
	display: block;
	position: absolute;
	right: 20px;
	font-family: 'Glyphicons Halflings';
	font-size: 0.6em;
}

a[aria-expanded="true"]::before {
	content: '\e260';
}

ul ul a {
	font-size: 0.9em !important;
	padding-left: 30px !important;
	background: #14264E;
}

ul.CTAs {
	padding: 20px;
}

ul.CTAs a {
	text-align: center;
	font-size: 0.9em !important;
	display: block;
	border-radius: 5px;
	margin-bottom: 5px;
}

a.download {
	background: #fff;
	color: #7386D5;
}

a.article, a.article:hover {
	background: #6d7fcc !important;
	color: #fff !important;
}

.white {
	color: white;
}

/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
	padding: 20px;
	transition: all 0.3s;
}
p {
  font-size: 2vmin;
}
/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media ( max-width : 768px) {
	#sidebar {
		margin-left: -250px;
	}
	#sidebar.active {
		margin-left: 0;
	}
	#sidebarCollapse span {
		display: none;
	}
}

.custom-header-panel1 {
	background-color: #021b52 !important;
	border-color: #021b52 !important;
	color: white;
}

.btn-primary {
	color: #fff;
	background-color: #021c52;
	border-color: #0a1b3e;
}
</style>
<script>
	$(document).ready(function() {

		$("#sidebar").mCustomScrollbar({
			theme : "minimal"
		});

		// when opening the sidebar
		$('#sidebarCollapse').on('click', function() {
			// open sidebar
			$('#sidebar').addClass('active');
			// fade in the overlay
			$('.overlay').fadeIn();
			$('.collapse.in').toggleClass('in');
			$('a[aria-expanded=true]').attr('aria-expanded', 'false');
		});

		// if dismiss or overlay was clicked
		$('#dismiss, .overlay').on('click', function() {
			// hide the sidebar
			$('#sidebar').removeClass('active');
			// fade out the overlay
			$('.overlay').fadeOut();
		});
	});
</script>
</head>
<body>
	<jsp:include page="../fragments/nav.jsp" />


	<div class="wrapper">
		<!-- Sidebar Holder -->
		<jsp:include page="../fragments/SideNav.jsp" />

		<!-- Page Content Holder -->

		<div class="container-fluid ">

			<div style="margin-top: 70px;" class="col-md-12">
				<div style="color: red;" class="col-md-6 text center"></div>

				<div style="color: red;" class="col-md-6 text center">
					<strong>
						<%
							out.print(session.getAttribute("PasswordRecovery"));
						%>
					</strong>
				</div>
			</div>
			<div class="col-md-8 col-md-offset-1">
				<div class="panel">
					<div class="panel-heading text-center custom-header-panel">Add password recovery number</div>
					<div class="panel-body">
						<form:form method="post" data-toggle="validator" role="form"
							modelAttribute="oWalletOpenForm" name="oWalletOpenForm"
							action="/erapay/executewallet">
							<div class="col-md-12">

								<br>
								<p>Add your close friends and family from whom you can get security code.</p>
								<hr>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" for="first_name">Full Name</label> <input
										type="text" data-minlength="4" class="form-control"
										name="password" id="inputPassword" placeholder="Password">
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" for="first_name">Mobile No:</label> <input
										type="password"  class="form-control"
										name="inputPassword" id="inputPassword" placeholder="New PIN">
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" for="first_name">Relationship</label>
								<select class="form-control" id="sel1">
    <option>Select Relationship</option>
       <option>Father</option>
    <option>Mother</option>
    <option>Brother</option>
    <option>Sister</option>
      <option>Daughter</option>
    <option>Son</option>
     <option>Friend</option>
    <option>Spouse</option>
    <option>Other</option>
  </select>
								</div>
							</div>


							<div class="row">
								<div class="col-sm-4 col-sm-offset-4">
									<input type="submit" name="login-submit" id="login-submit"
										tabindex="4" class="form-control btn btn-primary"
										value="Confirm">
								</div>

							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- jQuery CDN -->
	<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
	<!-- Bootstrap Js CDN -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#sidebarCollapse').on('click', function() {
				$('#sidebar').toggleClass('active');
			});
		});
	</script>
</body>
</html>

