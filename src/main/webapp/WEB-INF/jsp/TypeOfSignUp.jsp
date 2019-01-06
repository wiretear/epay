<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18-Dec-18
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/source/images" var="images" />
<spring:url value="/source/css/main.css" var="css"/>
<spring:url value="/source/css/util.css" var="css1"/>
<spring:url value="/source/images/icons/favicon.ico" var="faviconcss"/>
<spring:url value="/source/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapmincss"/>
<spring:url value="/source/fonts/font-awesome-4.7.0/css/font-awesome.min.css" var="fontcss"/>
<spring:url value="/source/fonts/iconic/css/material-design-iconic-font.min.css" var="fontcss1"/>
<spring:url value="/source/vendor/animate/animate.css" var="animatecss"/>
<spring:url value="/source/vendor/css-hamburgers/hamburgers.min.css" var="hamburgerscss"/>
<spring:url value="/source/vendor/animsition/css/animsition.min.css" var="animsitioncss"/>
<spring:url value="/source/vendor/select2/select2.min.css" var="select2css"/>
<spring:url value="/source/vendor/daterangepicker/daterangepicker.css" var="daterangepickercss"/>

<spring:url value="/source/vendor/jquery/jquery-3.2.1.min.js" var="jqueryjs"/>
<spring:url value="/source/vendor/animsition/js/animsition.min.js" var="animsitionjs"/>
<spring:url value="/source/vendor/bootstrap/js/popper.js" var="poperjs"/>
<spring:url value="/source/vendor/bootstrap/js/bootstrap.min.js" var="bootstrapjs"/>
<spring:url value="/source/vendor/select2/select2.min.js" var="select2js"/>
<spring:url value="/source/vendor/daterangepicker/daterangepicker.js" var="daterangepickerjs"/>
<spring:url value="/source/vendor/daterangepicker/moment.min.js" var="momentjs"/>
<spring:url value="/source/vendor/countdowntime/countdowntime.js" var="countdowntimejs"/>
<spring:url value="/source/vendor/select2/select2.min.js" var="select2js"/>
<spring:url value="/source/js/main.js" var="mainjs"/>



<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
    <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${css1}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${faviconcss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${fontcss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${fontcss1}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${animatecss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${hamburgerscss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${animsitioncss}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${select2css}" rel="stylesheet" type="text/css" media="all"/>
    <link href="${daterangepickercss}" rel="stylesheet" type="text/css" media="all"/>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>



    function jump() {
        var selected = document.getElementsByName('radio');
        for(var i=0; i<selected.length; i++) {
            var value = selected[i].value;
            if (selected[i].checked) {
                if (value === 'signup') {
                    window.location = "/erapay/signup";
                } else {
                    window.location = "/erapay/businesssignup";

                }
            }
        }
    }
</script>
    <script src="${jqueryjs}"></script>
    <script src="${animsitionjs}"></script>
    <script src="${poperjs}"></script>
    <script src="${bootstrapjs}"></script>
    <script src="${select2js}"></script>
    <script src="${daterangepickerjs}"></script>
    <script src="${momentjs}"></script>
    <script src="${countdowntimejs}"></script>
    <script src="${select2js}"></script>
    <script src="${mainjs}"></script>
</head>
<body>
<div class="limiter">
    <div class="wrap-header">
        <div class="wrap-header-logo"><img src="${images}/logo.png"/></div>
        <div class="wrap-header-button"><a href="/erapay/login"><strong class="wrap-header-strong">Sign In</strong></a></div>
    </div>
    <div class="container-login100" style="background-image: url('${images}/banner.png');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">

        <div class="wrap-login100">

					<span class="login100-form-title p-b-26">
						Easy Way to Pay & Get Paid  Sign Up for Free
					</span>
                <br>
                <div>
                    <label class="checkbox"><strong>Personal Account</strong>
                        <input type="radio"  name="radio" value="signup">
                        <span class="checkmark"></span>
                    </label>
                    <p style="padding-left:35px; text-align:justify; line-height:28px;">Shop online or send and receive money. All without sharing your payment info.</p>
                </div>
                <br>
                <div>
                    <label class="checkbox"><strong>Business Account</strong>
                        <input type="radio" name="radio" value="buisnesssignup">
                        <span class="checkmark"></span>
                    </label>
                    <p style="padding-left:35px; text-align:justify; line-height:28px;">Accept ePal and all cards online or at the register. Send secure invoices to your customers.</p>
                </div>
                <div class="container-login100-form-btn" style="padding-bottom:15px;">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" onclick="jump()">
                          Next
                        </button>
                    </div>
                </div>

        </div>
    </div>

</div>


<div id="dropDownSelect1"></div>



</body>

</html>