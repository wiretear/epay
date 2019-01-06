
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%
	String sCusCode = (String) session.getAttribute("CUSCODE");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/core/css/wallettowallet.css" var="css" />
<spring:url value="/core/css/nav.css" var="navcss" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/img" var="images" />
<spring:url value="/images" var="dbimages" />

<link href="${css}" rel="stylesheet" type="text/css" media="all" />
<link href="${navcss}" rel="stylesheet" type="text/css" media="all" />
<title>Payment Method</title>
<!-- Bootstrap CSS CDN -->
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Our Custom CSS -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<style>
a:hover { 
    background-color: yellow;
}

</style>
</head>
<body>
	<jsp:include page="../fragments/nav.jsp" />
	<div class="wrapper">
		<jsp:include page="../fragments/SideNav.jsp" />

		<div class="container ">
		<div style="margin-top: 80px;" class="row col-md-10 col-md-offset-1">

				<div class="panel">
					<div class="panel-heading text-center custom-header-panel">
						<b>Choose Your Payment Method</b>
					</div>
					<div  style="background-color:#e5e5e5"class="panel-body">

				        <div class="row">

						

							<div class="col-sm-6 form-group">
							    <a href="/erapay/excutepaymentmethodthroughbank">
							        <div class="btn btn-payment-default btn-block">
										<img src="${images}/paymentbank.jpg" width="100%"/>
							        </div>
							    </a>
							</div>

							<div class="col-sm-6 form-group">
								<a  href="/erapay/executewallettomerchanpaymenttest">
								    <div class="btn btn-payment-default btn-block">
										<img src="${images}/era_pay_logo.jpg" width="90%"/>
								    </div>
							    </a>
							</div>
			</div>
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

