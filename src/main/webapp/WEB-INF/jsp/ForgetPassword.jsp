<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13-Dec-18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/img" var="images" />
    <spring:url value="/qrcode" var="qrcode"/>
    <spring:url value="/images" var="dbimages" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
    <spring:url value="/core/css/wallettowallet.css" var="css" />
    <spring:url value="/core/css/nav.css" var="navcss" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <spring:url value="/img" var="images" />
    <%String sCusCode = (String) session.getAttribute("CUSCODE");%>
    <title>Bank Account To Wallet</title>

    <!-- Bootstrap CSS CDN -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="/erapay/index">
                <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:60%;"/>
            </a>
        </div>


        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">s
        </div>
    </div>
</nav>
<div class="form-gap"></div>
<div style="margin-top: 70px;" class="col-md-12">
    <div style="color: red;" class="col-md-5 text center"></div>

    <div style="color: red;" class="col-md-6 text center">
        <strong>
            <%
                out.print(session.getAttribute("FORGETPASSWORDMESSAGE"));
            %>
        </strong>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center">Forgot Password?</h2>
                        <p>You can reset your password here.</p>
                        <div class="panel-body">

    <form:form method="post" modelAttribute="oForgetPasswordForm"
           name="oForgetPasswordForm" action="/erapay/resetpassword">

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input id="email" name="email" placeholder="Email Address" class="form-control"   required type="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                </div>

                                <input type="hidden" class="hide" name="token" id="token" value="">
     </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
