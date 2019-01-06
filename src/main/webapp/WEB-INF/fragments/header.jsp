<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>Spring MVC First Project</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/usershome" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />
<spring:url value="/users" var="urlLogout" />
<spring:url value="/users/emailfrom" var="emailFrom" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home</a>
		</div>
		<div class="navbar-header navbar-right">
			<a class="navbar-brand" href="${urlLogout}">Logout</a>
		</div>
		<div class="navbar-header navbar-right">
			<a class="navbar-brand" href="${emailFrom}">Send Mail</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav ">
				<li class="active"><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>
	</div>
</nav>