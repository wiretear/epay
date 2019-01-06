		<head>
<title>User Profile</title>
<meta charset="utf-8">
<script src="${date1}"></script>
<script src="${date2}"></script>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${designCss}" rel="stylesheet" />
<link href="${datecss}" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script language="JavaScript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
	<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script>
	function doSelect(a,b,c,d) {
		opener.document.LoadFundForm.bankName.value = a;
		opener.document.LoadFundForm.branchName.value = b;
		opener.document.LoadFundForm.bankAccount.value =c;
		opener.document.LoadFundForm.accountTittle.value = d;
		//opener.document.frm.menuDescription.value = b;
		/*  oMenuGenarationForm.groupId.value=a;
		  alert(oMenuGenarationForm.groupId.value);
		  window.oMenuGenarationForm.groupId.value;*/
		window.close();
	}
	</script>
	<style type="text/css">
	.tablefont{ font-size: 12px;
	}
	</style>
	</head>
		<div class="mainbox col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-5 row">
		<form:form name="frm">
		

		<table  id="example" class="table table-striped table-bordered hover">
		
<thead>
			<tr class="fontsizetable">
			    <th>Bank Name </th>
				<th>Branch Name</th>
				<th>Account No</th>
				<th>Account Title</th>
				<th>Select</th>
			</tr>
			</thead>
				<c:forEach var="bo" items="${oLoadFundForm.bankSearchList}" >
				<tr>
					<td class="tablefont"><c:out value="${bo.bankName}"/></td>
					<td class="tablefont"><c:out value="${bo.branchName}"/></td>
					<td class="tablefont"><c:out value="${bo.bankAccount}" /></td>
					<td class="tablefont"><c:out value="${bo.accountTittle}" /></td>
					<td class="tablefont"><a  href="#" onclick="doSelect('${bo.bankName}','${bo.branchName}','${bo.bankAccount}','${bo.accountTittle}')">Select
					</a></td>
				</tr>
			</c:forEach>
		</table>
		</form:form>
	
	</div>
		