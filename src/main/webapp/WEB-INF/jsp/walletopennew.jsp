
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/img" var="images" />
    <spring:url value="/images" var="dbimages" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
    <spring:url value="/core/css/wallettowallet.css" var="css" />
    <spring:url value="/core/css/nav.css" var="navcss" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <spring:url value="/img" var="images" />

        <%String sCusCode = (String) session.getAttribute("CUSCODE");%>

    <title>Wallet Open</title>

    <!-- Bootstrap CSS CDN -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

    <head>
        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<style>
/*
    DEMO STYLE
*/
@import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";
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
	<jsp:include page="../fragments/nav.jsp" />


        <div class="wrapper">
            <!-- Sidebar Holder -->
              <jsp:include page="../fragments/SideNav.jsp" />
            
            <!-- Page Content Holder -->
         
   <div class="container-fluid ">
       <div class="alert alert-success">
           <strong><%
               out.print(session.getAttribute("WalletOpenErrorMessage"));
           %></strong>
       </div>
       <div  style="margin-top:70px;" class="col-md-12">
       <div  style="color: red;"class="col-md-6 text center">
                    
                    </div>
                     
                    <div  style="color: red;"class="col-md-6 text center">
                    <strong><%out.print(session.getAttribute("WalletOpenErrorMessage"));%></strong>
                    </div>
                     </div>
                          <div  class="col-md-12 col-md-offset-1">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel">WALLET OPEN</div>
      <div class="panel-body">
  <form:form method="post" modelAttribute="oWalletOpenForm"
		name="oWalletOpenForm" action="/erapay/executewallet">
                        <div class="col-md-12">
                        <br>
                       <p class="text-center">Please Check Your Device And Enter OTP. </p>
                            </div>                     
   <div class="col-md-12">
        <div class="col-md-3">
        
        </div>
                        <div class="form-group col-md-6">
                            <label class="text-center" for="first_name">OTP</label>
                            <input type="text" class="form-control" name="mobileNo" id="first_name" placeholder="OTP">
                        </div>
        </div>  
                  <div class="form-group text-center">
										<input type="checkbox" tabindex="4" class="" name="remember" id="remember">
										<label for="remember">Wallet</label>
									</div>
                         <div class="row">
                                <div class="col-sm-4 col-sm-offset-4">
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

