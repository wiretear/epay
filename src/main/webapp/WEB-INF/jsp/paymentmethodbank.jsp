
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%
	String sCusCode = (String) session.getAttribute("CUSCODE");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/core/css/wallettowallet.css" var="css" />
<spring:url value="/core/css/nav.css" var="navcss" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/images" var="dbimages" />
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${css}" rel="stylesheet" type="text/css" media="all" />
<link href="${navcss}" rel="stylesheet" type="text/css" media="all" />
<title>Send Money</title>

<!-- Bootstrap CSS CDN -->
<style>
thead {
	background-color: #204D79;
	color: white;
}

th {
	font-family: "Trebuchet MS", Arial, Verdana;
	font-size: 14px;
}
tr {
	font-family: "Trebuchet MS", Arial, Verdana;
	font-size: 14px;
}
.modal {
	overflow: visible !important;
}
</style>
<script>
	var bankName;
	var branchName;
	var accountNo;
	var accountTitle;
	function bankvalue(v1, v2, v3, v4) {
		bankName = v1;
		branchName = v2;
		accountNo = v3;
		accountTitle = v4;
		alert(accountNo);
	}
	function searchViaAjax() {
		var search = {
			"bankName" : "bhanu",
			"branchName" : "prasad",
			"accountNo" : "bhanu",
			"accountTitle" : "prasad"
		}
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/executejs",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});
	}
	// window.opener.document.a.
	//alert(v1 + "==" + v2);
	//	window.document.getElementByName('groupDescription').value = v1;
	//   window.document.getElementByName('GroupId').value = v2;
	// alert(v2);
	/*var data = {
	 "bankName" : "bhanu",
	 "branchName" :"prasad",
	 "accountNo" : "bhanu",
	 "accountTitle" :"prasad"
	 }
	 $.ajax({
	 type: "POST",
	 url: "execute",    
	 data: JSON.stringify(data),
	 dataType: 'json',
	 success: function (data) {
	 console.log('done');
	 },
	 error: function(xhr, textStatus, error){
	 console.log(xhr.statusText);
	 console.log(textStatus);
	 console.log(error);
	 }
	 });
	 }
	 */

	function bankvaluesubmit() {
		window.location = "/erapay/execute?bankName=" + bankName
				+ "&branchName=" + branchName + "&accountNo=" + accountNo
				+ "&accountTitle=" + accountTitle;
		alert(accountNo);
	}
	
	function bankvaluesubmit1() {
		window.location = "/erapay/execute?bankName=" + bankName
				+ "&branchName=" + branchName + "&accountNo=" + accountNo
				+ "&accountTitle=" + accountTitle;
	}
</script>
</head>
<body>
	<jsp:include page="../fragments/nav.jsp" />
	<div class="wrapper">
		<jsp:include page="../fragments/SideNav.jsp" />

		<div class="container ">
			<div style="margin-top: 80px;" class="row col-md-10 col-md-offset-1">
				<form:form name="frm">
					<table id="example"
						class="table table-striped table-bordered hover">
						<thead>
							<tr class="fontsizetable">
								<th>Bank Name</th>
								<th>Branch Name</th>
								<th>Account No</th>
								<th>Account Title</th>
								<th>Payment</th>
							</tr>
						</thead>
						<c:forEach var="bo" items="${oLoadFundForm.bankSearchList}">
							<tr>
								<td class="tablefont"><c:out value="${bo.bankName}" /></td>
								<td class="tablefont"><c:out value="${bo.branchName}" /></td>
								<td class="tablefont"><c:out value="${bo.bankAccount}" /></td>
								<td class="tablefont"><c:out value="${bo.accountTittle}" /></td>

								<td>
									<button type="button" class="btn btn-info btn-lg"
										onclick="bankvalue('${bo.bankName}','${bo.branchName}','${bo.bankAccount}','${bo.accountTittle}')"
										data-toggle="modal" data-target="#myModal">Payment</button>

								</td>
							
							</tr>
						</c:forEach>
					</table>
					<div id="myModal" data-keyboard="false" data-backdrop="static"
						class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header custom-header-panel1">

									<h4 class="modal-title text-center">Confirm OTP</h4>
								</div>
								<div class="modal-body">

									<div class="container">
										<div class="row">
											<div class="col-sm-6">
												<br> <img
													src="https://cdn2.iconfinder.com/data/icons/luchesa-part-3/128/SMS-512.png"
													class="img-responsive"
													style="width: 150px; height: 150px; margin: 0 auto;"><br>
												<h5 class="text-center">An OTP has been sent to your
													Mobile Number.</h5>
												<br>

												<div style="margin-top: 5px;" class="col-sm-12">
													<div class="form-group col-sm-2"></div>
													<div class="form-group col-sm-8">
														<h5 class="pull-left">OTP:</h5>
														<span style="color: red;"></span> <input type="text"
															class="form-control" name="otp"
															placeholder="Enter your OTP number" required="">
													</div>
												</div>
												<br> <br>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-3"></div>
										<div class="col-sm-3">
											<input type="submit" onclick="searchViaAjax()"
												name="otp-submit" id="otp-submit" tabindex="4"
												class="form-control btn btn-primary" value="Submit">
										</div>
										<div class="col-sm-3">
											<input type=" " name="login-submit" data-dismiss="modal"
												id="login-submit" tabindex="4"
												class="form-control btn btn-primary" value="Close">
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>


