<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<spring:url value="/resources/core/css/nav.css" var="navcss" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />
<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>

        <title>WalletOpen</title>
         <!-- Bootstrap CSS CDN -->
         <spring:url value="/resources/core/css/wallettowallet.css" var="css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Our Custom CSS -->
       <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<!------ Include the above in your HEAD tag ---------->
<head>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


body {
    font-family: 'Poppins', sans-serif;
    background: #fafafa;
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
    margin-bottom: 40px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
    background-color: #132142;
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
    height: 1px;
    border-bottom: 1px dashed #ddd;
    margin: 40px 0;
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
    background: #14264E;
    color: #fff;
    transition: all 0.3s;
}

#sidebar.active {
    margin-left: -250px;
}

#sidebar .sidebar-header {
    padding: 20px;
    background: #14264E;
}

#sidebar ul.components {
    padding: 20px 0;
    border-bottom: 1px solid #47748b;
}

#sidebar ul p {
    color: #fff;
    padding: 10px;
}
.subtitle {
  font-family: 'Montserrat';
  font-size: 15px;
}

#sidebar ul li a {
    padding: 10px;
    font-size: 1.1em;
    display: block;
}
#sidebar ul li a:hover {
    color: #14264E;
    background: #fff;
}

#sidebar ul li.active > a, a[aria-expanded="true"] {
    color: #fff;
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
/* align glyph */
.left-addon .glyphicon  { left:  0px;}
.right-addon .glyphicon { right: 0px;}

/* add padding  */
.left-addon input  { padding-left:  30px; }
.right-addon input { padding-right: 30px; }





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
</script>
    </head>
    <body>
 <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                         <a class="navbar-brand" href="/erapay/index">
               <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:60%;"/>
            </a>

                                <i id="sidebarCollapse" style="margin-top:25px;" class="white glyphicon glyphicon-menu-hamburger pull-left"></i>
                                
                            
                            
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
            <nav id="sidebar">
               

         
                <ul class="list-unstyled components">
                    <li>
                 <img src="${images}/NafisKhandaker.jpg" class="img-circle person" alt="Random Name" width="200" height="200">
                  <h4 style="color:white;" class="text-center">Nafees Khundker</h4> 
                    <a href="/erapay/index" data-toggle="collapse" data-target="#submenu-1">HOME</a>
                
                </li>
                
                   
                    
                     <li>
                        <a href="/erapay/walletopenresponsive">Wallet Open</a>
                    </li>
                     <li>
                        <a href="/erapay/responsiveloadfund">Load Fund</a>
                    </li>
                    <li>
                        <a href="/erapay/responsiveaddbank">Add Bank Account</a>
                    </li>
                    <li>
                        <a href="/erapay/wallettowallet">Wallet To Wallet</a>
                    </li>
                     <li>
                        <a href="/erapay/transferbankaccount">Transfer To Bank Account</a>
                    </li>
                </ul>


            </nav>

            <!-- Page Content Holder -->
 
<div class="container-fluid">
            <div class="row col-md-8 col-md-offset-2">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel">ADD BANK ACCOUNT</div>
      <div class="panel-body">
  <form:form method="post" modelAttribute="addBankAccountForm"
		name="addBankAccountForm" action="/erapay/executeaddbankaccount"
                        >
                    <fieldset>
        <div class="col-md-12">
        <div class="col-md-2"></div>
                       <div class="form-group col-md-8">
        <label class="control-label">
         Bank
        </label>
 <div class="input-group">
								<input type="text" class="form-control" id="groupId"
									name="groupId" placeholder="Bank"> <span class="input-group-addon  "
									onclick="return openwindow()"> <i class="glyphicon glyphicon-search"></i>
								</span>
							</div>
      </div>
        </div>    
          <div class="col-md-12 ">
        <div class="col-md-2"></div>
                                  <div class="form-group col-md-8">
        <label class="control-label">
         Branch
        </label>
         <div class="input-group">
								<input type="text" class="form-control" id="groupId"
									name="groupId" placeholder="Branch">  <span class="input-group-addon" 
									onclick="return openwindow()"> <i class="glyphicon glyphicon-search"></i>
								</span>
							</div>
      </div>
        </div>  
          <div class="col-md-12">
        <div class="col-md-2"></div>
                        <div class="form-group col-md-8">
                            <label for="first_name">Account No</label>
                            <input type="text" class="form-control" name="accountNo" id="first_name" placeholder="Account No">
                        </div>
        </div>  
          <div class="col-md-12">
        <div class="col-md-2"></div>
                        <div class="form-group col-md-8">
                            <label for="first_name">Account Title</label>
                            <input type="text" class="form-control" name="accountTitle" id="first_name" placeholder="Account Title">
                        </div>
        </div>  
          <div class="col-md-12">
        <div class="col-md-2"></div>
                        <div class="form-group col-md-8">
                            <label for="first_name">Mobile No</label>
                            <input type="text" class="form-control" name="mobileNo" id="first_name" placeholder="Mobile No">
                        </div>
        </div>  
          <div class="col-md-12">
        <div class="col-md-2"></div>
                        <div class="form-group col-md-8">
                            <label for="first_name">OTP</label>
                            <input type="text" class="form-control" name="otp" id="first_name" placeholder="OTP">
                        </div>
        </div>        

                        </fieldset>
                         <div class="row">
                                <div class="col-sm-3 col-sm-offset-4">
                                    <input type="submit" name="login-submit" id="login-submit"
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Submit">
                                </div>
                               
                            </div>
                        </form:form>
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

