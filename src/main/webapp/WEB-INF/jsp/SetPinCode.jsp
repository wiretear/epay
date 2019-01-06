
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<spring:url value="/img" var="images" />
	<spring:url value="/images" var="dbimages" />
	<spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
	<spring:url value="/core/css/wallettowallet.css" var="css" />
	<spring:url value="/core/css/nav.css" var="navcss" />
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<spring:url value="/img" var="images" />

		<%String sCusCode = (String) session.getAttribute("CUSCODE");%>

	<title>SET PINCODE</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- Our Custom CSS -->

	<head>
		<link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
		<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
		<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
				<div style="color: red;" class="col-md-4 text center"></div>

				<div style="color: red;" class="col-md-6 text center">
					<strong>
						<%
							out.print(session.getAttribute("PINCODEMESSAGE"));
						%>
					</strong>
				</div>
			</div>
			<div class="col-md-8 col-md-offset-1">
				<div class="panel">
					<div class="panel-heading text-center custom-header-panel">Set
						Pin Code</div>
					<div class="panel-body">
						<form:form method="post" data-toggle="validator" role="form"
							modelAttribute="oPinCodeForm" name="oPinCodeForm"
							action="/erapay/executesetpincode">
							<div class="col-md-12">

								<br>
								<p class="text-center">Set the 4 digit PIN that you need for
									ePay transactions</p>
								<hr>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" for="first_name">Password</label> 	
									<form:input type="password" path="password"
													class="form-control"
													value="${oPinCodeForm.password}"
													placeholder="password" required="required"/>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" >New PIN</label> <form:input
										type="password"  path="newPin" data-minlength="4" class="form-control"
										 id="inputPassword" value="${oPinCodeForm.newPin}" placeholder="New PIN"  required="required"/>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3"></div>
								<div class="form-group col-md-6">
									<label class="text-center" for="first_name">Confirm PIN</label>
									<form:input type="password" class="form-control"
										path="confirmNewPin" id="inputPasswordConfirm" value="${oPinCodeForm.confirmNewPin}" data-match="#inputPassword"
										data-match-error="Pin don't match" placeholder="Confirm PIN"  required="required"/>
									<div class="help-block with-errors"></div>
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

