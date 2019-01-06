
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <%String redirectUrl = (String) session.getAttribute("redirectUrl");%>
                 <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <%String sCusCode = (String) session.getAttribute("CUSCODE");%>       
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<spring:url value="/resources/core/css/nav.css" var="navcss" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/images" var="dbimages" />
<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
         
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<spring:url value="/resources/core/css/nav.css" var="navcss" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />

<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>

        <title>Wallet To Merchant Payment</title>

         <!-- Bootstrap CSS CDN -->
         <spring:url value="/resources/core/css/wallettowallet.css" var="css" />
       

<!------ Include the above in your HEAD tag ---------->
<head>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


body {
    font-family: 'Poppins', sans-serif;
    background: #F7F9FA;
}
#sidebar .sidebar-header {
    padding: 20px;
    background: #6d7fcc;
}

p {
    font-family: 'Poppins', sans-serif;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1.7em;
    color: #999;
}

a, a:hover, a:focus {
    color: inherit;
    text-decoration: none;
    transition: all 0.3s;
}

.navbar {
   
    background: #fff;
    border: none;
    border-radius: 0;
    margin-bottom: 0px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
    background-color: #021b52;
    font-size: 15px !important;
    letter-spacing: 4px;
}
.navbar li a, .navbar .navbar-brand { 
      color: white !important;
      font-family: 'Montserrat';
      font-weight: bold;
      font-size:15px;
      
  }
  .navbar-nav li a:hover {
  background-color: transparent !important;
      border-bottom: 3px solid #283891;
  }
  .navbar-nav li.active a {
      background-color: transparent !important;
      border-bottom: 3px solid #283891;
  }

.navbar-btn {
    box-shadow: none;
    outline: none !important;
    border: none;
}

.line {
    width: 100%;

    border-bottom: 1px dashed #ddd;

}

/* ---------------------------------------------------
    SIDEBAR STYLE
----------------------------------------------------- */
.wrapper {
    display: flex;
    align-items: stretch;
}

#sidebar {
    min-width: 250px;
    max-width: 250px;
     min-height: 90vh;
    background: #021b52;
}
#sidebar.active {
    margin-left: -250px;
}
#sidebar .sidebar-header {

    background: #14264E;
}
#sidebar ul p {
    color: #fff;
    padding: 10px;
}

#sidebar ul li a {
   color: white !important;
      font-family: 'Montserrat';
      font-weight: bold;
      font-size:14px;
    display: block;
}
#sidebar ul li a:hover {
    color: #14264E;
    background: #071638;
    
}

#sidebar ul li.active > a, a[aria-expanded="true"] {
  color: white !important;
      font-family: 'Montserrat';
      font-weight: bold;
      font-size:13px;
      background: #14264E;
}


a[data-toggle="collapse"] {
    position: relative;
}

a[aria-expanded="false"]::before, a[aria-expanded="true"]::before {
    content: '\e259';
    display: block;
    position: absolute;
    right: 20px;
    font-family: 'Glyphicons Halflings';
    font-size: 0.6em;
}
a[aria-expanded="true"]::before {
    content: '\e260';
}


ul ul a {
    font-size: 0.9em !important;
    padding-left: 30px !important;
    background: #14264E;
}

ul.CTAs {
    padding: 20px;
}

ul.CTAs a {
    text-align: center;
    font-size: 0.9em !important;
    display: block;
    border-radius: 5px;
    margin-bottom: 5px;
}

a.download {
    background: #fff;
    color: #7386D5;
}

a.article, a.article:hover {
    background: #6d7fcc !important;
    color: #fff !important;
}
.white {
    color: white;
}



/* ---------------------------------------------------
    CONTENT STYLE
----------------------------------------------------- */
#content {
    padding: 20px;
    min-height: 100vh;
    transition: all 0.3s;
}
ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}
li.active{border-bottom:3px solid silver;}

.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:10px;margin-bottom:0;color:#337ab7}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}

/* ---------------------------------------------------
    MEDIAQUERIES
----------------------------------------------------- */
@media (max-width: 768px) {
    #sidebar {
        margin-left: -250px;
    }
    #sidebar.active {
        margin-left: 0;
    }
    #sidebarCollapse span {
        display: none;
    }
}


.custom-header-panel1{
    background-color: #021b52 !important;
    border-color: #021b52 !important;
    color: white;
}
.g-item{
    width: 150px;
    height: 150px;
    background-position: center;
    background-size: cover;
}

.btn-primary {
    color: #fff;
    background-color: #021c52;
    border-color: #0a1b3e;
}
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
function callpage ()
{
	if(document.getElementById("login-submit")){
	$('#myModal').modal('show');
	}
}
</script>

    </head>
    <body>
 <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                         <a class="navbar-brand" href="/erapay/index">
               <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:60%;"/>
            </a>
                                <i id="sidebarCollapse" style="margin-left:55px;margin-top:25px; width:100px;" class="white glyphicon glyphicon-menu-hamburger"></i>
                                
                        </div>
                        	<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
				<li><a href="/erapay/qrcode">QRCode</a></li>
					<li><a href="/erapay/talktime">TalkTime</a></li>
					<li class="active"><a href="/erapay/testhome">Home</a></li>
					<li><a href="/erapay/login">LogOut</a></li>
				</ul>
			</div>
                    </div>
                </nav>
        <div class="wrapper">
            <!-- Sidebar Holder -->
                  <jsp:include page="../fragments/SideNav.jsp" />
            <!-- Page Content Holder -->
            <div class="container-fluid" >

<div style="margin-top:20px;" class="row col-md-10  col-md-offset-1">

      <div class="panel">
      <div class="panel-heading text-center custom-header-panel1">Payment Information</div>
      <div class="panel-body">

      
                  <div class="container-fluid">
   

	<div  class="row">
   <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src="https://www.elecfreaks.com/estore/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/img_8379.jpg" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <!-- Datos del vendedor y titulo del producto -->
                  

                    <!-- Precios -->
                        <h6 class="title-price">ORDER NO</h6>
                    <h3 style="margin-top:0px;">${oWalletToMerchantPaymentForm.orderNo}</h3>
                    <h6 class="title-price">AMOUNT</h6>
                    <h3 style="margin-top:0px;">TK  ${oWalletToMerchantPaymentForm.amount}</h3>
                      <h6 class="title-price">CHARGE</h6>
                    <h3 style="margin-top:0px;">TK  ${oWalletToMerchantPaymentForm.charge}</h3>
                    

                    <!-- Detalles especificos del producto -->
               
                          

                    <!-- Botones de compra -->
                                                       
                </div>                              
	
	</div>
</div>
        <div id="myModal" data-keyboard="false" data-backdrop="static" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header custom-header-panel1">
        
        <h4 class="modal-title text-center">Confirm OTP</h4>
      </div>
      <div class="modal-body">
       <form:form method="GET" modelAttribute="oWalletToMerchantPaymentForm"
		name="oWalletToMerchantPaymentForm" action="<%=redirectUrl%>">
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <br>
            <img src="https://cdn2.iconfinder.com/data/icons/luchesa-part-3/128/SMS-512.png" class="img-responsive" style="width:150px; height:150px;margin:0 auto;"><br>
            <h5 class="text-center">An OTP has been sent to your Mobile Number.</h5>
           <br>
             
        <div  style="margin-top:5px;"  class="col-sm-12">
        <div  class="form-group col-sm-2">
                	
                </div>
        <div   class="form-group col-sm-8">
         <h5 class="pull-left">OTP:</h5> 
                	 <span style="color:red;"></span>                    <input type="text" class="form-control" name="otp" placeholder="Enter your OTP number" required="">
                </div>
          </div>
            
        
        <br><br>
        </div>
    </div>        
</div>
<div class="form-group">

    <input type="hidden" id="referenceNo" name="referenceNo" value="a" class="form-control"/>
  </div>
                        <div class="form-group">
   
    <input type="hidden" id="resAmount" name="resAmount"  value="b"  class="form-control"/>
  </div>
                  <div class="form-group">

    <input type="hidden" id="resCharge" name="resCharge"   value="c"  class="form-control"/>
  </div>
               <div class="form-group">
   
    <input type="hidden" id="resNarration" name="resNarration"  value="d"  class="form-control" />
  </div>
    <div class="row">
                              <div class="col-sm-3">
                                 
                                </div>
                                <div class="col-sm-3">
                                    <input type="submit" name="login-submit" id="login-submit" 
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Submit">
                                </div>
                                   <div class="col-sm-3">
                                    <input type="" name="login-submit" data-dismiss="modal" id="login-submit" 
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Close">
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
   
  
    </div>
        </div>
        <!-- jQuery CDN -->
         <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
         <!-- Bootstrap Js CDN -->
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

         <script type="text/javascript">
             $(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                 });
             });
         </script>
    </body>
</html>

