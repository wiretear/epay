<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/epay/nav.css" var="navcss" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%String requestcount = (String) session.getAttribute("RequestCount");%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NAV</title>
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>

</head>

<body>

<nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                         <a class="navbar-brand" href="/erapay/index">
               <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:50%;"/>
            </a>
                        </div>

						<li class="pull-left"><i id="sidebarCollapse" style="margin-left:55px;margin-top:15px; width:100px;" class="white glyphicon glyphicon-menu-hamburger"></i></li>
                    	<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">

					<li>
						<a href="/erapay/requestmoneyacknowledgement">Request Notification <span id="requestid" style='color: red'>(<%=requestcount%>)</span></a>
						<script>

                            var value = "<%=requestcount%>";
                            if (value == "0") {
                                document.getElementById("requestid").style.display = "none";
                            }

						</script>
					</li>
				<li><a href="/erapay/qrcode">QRScaner</a></li>
					<li>
						<a href="/erapay/loadfund">Add Money</a>
					</li>
					<li>
						<a href="/erapay/sendmoneyhome">Send Money</a>
					</li>
				</ul>
			</div>
		</div>
                </nav>
</body>
</html>