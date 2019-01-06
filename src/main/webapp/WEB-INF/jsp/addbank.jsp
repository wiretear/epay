
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/img" var="images" />
    <spring:url value="/erapay/branchsearchajax" var="findStateCitiesURL" />


    <spring:url value="/images" var="dbimages" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
    <spring:url value="/core/css/wallettowallet.css" var="css" />
    <spring:url value="/core/css/nav.css" var="navcss" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <spring:url value="/img" var="images" />

        <%String sCusCode = (String) session.getAttribute("CUSCODE");%>

    <title>Add Bank</title>

    <!-- Bootstrap CSS CDN -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

    <head>
        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
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

$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});



        </script>

        <script>
            function myFunc() {
                var  selectedValue= $("#mySelect").val();
                window.location ="/banksearchaddbank?bankcode="+selectedValue;
            }
        </script>
    </head>
    <body onload="callpage()">
	<jsp:include page="../fragments/nav.jsp" />
        <div class="wrapper">
            <!-- Sidebar Holder -->
               <jsp:include page="../fragments/SideNav.jsp" />
            

            <!-- Page Content Holder -->
            <div >
<div class="container-fluid">





<div class="col-md-5">
                   
                    </div>
                    <div  style="color: red;"class="col-md-4 text center">
                    <strong><%out.print(session.getAttribute("AddBankMessage"));%></strong>

                    </div>
            <div style="margin-top:60px;" class="row col-md-8 col-md-offset-2">
 <div class="panel">
      <div class="panel-heading text-center custom-header-panel1">Add Bank Account</div>
      <div class="panel-body">
  <%--@elvariable id="oAddBankAccountForm" type="ant"--%>
  <form:form method="post" modelAttribute="oAddBankAccountForm"
		name="oAddBankAccountForm" action="/erapay/executeaddbankotp"
                        >
                    <fieldset>



                          <div class="form-group col-md-12">
                            <label for="first_name">Bank Name</label>
                            	<form:select path="bankName" id="mySelect"  onchange="myFunc()"  class="form-control">
                                    <form:option value=" ">Bank Name</form:option>
								<--<form:option value=" " label="${oAddBankAccountForm.bankName}" />-->
								<form:options items="${oAddBankAccountForm.bankMapValue}" ></form:options>
							</form:select>
                        </div>
                         <div class="form-group col-md-12">
                            <label for="first_name">Branch</label>
                             <form:select path="branchName" id="mySelect1" class="form-control">
                                 <form:option value=" ">Branch Name</form:option>
								<form:options   items="${oAddBankAccountForm.mapValue}" ></form:options>
							</form:select>
                        </div>
       
           <div class="form-group col-md-12">
                            <label for="first_name">Account No</label>
                            <form:input type="text" path="accountNo" class="form-control" value="${oAddBankAccountForm.accountNo}" placeholder="Account No" required="required"/>
                        </div>
         <div class="form-group col-md-12">
                            <label for="first_name">Account Title</label>
                             <form:input type="text" path="accountTittle" class="form-control" value="${oAddBankAccountForm.accountTittle}" placeholder="Account Title" required="required"/>
                        </div>
                         <div class="form-group col-md-12">
                            <label for="first_name">Mobile No</label>
                             <form:input type="text" path="mobileNo" class="form-control" value="${oAddBankAccountForm.mobileNo}" placeholder="Mobile No" required="required"/>
                        </div>



                        </fieldset>
                     			<div class="form-group">
										<div class="col-md-4"></div>
										<div class="col-md-4"> 
											                                    <input type="Submit" name="myBtn" 
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Submit">
										</div>
									</div>
                        </form:form>
                       
                        							           <div id="myModal" data-keyboard="false" data-backdrop="static" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header custom-header-panel1">
        
        <h4 class="modal-title">Confirm OTP</h4>
      </div>
      <div class="modal-body">
       <form:form method="post" modelAttribute="oAddBankAccountForm"
		name="oAddBankAccountForm" action="/erapay/executeaddbank">
   <div style="margin-top:20px;" class="col-md-12">
     
   <div class="panel-body">
         <div class="col-md-12">
                  <div class="col-md-4">
                     <img  id="image" style="margin-left:42px;"  src="${dbimages}/<%=sCusCode%>.jpg" class="img-circle" alt="Random Name" width="130" height="130">
                   </div>  
                   <div class="col-md-4">
                    <h4  class="pull-left">Md.Neaz  Ahsan</h4> 
                     <p style="margin-top:42px;" ><strong><%=session.getAttribute("GSMOBILE" )%></strong></p>
                   </div>  
                        </div>  
  
                     <div style="margin-top:42px;" class="col-md-12">                  
  <div style="margin-top:10px;" class="form-group col-md-4">
     <label class="pull-right">OTP:</label>
                        </div>
                          <div  class="form-group col-md-8">
                             <input type="text" class="form-control"  placeholder="Enter OTP Here"/>
                        </div>
                                      
                            </div>
                               </div>
      </div>
      <div class="modal-footer">
       <div class="row">
                              <div class="col-sm-4">
                                 
                                </div>
                                <div class="col-sm-3">
                                    <input type="submit" name="login-submit" id="login-submit" 
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Submit">
                                </div>
                                   <div class="col-sm-3">
                                    <input type=" " name="login-submit" data-dismiss="modal" id="login-submit" 
                                           tabindex="4" class="form-control btn btn-primary"
                                           value="Close" onclick="location.href='/erapay/addbankaccount'" >
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

