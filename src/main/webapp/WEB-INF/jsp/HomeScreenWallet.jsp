
<!------ Include the above in your HEAD tag ---------->

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

        <title>HomeScreenWallet</title>

         <!-- Bootstrap CSS CDN -->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Our Custom CSS -->
    
<head>
<link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


</style>
<script>
$(document).ready(function () {

    $("#sidebar").mCustomScrollbar({
        theme: "minimal"
    });

    // when opening the sidebar
    $('#sidebarCollapse').on('click', function () {
        // open sidebar
        $('#sidebar').addClass('active');
        // fade in the overlay
        $('.overlay').fadeIn();
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });

   
    // if dismiss or overlay was clicked
    $('#dismiss, .overlay').on('click', function () {
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
		<div style="margin-top: 60px;" class="row col-md-6 col-md-offset-1">
			<div class="panel">
				<div class="panel-heading text-center custom-header-panel1">Wallet
					Balance</div>
				<div class="panel-body">


					<div class="col-md-8 col-md-offset-2">
						<div class="panel panel-default">
							<div style="background: #F5F5F5;" class="panel-body">
								<div class="col-md-12">

									<div class="col-md-4">
										<img id="image" src="${images}/payment-method.png"
											alt="Random Name" width="80" height="80">
									</div>
									<div class="col-md-8">
										<h5 class="text-center">
											<strong>Current Balance</strong>
										</h5>
										<p class="text-center">
										<p class="text-center"><strong> <%out.print(session.getAttribute("CURWALLETBALANCE"));%></strong></p>
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel">
				<div class="panel-heading text-center custom-header-panel1">Transaction
					History</div>
				<div class="panel-body">
					<table id="example"
						class="table table-striped table-bordered hover">
						<thead>
							<%
								int counter = 1;
							%>

							<tr class="fontsizetable">
								<th class="text-center">Srl.</th>
								<th class="text-center">WalletID</th>
								<th class="text-center">Doc Type</th>
								<th class="text-center">Amount</th>
								<th class="text-center">Date</th>
								<th class="text-center">Narration</th>


							</tr>
						</thead>

						<c:forEach var="boo" items="${oKycForm.transctionHistoryList}">
							<tr>
								<td align="center"><%=counter++%></td>
								<td align="center"><c:out value="${boo.walletID}" /></td>
								<td align="center"><c:out value="${boo.docType}" /></td>
								<td align="right"><c:out value="${boo.trnamt1}" /></td>
								<td align="center"><c:out value="${boo.trandat}" /></td>
								<td align="center"><c:out value="${boo.narration}" /></td>

							</tr>
						</c:forEach>
					</table>
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

