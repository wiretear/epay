
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
<spring:url value="/resources/img" var="images" />
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
                        

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                              <li class="active"><a href="#">HOME</a></li>
      <li><a href="#">LOG OUT</a></li>

                            </ul>
                        </div>
                    </div>
                </nav>



        <div class="wrapper">
            <!-- Sidebar Holder -->
                  <jsp:include page="../fragments/SideNav.jsp" />
            <!-- Page Content Holder -->
            <div class="container-fluid" >

<div style="margin-top:20px;" class="col-md-10  col-md-offset-1">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel1">Wallet Balance</div>
      <div class="panel-body">
      
               
                                    <div class="col-md-6">
         <div class="panel panel-default">
    <div  style="background:#F5F5F5;" class="panel-body">   
    <div class="col-md-12">

     <div class="col-md-3">
      <i class="fa fa-3x fa-dollar" style="color:#021b52">
 </i>
     </div>
         </div>
 <div class="col-md-12">

       <div class="col-md-12">
       <h5 class="pull-left"><strong>Total Balance</strong></h5>
              </div>
           
              <div class="col-md-12">
         <p><strong>Wl5002</strong></p>
              </div>
  
           
  
                            </div>
                            </div>
     </div>
         </div>

 
                            
                                    <div class="col-md-6">
        
                                 <div class="panel panel-default">
    <div style="background:#F5F5F5;"  class="panel-body">   
    <div class="col-md-12">
    
     <div class="col-md-5">
      <i class="fa fa-3x fa-users" style="color:#021b52">
 </i>
     </div>
         </div>
   <div class="col-md-12">

              
   

       <div class="col-md-12">
       <h5 class="pull-left"><strong>Mizanur Rahman</strong></h5>
              </div>
           
              <div class="col-md-12">
         <p><strong>Wl5002</strong></p>
              </div>
  
                      
            
          
       
          
  
                            </div>
                            </div>
     </div>
                            </div>
                       
                        </div>    
                               
 
      </div>
    </div>
 

<div style="margin-top:5px;" class="row col-md-10  col-md-offset-1">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel1">Payment Information</div>
      <div class="panel-body">
      
               
      <div class="col-md-12">
      <div class="col-md-4">
      <div class="row">
   <div class="col-md-4 col-ms-6">
      <div class="g-item" style="background-image:url('https://www.elecfreaks.com/estore/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/img_8379.jpg');">

            <a data-rel="lightbox" class="overlay" href="">
                <span>+</span>
            </a>
      </div> <!-- /.g-item -->
   </div> <!-- /.col-md-4 -->
</div>
      </div>
      
      
      
            <div  style="margin-top:5px;" class="col-md-6">
            		<form:form method="post"
									modelAttribute="oWalletToMerchantPaymentForm"
									name="oWalletToMerchantPaymentForm"
									action="<%=redirectUrl%>">

 <div class="col-md-12">

 <div class="col-md-6">
 <h5>Amount:</h5>
 </div>
  <div class="col-md-6 ">
  ${oWalletToMerchantPaymentForm.amount}
 </div>
 </div>
 <div class="col-md-12">
 <div class="col-md-6 ">
 <h5>Charge:</h5>
 </div>
  <div class="col-md-6">
  ${oWalletToMerchantPaymentForm.charge}
 </div>
 </div>

 <div class="col-md-12">
 <div class="col-md-6 ">
 <h5>Description:</h5>
 </div>
  <div class="col-md-6">
  ${oWalletToMerchantPaymentForm.description}
 </div>
 </div>
 <div class="col-md-12">
 <div class="col-md-4">
 <h5>Order No:</h5>
 </div>
  <div class="col-md-8">
  ${oWalletToMerchantPaymentForm.orderNo}
 </div>
 </div>
 	<div class="form-group">
	<div class="col-md-4"></div>
	<div class="col-md-4">
											<button type="button" class="btn btn-lg btn-primary" data-toggle="modal" data-target="#myModal">
												Submit</button>
										</div>
									</div>
          
                </form:form>               
           
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


          