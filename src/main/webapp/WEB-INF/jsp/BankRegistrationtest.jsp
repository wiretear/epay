<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <%String sCusCode = (String) session.getAttribute("CUSCODE");%>    
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
            
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

        <title>BANK Registration</title>

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
    min-height: 100vh;
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
                            <li><a href="/erapay/talktime">TALKTIME</a></li>
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
            <div >
<div class="container-fluid">
<div class="col-md-5">
                   
                    </div>
                    <div  style="color: red;"class="col-md-4 text center">
                    <strong><%out.print(session.getAttribute("BankRegiMessage"));%></strong>
                    </div>
            <div style="margin-top:60px;" class="row col-md-8 col-md-offset-2">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel1">Bank  Registration</div>
      <div class="panel-body">
 <form:form method="post" modelAttribute="oBankRegistrationForm"
		name="oBankRegistrationForm" action="/erapay/executebankregistration"
                        class="">
                    <fieldset>
                        <div class="form-group col-md-6">
                            <label for="first_name">Bank Name</label>
                            	<form:select path="bankName" id="status" class="form-control">
								<form:option value="0" label="Select an Option" />
								<form:options items="${oBankRegistrationForm.mapValue}" ></form:options>
							</form:select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="last_name">Commission Rate</label>
                             <form:input type="text" path="bankCommissionRate" class="form-control" value="${oBankRegistrationForm.bankCommissionRate}" id="password" placeholder="CommissionRate"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="password">Buisness Address</label>
                            <form:input type="text" path="bankBusinessAddress" class="form-control" value="${oBankRegistrationForm.bankBusinessAddress}" id="password" placeholder="Buisness Address"/>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="last_name">Remarks</label>
                             <form:input type="text" path="bankRemarks" class="form-control" value="${oBankRegistrationForm.bankRemarks}" id="password" placeholder="Remarks"/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="password">Mobile No</label>
                            <form:input type="text" path="bankMobileNo" class="form-control" value="${oBankRegistrationForm.bankMobileNo}" id="password" placeholder="Mobile No"/>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="confirm_password">Name</label>
                             <form:input type="text" path="contactName" class="form-control" value="${oBankRegistrationForm.contactName}" id="password" placeholder="Name"/>
                        </div>
                         <div class="form-group col-md-6">
                            <label for="password">Fax</label>
                            <form:input type="text" path="bankFax" class="form-control" value="${oBankRegistrationForm.bankFax}" id="password" placeholder="Fax"/>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="confirm_password">Email</label>
                              <form:input type="text" path="contactEmail" class="form-control" value="${oBankRegistrationForm.contactEmail}" id="password" placeholder="Email"/>
                        </div>

<div class="form-group col-md-6">
                         <label for="product">Product Nature</label>
                            <form:input type="text" path="bankProductNature" class="form-control" value="${oBankRegistrationForm.bankProductNature}" id="password" placeholder="Product Nature"/>
                        </div>

                     
                    </fieldset>         

                    <div class="form-group">
                        <div class="col-md-5">
                          
                         
                        </div>
                         <div class="col-md-4">
                            <button type="submit" class="btn btn-lg btn-primary">
                               Submit
                            </button>
                         
                        </div>
                    </div>

                </form:form>
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

