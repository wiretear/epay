<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/erapay/login" var="login"/>
<spring:url value="/erapay/typeofsignup" var="signup"/>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>ERA Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
		
  <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
  <style>
  body {
       font-family: 'Montserrat';
       font-size: 15px;
       color: #777;
     
  }  
    
   .covertext {
  position: absolute; /* To make the div to be place anywhere. It is out of the document flow */
  top: 220px; /* The distance between the div with the top of document */
  left: 0px; /* Make the div full width */
  right: 0px; /* Make the div full width */
  margin:center;
}


.navheadlink {
 font-family: 'Dancing Script', Georgia, Times, serif;
 font-size: 59px;
 line-height: 60px;
}
.subtitle {
  font-family: Verdana;
  font-size: 8px;
  color: #ffffff;
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
  background-color: #FF4000;
  border-color: #FF4000;
  color: #ffffff;
}

.btn,
.btn:hover {
  border-radius: 0px;
  background-image: none;
  background-color: #FF4000;
  border-color: #FF4000;
  color: #ffffff;
  margin-bottom: 20px;
  box-shadow: none;
  outline: none;
}
.at-overlay {
    background: rgba(45,45,45, 4.0);
    width: 100%;
    height: 100%;
    display: block;
    margin: 0;
    padding: 0;
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
      font-weight: bold;
      margin-bottom: 0;
      background-color: transparent;
      border: 0;
      font-size: 15px !important;
      letter-spacing: 4px;
      
  }
  .navbar li a, .navbar .navbar-brand { 
      color: #ff9c1d !important;
      font-family: 'Montserrat';
      font-weight: bold;
  }
  .navbar-nav li a:hover {
      border-bottom: 3px solid #283891;
  }
  .navbar-nav li.active a {
     
      background-color: transparent !important;
       border-bottom: 3px solid #283891;
 
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
  footer {
      background-color: #2d2d30;
      color: #f5f5f5;
      padding: 32px;
  }
  footer a {
      color: #f5f5f5;
  }
  footer a:hover {
      color: #777;
      text-decoration: none;
  }  
  .form-control {
      border-radius: 0;
  }
  textarea {
      resize: none;
  }
.covertext {
  position: absolute; /* To make the div to be place anywhere. It is out of the document flow */
  top: 200px; /* The distance between the div with the top of document */
  left: 0px; /* Make the div full width */
  right: 0px; /* Make the div full width */
}

.title {
  font-family: 'Montserrat';
  font-weight: bold;
  font-size: 40px;
  color: #F88C00;
  text-align: center;
}

.subtitle {
  font-family: 'Montserrat';
  font-weight: bold;
  font-size: 23px;
  color: white;
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
  background-color: #FF4000;
  border-color: #FF4000;
  color: #ffffff;
}

.btn,
.btn:hover {
  border-radius: 0px;
  background-image: none;
  background-color: #FF4000;
  border-color: #FF4000;
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
    font-family: 'Open Sans', sans-serif;
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
.service_first p {
    font-family: roboto;
    color: #0b0b0b;
    font-size: 14px;
    font-weight: 400;
    margin: 0;
    padding: 0 15px 15px;
    text-align: center;
}
.service_button {
    padding: 8px 2px;
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
    background: red none repeat scroll 0 0;
}
.service_first:hover {
    background: #fff none repeat scroll 0 0;
    border: 1px dashed #aaa;
    cursor: auto;
    display: block;
}

.creative_feature_area {
  background: #f7f7f7;
}
.c_feature_box {
  -webkit-box-shadow: 0px 25px 49px 0px rgba(58, 74, 88, 0.1);
  box-shadow: 0px 25px 49px 0px rgba(58, 74, 88, 0.1);
  border-radius: 2px;
  background: #fff;
  padding: 0px 0px;
  margin-top: -175px;
  z-index: 22;
  position: relative;
}
.c_feature_box .col-lg-4:last-child .c_box_item:before {
  display: none;
}


.c_box_item {
  padding: 0px 35px 0px 40px;
  position: relative;
}

.c_box_item:before {
  content: "";
  background: #e5e5e5;
  height: 145px;
  width: 1px;
  position: absolute;
  right: -15px;
  top: 0px;
}
.c_box_item h4 {
  font-size: 20px;
  color: #232d37;
  font-family: "Poppins", sans-serif;
  font-weight: 500;
  line-height: 36px;
  padding-bottom: 10px;
  -webkit-transition: all 400ms linear 0s;
  -o-transition: all 400ms linear 0s;
  transition: all 400ms linear 0s;
}

.c_box_item h4:hover {
  color: #2bc0a4;
}

.c_box_item p {
  font-size: 14px;
  line-height: 26px;
  color: #51545f;
  font-family: "Poppins", sans-serif;
}
.d_feature_text .main_title {
  padding-bottom: 20px;
}

.d_feature_text p {
  font-size: 14px;
  color: #51545f;
  font-family: "Poppins", sans-serif;
  line-height: 26px;
  padding-bottom: 12px;
}

.d_feature_text p + p {
  padding-bottom: 0px;
}

.d_feature_text .read_btn {
  margin-top: 34px;
}

.d_feature_img {
  padding-left: 70px;
}
.text-slider-caption {
    margin-left: auto;
    margin-right: auto;
    padding-left: 0;
    width: 80%;
    margin-bottom: 30px;
    color: #ffffff;
    font-size: 18px;
}

  .carousel-caption {
  
    text-align: center;
  
     position: absolute;
    /*top: auto;*/
  top: 50%;
  transform: translateY(-50%);
 margin-left: auto;
    margin-right: auto;
    bottom: initial;
      font-family: Montserrat;
      font-weight: bold;
}
.item {
    -webkit-transform-style: preserve-3d;
  -moz-transform-style: preserve-3d;
  transform-style: preserve-3d;
  }


.text-slider-wrapper {
    position: absolute;
    top: 50%;
    width: 100%;
    text-align: center;
    display: inline-block;
    padding: 40px;
    transform: translateY(-50%);
}
.navbar-fixed-top.scrolled {
  background-color: #2F313E !important;
  
}
.section-btn {
    background: #F88C00;
    border-radius: 4px;
    color: #ffffff;
    font-size: 18px;
    font-weight: 700;
    padding: 12px 30px;
    margin-top: 22px;
    text-transform: uppercase;
    border: none;
}


  </style>
  <script>$('.carousel').carousel()</script>
  
<script>
$(function () {
	  $(document).scroll(function () {
	    var $nav = $(".navbar-fixed-top");
	    $nav.toggleClass('scrolled', $(this).scrollTop() > $nav.height());
	  });
	})
    </script>
    <script>
    function typeWriter(text, n) {
    	  if (n < (text.length)) {
    	    $('.test').html(text.substring(0, n+1));
    	    n++;
    	    setTimeout(function() {
    	      typeWriter(text, n)
    	    }, 100);
    	  }
    	}

    	$('.start').click(function(e) {
    	  e.stopPropagation();
    	  
    	  var text = $('.test').data('text');
    	  
    	  typeWriter(text, 0);
    	});
    </script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">  <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:60%;"/></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#myPage">HOME</a></li>
        <li><a href="#about">ABOUT</a></li>
        <li><a href="#services">SERVICES</a></li>
        <li><a href="#contact">CONTACT</a></li>
          <li><a href="${login}">LOGIN</a></li>
          <li><a href="${signup}">SIGNUP</a></li>
      </ul>
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active at-overlay">
        <img class="innerimg" src="${images}/era3.jpg" alt="New York">
           <div class="carousel-caption ">
    <div class="col-lg-12">
  

    </div>
    
  </div>        
      </div>
      <div class="item at-overlay">
        <img class="innerimg"  src="${images}/era4.jpg" alt="Chicago">
         <div class="carousel-caption">
     <div class="col-lg-12">
   
    </div>
    
  </div>     
      </div>
    
      <div class="item at-overlay">
        <img class="innerimg"  src="${images}/era2.jpg" alt="Los Angeles">
            <div class="carousel-caption">
    <div class="col-lg-12">
      
    </div>
   
  </div>       
      </div>
    </div>
    <!-- Left and right controls -->
</div>
 
<!-- Container (The Band Section) -->
<div id="about" class="container text-center">
  <h3>ERA INFOTECH</h3>
  <p>ERA-InfoTech Ltd -A Joint Venture IT Company formed by Bank Asia Ltd, Ranks ITT Ltd of Bangladesh and ETA InfoTech LLC, Dubai, a concern of ETA Ascon Group - a Dubai based conglomerate with global presence. ERA commenced it's journey on 11th November, 2002. ERA has developed Centralized Real Time, Web Based Core Banking Solution both for Conventional & Islamic, Agent Banking, Loan Originating & Approval System, HR & Payroll Management solution, ERP, Micro Finance solution, Mobile and System critical software for various business houses, including Banks, Multinational Companies and the Government. We have a large team of internationally certified software professionals with knowledge in Oracle, Microsoft, Java, etc. ERA has been a pioneer in developing several software solutions in the country. IT solutions for the government like Ektee Bari Ektee Khamar (EBEK) have taken ERA's capabilities to a different level and proves the diverse skill sets available in the company.
  </p>
  <br>
  <div class="row">
    
    <div class="col-sm-4">
      <p class="text-center"><strong>CHAIRMAN</strong></p><br>
      <a href="#demo2" data-toggle="collapse">
        <img src="${images}/Rouf-Sir.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      
      <div id="demo2" class="collapse">
        <p><b>A. ROUF CHOWDHURY</b></p>
        <!--<p>Nominee of RANKS-ITT LTD.</p>-->
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>DIRECTOR</strong></p><br>
      <a href="#demo3" data-toggle="collapse">
        <img src="${images}/NafisKhandaker.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo3" class="collapse">
        <p><b>MR. NAFEES KHUNDKER</b></p>
      
      </div>
    </div>
      <div class="col-sm-4">
          <p class="text-center"><strong>CEO</strong></p><br>
          <a href="#demo" data-toggle="collapse">
              <img src="${images}/Seraj_Sir.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
          </a>
          <div id="demo" class="collapse">
              <p><b>MR.MD.SERAJUL ISLAM,FCMA</b></p>

          </div>
      </div>

  </div>
</div>

<!-- Container (TOUR Section) -->
<div id="services">
 <div class="srvices_main1 bg-1">
                           	 <div class="col-lg-4  col-md-4 col-sm-4">
                                <div class="service_first">
                                
                                <!--<img src="images/canon.png" alt=""/>-->
                                <h1 class="heading">Send Money</h1>
                                    <p style="font-size:1vw;">ERA PAY is the fast, secure way to send money to friends and family.You can instantly send money from your ERA PAY wallet to other ERA PAY wallets.</p>
                                   <div class="service_button "><a href="">More</a></div>
                                   
                            </div>
                            </div>
                            
                           	 <div class="col-lg-4  col-md-4 col-sm-4">
                                <div class="service_first">
                                <!--<img src="images/canon.png" alt=""/>-->
                                <h1 class="heading">Make Payment</h1>
                                    <p style="font-size:1vw;">Make a Payment enables you to easily connect with the ERA PAY community by sending and receiving payments between accounts, free of charge.</p>
                                   <div class="service_button text-center"><a href="">More</a></div>
                            </div>
                            </div>
                            
                             <div class="col-lg-4 col-md-4 col-sm-4">
                                <div class="service_first">
                                
                                <!--<img src="images/canon.png" alt=""/>-->
                                <h1 class="heading">Request Money</h1>
                                    <p style="font-size:1vw;">Request Money is easy with ERA PAY.Anyone with an email or mobile phone number can receive a payment request, whether they have a ERA PAY account or not.
                                    </p>
                                   <div class="service_button"><a href="" >More</a></div>
                                   
                            </div>
                            </div>
                    </div>
  </div>
  
  <!-- Modal -->
  
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Tickets</h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> Tickets, $23 per person</label>
              <input type="number" class="form-control" id="psw" placeholder="How many?">
            </div>
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Send To</label>
              <input type="text" class="form-control" id="usrname" placeholder="Enter email">
            </div>
              <button type="submit" class="btn btn-block">Pay 
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>
          <p>Need <a href="#">help?</a></p>
        </div>
      </div>
    </div>
  </div>

<h2 class="text-center">Our Happy Merchant's</h2>
<div id="carousel-example-generic" class="carousel slide " data-ride="carousel">
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
  
    <div class="item active container">
        <img class="col-md-4 col-sm-2 col-xs-4 logo img-responsive"src="${images}/ajkerdeal.jpg" alt="Alternate Text">
        <img class="col-md-4 col-sm-2 col-xs-4 logo img-responsive" src="${images}/meena-bazars.jpg" alt="...">
        <img class="col-md-4 col-sm-2 col-xs-2 logo img-responsive" src="${images}/foodpanda.png" alt="...">
       
    </div>
    
});

      <div class="item container">
        <img class="col-md-4 col-sm-4 col-xs-4 logo img-responsive"src="${images}/ajkerdeal.jpg" alt="Alternate Text">
        <img class="col-md-4 col-sm-4 col-xs-4 logo img-responsive" src="${images}/foodpanda.jpg" alt="...">
        <img class="col-md-4 col-sm-4 col-xs-4 logo img-responsive" src="${images}/Aarong.png" alt="...">
     </div>
 
    
  </div>

    <div align="center" style="margin-top:20px;">
    <!-- Controls -->
          <a class="left" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
          </a>
          <a class="right" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
          </a>
    </div>
  
</div>
<!-- Container (Contact Section) -->
<div id="contact" class="container">
  <h3 class="text-center">Contact</h3>
  <p class="text-center"><em>We love our fans!</em></p>

  <div class="row">
    <div class="col-md-4">
      <p>Fan? Drop a note.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>ERA-INFOTECH LIMITED
Bengal Center (4th & 6th Floor,9th Floor),28, Topkhana Road, Dhaka - 1000, Bangladesh.</p>
      <p><span class="glyphicon glyphicon-phone"></span>Mobile: +8801904119221, +8801904119207</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: info@era.com.bd</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
  <br>
  <h3 class="text-center">From The Blog</h3>  
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Mike</a></li>
    <li><a data-toggle="tab" href="#menu1">Chandler</a></li>
    <li><a data-toggle="tab" href="#menu2">Peter</a></li>
  </ul>


</div>

<!-- Add Google Maps -->
<div id="googleMap"></div>
<script>
function myMap() {
var myCenter = new google.maps.LatLng(23.7301155, 90.4079247);
var mapProp = {center:myCenter, zoom:12, scrollwheel:false, draggable:false, mapTypeId:google.maps.MapTypeId.ROADMAP};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
var marker = new google.maps.Marker({position:myCenter});
marker.setMap(map);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCmhrH8cjyGj2v1b2HqerdgYHT1ChGuEu8&callback=myMap"></script>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
    <p style="color: white;">&copy;ERA InfoTech Limited 2010-2020</p>
</footer>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</body>
</html>
