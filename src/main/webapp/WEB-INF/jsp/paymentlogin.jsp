<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/index" var="home"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>ERA Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
  body {
      font: 400 15px/1.8 Lato, sans-serif;
      color: #777;
      padding-top: 50px;
     
  }  
  .panel-login {
    border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
}
.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align:center;
}
.panel-login>.panel-heading a{
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login>.panel-heading a.active{
	color: #1D2CED;
	font-size: 18px;
}
.panel-login>.panel-heading hr{
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
}
.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login input:hover,
.panel-login input:focus {
	outline:none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}
.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}
.btn-login:hover,
.btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}
.forgot-password {
	text-decoration: underline;
	color: #888;
}
.forgot-password:hover,
.forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}
.btn-register:hover,
.btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}
  
    
   .covertext {
  position: absolute; /* To make the div to be place anywhere. It is out of the document flow */
  top: 200px; /* The distance between the div with the top of document */
  left: 0px; /* Make the div full width */
  right: 0px; /* Make the div full width */
}

.title {
  font-family: Verdana;
  font-weight: 600;
  font-size: 60px;
  color: #ffffff;
  text-align: center;
}

.subtitle {
  font-family: Verdana;
  font-size: 23px;
  color: black;
  text-align: center;
}

.explore {
  text-align: center;
  margin-top: 10px;
}

.explore .btn-lg,
.explore .btn-lg:hover {
  border-radius: 30px;
  padding: 15px 25px;
  font-size: 22px;
  background-image: none;
  background-color: #1D2CED;
  border-color: #1D2CED;
  color: #ffffff;
}

.btn,
.btn:hover {
  border-radius: 0px;
  background-image: none;
  background-color: #1D2CED;
  border-color: #1D2CED;
  color: #ffffff;
  margin-bottom: 20px;
  box-shadow: none;
  outline: none;
}
.logo
{
  filter: gray; /* IE6-9 */
  -webkit-filter: grayscale(1); /* Google Chrome, Safari 6+ & Opera 15+ */
   -webkit-transition: all .5s ease;
  -moz-transition: all .5s ease;
  -o-transition: all .5s ease;
  -ms-transition: all .5s ease;
  transition: all .5s ease;
  cursor:pointer;
}


.logo:hover
{
  filter: none; /* IE6-9 */
  -webkit-filter: grayscale(0); /* Google Chrome, Safari 6+ & Opera 15+ */
}

.btn:focus,
.btn:active:focus,
.btn.active:focus,
.btn.focus,
.btn:active.focus,
.btn.active.focus {
  color: #ffffff;
  outline: none;
}
  .container {
      padding: 80px 120px;
  }
  .person {
      border: 10px solid transparent;
      margin-bottom: 25px;
      width: 80%;
      height: 80%;
      opacity: 0.7;
  }
  .person:hover {
      border-color: #f1f1f1;
  }
  .innerimg {
      /* make all photos black and white */ 
      width: 100%; /* Set width to 100% */
    
      margin: auto;
  }

  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  .bg-1 {
      background: #2d2d30;
      color: #bdbdbd;
  }
  .bg-1 h3 {color: #fff;}
  .bg-1 p {font-style: italic;}
  .list-group-item:first-child {
      border-top-right-radius: 0;
      border-top-left-radius: 0;
  }
  .list-group-item:last-child {
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
  }
  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
  }
  .btn {
      padding: 10px 20px;
      background-color: #fff;
      color: #f1f1f1;
      border-radius: 0;
      transition: .2s;
  }
  .btn:hover, .btn:focus {
      border: 1px solid #333;
      background-color: #fff;
      color: #000;
  }
  .modal-header, h4, .close {
      background-color: #333;
      color: #fff !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-header, .modal-body {
      padding: 40px 50px;
  }
  .nav-tabs li a {
      color: #777;
  }
  #googleMap {
      width: 100%;
      height: 400px;
      -webkit-filter: grayscale(100%);
      filter: grayscale(100%);
  }  
  .navbar {
      font-family: Montserrat, sans-serif;
      margin-bottom: 0;
      background-color: #F2F2F2;
      border: 0;
      font-size: 15px !important;
      letter-spacing: 4px;
      opacity: 0.9;
  }
  .navbar-fixed-top {
    min-height: 80px;
}
  
  .navbar li a, .navbar .navbar-brand { 
      color: black !important;
  }
  .navbar-nav li a:hover {
      color: #e2c802 !important;
  }
  .navbar-nav li.active a {
      color: #fff !important;
      background-color: #29292c !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
  }
  .open .dropdown-toggle {
      color: #fff;
      background-color: #555 !important;
  }
  .dropdown-menu li a {
      color: #000 !important;
  }
  .dropdown-menu li a:hover {
      background-color: red !important;
  }
 
.covertext {
  position: absolute; /* To make the div to be place anywhere. It is out of the document flow */
  top: 200px; /* The distance between the div with the top of document */
  left: 0px; /* Make the div full width */
  right: 0px; /* Make the div full width */
}

.title {
  font-family: Verdana;
  font-weight: 600;
  font-size: 40px;
  color: yellow;
  text-align: left;
}

.subtitle {
  font-family: Verdana;
  font-size: 23px;
  color: #ffffff;
  text-align: left;
}

.explore {
  text-align: center;
  margin-top: 10px;
}
.explore .btn-lg,
.explore .btn-lg:hover {
  border-radius: 30px;
  padding: 15px 25px;
  font-size: 22px;
  background-image: none;
  background-color: #1D2CED;
  border-color: #1D2CED;
  color: #ffffff;
}

.btn,
.btn:hover {
  border-radius: 0px;
  background-image: none;
  background-color: #1D2CED;
  border-color: #1D2CED;
  color: #ffffff;
  margin-bottom: 20px;
  box-shadow: none;
  outline: none;
}

.btn:focus,
.btn:active:focus,
.btn.active:focus,
.btn.focus,
.btn:active.focus,
.btn.active.focus {
  color: #ffffff;
  outline: none;
}
.srvices_main1 {
    overflow: hidden;
    padding: 30px 0 0;
    width: 100%;
}
.service_first {
    background: #f2efef none repeat scroll 0 0;
    border: 1px dotted #c0c0c0;
    border-radius: 0;
    padding: 20px 10px;
    width: 100%;
}
.service_first h1 {
    color: #000;
    font-family: roboto;
    font-size: 20px;
    font-weight: 400;
    margin-top: 0;
    padding: 5px 0 15px;
    text-align: center;
    text-transform: uppercase;
}
.heading {
    border-bottom: 1px solid #fcab0e;
    padding-bottom: 9px;
    position: relative;
}
textarea:focus, input:focus, input[type]:focus, .uneditable-input:focus {   
    border-color: #1D2CED;
    box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(229, 103, 23, 0.6);
    outline: 0 none;
}
.service_first p {
    font-family: roboto;
    font-size: 14px;
    font-weight: 400;
    margin: 0;
    padding: 0 15px 15px;
    text-align: center;
}
.service_button {
    padding: 10px 0;
    width: 100%;
}
.service_button a {
    background-color: rgb(255, 102, 0);
    background-image: linear-gradient(to bottom, rgb(240, 146, 4), rgb(230, 92, 0));
    border: 1px solid;
    border-radius: 0;
    color: #fff;
    font-family: roboto;
    font-size: 16px;
    margin: 0 135px;
    padding: 5px 25px;
    text-align: center;
    text-decoration: none;
    transition: all 0.3s ease-in-out 0s;
}
.service_button a:hover {
    background: #000000 none repeat scroll 0 0;
}
.service_first:hover {
    background: #fff none repeat scroll 0 0;
    border: 1px dashed #aaa;
    cursor: auto;
    display: block;
}
@import url("http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css");


#sub-floor {
    poistion:fixed;
    color: #AAA;
    background: #031634 none repeat scroll 0% 0%;
  
}
.navbar-brand {
  transform: translateX(-50%);
  left: 25%;
  position: absolute;
}
.footer-bottom {;
    background: #031634 none repeat scroll 0% 0%;

	padding-top: 10px;
	padding-bottom: 10px;
}


/************************************************************
*************************Footer******************************
*************************************************************/
  </style>
  <script>$('.carousel').carousel()
  $(function() {

    $('#login-form-link').click(function(e) {
    	$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

  </script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
  
      <a class="navbar-brand text-center" href="${home}">  <img src="${images}/era.png" style="width:35%;"/></a>

    <div class="collapse navbar-collapse" id="myNavbar">
    
    </div>
  </div>
</nav>

<div class="container">
<div class="col-md-5">
                   
                    </div>
                    <div  style="color: red;"class="col-md-7 pull-left">
                    <strong><%out.print(session.getAttribute("LoginMessage"));%></strong>
                    </div>
        <div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
						<div class="panel-heading">
						<div class="row">
						<div class="col-xs-4 ">
							</div>
							<div class="col-xs-4 ">
								<a href="#" class="active" id="login-form-link">LOG IN</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form method="post" modelAttribute="oKycForm"
		name="frm" action="/erapay/home">
									<div class="form-group">
										<input type="text" name="mailId"  tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
									</form:form>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
     <nav
		class="footer-bottom navbar container-fluid  navbar-default navbar-fixed-bottom ">

		<div>
			<div class="container-fluid text-center ">
				<p style="color: white;">&copy;ERA InfoTech Limited 2010-2020</p>

			</div>
		</div>
	</nav>
</body>
</html>
