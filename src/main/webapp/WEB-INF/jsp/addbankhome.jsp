
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
	<title>Add Bank</title>

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
	function callpage() {
		if (document.getElementById("login-submit")) {
			$('#myModal').modal('show');
		}
	}

	function openwindow() {
		winURL = "walletsearch";
		winName = "walletsearch";
		winHeight = 380;
		winWidth = 600;
		winHeight = 380;
		winWidth = 600;
		winTop = ((screen.availHeight / 2) - (winHeight / 2));
		winLeft = ((screen.availWidth / 2) - (winWidth / 2));
		winOpen = "";
		if (winOpen) {
			if (winOpen.closed) {
				winOpen = window
						.open(
								winURL,
								winName,
								"top="
										+ winTop
										+ ",left="
										+ winLeft
										+ ",width="
										+ winWidth
										+ ",height="
										+ winHeight
										+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			} else {
				winOpen.close();
				winOpen = window
						.open(
								winURL,
								winName,
								"top="
										+ winTop
										+ ",left="
										+ winLeft
										+ ",width="
										+ winWidth
										+ ",height="
										+ winHeight
										+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			}
		} else {
			winOpen = window
					.open(
							winURL,
							winName,
							"top="
									+ winTop
									+ ",left="
									+ winLeft
									+ ",width="
									+ winWidth
									+ ",height="
									+ winHeight
									+ ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
		}
		winOpen.focus();
	}
</script>
</head>

</head>
<body>
	<jsp:include page="../fragments/nav.jsp" />
	<div class="wrapper">
		<jsp:include page="../fragments/SideNav.jsp" />

		<div class="container ">
			<div style="margin-top: 80px;" class="row col-md-10 col-md-offset-1">

				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<b>Add bank account as fund source</b>
					</div>
					<div class="panel-body">
						<div class="col-md-12">
							<div class="col-md-3">
								<img src="${images}/bank-building (1).png" />
							</div>

							<div style="margin-top: 50px;" class="col-md-9">


								<button onclick="window.location.href='/erapay/addbankaccount'"
									class="btn btn-success ">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
									ADD BANK ACCOUNT
								</button>
							</div>
						</div>


					</div>
				</div>
			</div>
			<div class="col-md-10 col-md-offset-1">

				<div class="panel panel-default ">
					<div class="panel-heading">
						<b>Instruction</b>
					</div>
					<div class="panel-body">
						<div class="col-md-12">
							<div class="collapse-group">
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse1">Add Bank</a>
											</h4>
										</div>
										<div id="collapse1" class="panel-collapse collapse">
											<div class="panel-body">Click on Add Bank Account
												button and provide the details of the bank account that you
												want to link to iPay The entered bank account should be
												registered in your name for ensuring the security of your
												account</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse2">ePay Sends
													You a Random Verification Amount</a>
											</h4>
										</div>
										<div id="collapse2" class="panel-collapse collapse">
											<div class="panel-body">1. A token amount will be sent
												to the bank account that you added for bank verification
												purpose. It may take 3-5 business days to send the
												verification amount. 2. You will be notified by iPay when
												the verification amount is transferred to your bank account.
												Your bank account will be shown in pending state while the
												verification is being processed</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse3">Insert
													Verification Amount</a>
											</h4>
										</div>
										<div id="collapse3" class="panel-collapse collapse">
											<div class="panel-body">1. Contact your bank to know
												the exact value of the random verification amount which had
												been sent to your account. 2. Click on the pending bank
												account then click on the Verify Bank button at the end of
												the box. 3. A Confirm Bank Verification pop up window will
												appear. Enter the exact token amount and click on Submit
												button. Confirm the bank verification amount only when you
												know the exact amount. The bank account may be blocked from
												being linked to iPay if you provide 5 wrong inputs.</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" href="#collapse4"> Bank
													Verification Complete</a>
											</h4>
										</div>
										<div id="collapse4" class="panel-collapse collapse">
											<div class="panel-body">Your bank account is linked and
												verified when you submit the correct verification amount.
												You will see a verified status beside your bank and can add
												or withdraw money between your iPay account and verified
												bank account. Add and Withdraw money transactions may take
												3-5 business days depending on the standard banking
												procedures</div>
										</div>
									</div>
								</div>
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

