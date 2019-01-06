<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${datecss}" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script language="JavaScript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
/*
 * Style tweaks
 * --------------------------------------------------
 */
body {
  padding-top: 50px;
}
.margin-bottomkyccity {
	margin-bottom: 5px;
}
footer {
  padding-left: 15px;
  padding-right: 15px;
  background-color: #fff;
}
  .nopadding {
   padding: 0 !important;
}
.city {
	margin-bottom: 5px !important;
}
/*
 * Off Canvas
 * --------------------------------------------------
 */
@media screen and (max-width: 768px) {
  .row-offcanvas {
    position: relative;
    -webkit-transition: all 0.25s ease-out;
    -moz-transition: all 0.25s ease-out;
    transition: all 0.25s ease-out;
  }

  .row-offcanvas-left
  .sidebar-offcanvas {
    left: -33%;
  }

  .row-offcanvas-left.active {
    left: 33%;
  }

  .sidebar-offcanvas {
    position: absolute;
    top: 0;
    width: 33%;
    margin-left: 10px;
  }
}


#wrapper {
    padding-left: 0;    
}

#page-wrapper {
    width: 100%;        
    padding: 0;
    
}

@media(min-width:768px) {
    #wrapper {
        padding-left: 225px;
    }

    #page-wrapper {
        padding: 1px 15px;
    }
}

/* Top Navigation */

.top-nav {
    padding: 0 15px;
}

.top-nav>li {
    display: inline-block;
    float: left;
}

.top-nav>li>a {
    padding-top: 20px;
    padding-bottom: 20px;
    line-height: 20px;
    color: #fff;
}

.top-nav>li>a:hover,
.top-nav>li>a:focus,
.top-nav>.open>a,
.top-nav>.open>a:hover,
.top-nav>.open>a:focus {
    color: #fff;
    background-color: #1a242f;
}

.top-nav>.open>.dropdown-menu {
    float: left;
    position: absolute;
    margin-top: 0;
    /*border: 1px solid rgba(0,0,0,.15);*/
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    background-color: #fff;
    -webkit-box-shadow: 0 6px 12px rgba(0,0,0,.175);
    box-shadow: 0 6px 12px rgba(0,0,0,.175);
}



/* Side Navigation */

@media(min-width:768px) {
    .side-nav {
        position: fixed;
        top: 70px;
        left: 225px;
        width: 225px;
        margin-left: -225px;
        border: none;
        border-radius: 0;
        border-top: 1px rgba(0,0,0,.5) solid;
        overflow-y: hidden;
        background-color: #14264E;
        bottom: 0;
        overflow-x: hidden;
        padding-bottom: 40px;
        margin-bottom:  100px;
    
    }

    .side-nav>li>a {
        width: 225px;
           border-bottom: 3px solid #283891;
      
    }

    .side-nav li a:hover,
    .side-nav li a:focus {
        outline: none;
        background-color: #1a242f !important;
    }
}
.footer-bottom {
	background: #132142;
	
}
.custom-header-panel{
    background-color: #004b8e !important;
    border-color: #004b8e !important;
    color: white;
}

.side-nav>li>ul {
    padding: 0;
   
}
.navbar li a, .navbar .navbar-brand { 
      color: white !important;
      font-family: 'Montserrat';
      font-weight: bold;
      font-size:11px;
      
  }
  .navbar-nav li a:hover {
  background-color: transparent !important;
      border-bottom: 3px solid #283891;
  }
  .navbar-nav li.active a {
     
      background-color: transparent !important;
       border-bottom: 3px solid #283891;
 
  }

.side-nav>li>ul>li>a {
    display: block;
    padding: 10px 15px 10px 20px;
    text-decoration: none;
    /*color: #999;*/
  
}


  .navbar {
      font-family: Montserrat, sans-serif;
      font-weight: bold;
      margin-bottom: 0;
      background-color: #132142;;
      #132142;
      border: 0;
      font-size: 15px !important;
      letter-spacing: 4px;
      
  }
.navbar .nav > li > a > .label {
  -webkit-border-radius: 50%;
  -moz-border-radius: 50%;
  border-radius: 50%;
  position: absolute;
  top: 14px;
  right: 6px;
  font-size: 10px;
  font-weight: normal;
  min-width: 15px;
  min-height: 15px;
  line-height: 1.0em;
  text-align: center;
  padding: 2px;
}
.subtitle {
  font-family: 'Montserrat';

  font-size: 15px;
}
 .navbar-default .navbar-toggle {
      border-color: transparent;
  }
.navbar .nav > li > a:hover > .label {
  top: 10px;
}
.navbar-brand {
    padding: 5px 15px;
}
form * {
    border-radius:0 !important;
}

form > fieldset > legend {
    font-size:120%;
}
.inner-addon {
  position: relative;
}

/* style glyph */
.inner-addon .glyphicon {
  position: absolute;
  padding: 10px;
  pointer-events: none;
}

/* align glyph */
.left-addon .glyphicon  { left:  0px;}
.right-addon .glyphicon { right: 0px;}

/* add padding  */
.left-addon input  { padding-left:  30px; }
.right-addon input { padding-right: 30px; }

/*
 * Main content
 */

.main {
  padding: 20px;
  background-color: #fff;
}

@media (min-width: 768px) {
  .main {
    padding-right: 40px;
    padding-left: 40px;
  }
}
.main .page-header {
  margin-top: 0;
}
form * {
    border-radius:0 !important;
}

form > fieldset > legend {
    font-size:100%;
}
@media (max-width: @screen-xs) {
    .form-group label{font-size: 10px;}
}

@media (max-width: @screen-sm) {
    .form-group label{font-size: 14px;}
}

.form-group label{
    font-size: 12px;
}
.custom-header-panel{
    background-color: #004b8e !important;
    border-color: #004b8e !important;
    color: white;
}
.panel-default > .panel-heading-custom3{
  background-image: none;
  background-color: #5f9dd3;
  color: black;
}

  .navmargin
  {
   margin-top:50px;
  }

form * {
    border-radius:0 !important;
}
.mystyle input[type="text"] {
	height:27px !important;
	font-size: 13px !important;
	line-height: 14px !important;
}
.btn-file {
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 100px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    margin:right;
    cursor: inherit;
    display: block;
    height:23px !important;
	font-size: 13px !important;
	line-height: 14px !important;
	    
}
#img-upload{
    width: 200px;
    height:200px;
    padding-right: 25px;
}
</style>
  <script type="text/javascript">
  $(document).ready( function() {
  	$(document).on('change', '.btn-file :file', function() {
		var input = $(this),
			label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
		input.trigger('fileselect', [label]);
		});

		$('.btn-file :file').on('fileselect', function(event, label) {
		    
		    var input = $(this).parents('.input-group').find(':text'),
		        log = label;
		    
		    if( input.length ) {
			input.val(log);
									} else {
										if (log)
											alert(log);
									}

								});
						function readURL(input) {
							if (input.files && input.files[0]) {
								var reader = new FileReader();

								reader.onload = function(e) {
									$('#img-upload').attr('src',
											e.target.result);
								}

								reader.readAsDataURL(input.files[0]);
							}
						}

						$("#imgInp").change(function() {
							readURL(this);
						});
					});
		</script>
</head>
<body>
    <nav class="navbar  navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/erapay/index">
               <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:70%;"/>
            </a>
        </div>
        <!-- Top Menu Items -->
       <ul class="nav navbar-nav navbar-right">
                                
                                <li><a href="http://localhost:8080/erapay/index">HOME</a></li>
                                <li><a href="http://localhost:8080/erapay/login">LOG IN</a></li>
                            </ul>
</nav>
    <div class="col-md-12">
                        <div class="col-md-5">
                   
                    </div>
                    <div  style="color: red;"class="col-md-7 text center">
                    <strong><%out.print(session.getAttribute("KYCMessage"));%></strong>
                    </div>
                     </div>
<form:form method="post" modelAttribute="oKycForm"
		name="frm" action="/erapay/executekyc12">
        <div class="col-md-10 col-md-offset-1 col-sm-6 col-sm-offset-5  navmargin" style="margin-right:6px;">

           <div  class="panel panel-default">
				<div class="panel-heading panel-heading-custom3" >
					<h1 style="font-size: 1.7em; font-family: Monotype Corsiva; color: black;"
						class="panel-title text-center">KYC FILL UP</h1>
				</div>
				<div class="panel-body ">
               <div class="col-md-12">
                <div class="panel panel-success">
      <div class="panel-heading text-center">Basic Info</div>
      <div class="panel-body">
     <div class="form-group col-md-6">
                            <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Email</label>
                                </div>
                                <div class="mystyle  nopadding col-md-7 form-group"
                                    >

                                    <form:input type="text" path="email" class="form-control" value="${oKycForm.email}" id="password" placeholder=""/>
                                </div>
                            </div>
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5 form-group">
                                    <label class="pull-right">Name</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                 <form:input type="text" path="name" class="form-control" value="${oKycForm.name}" id="name" placeholder=""/>
                                </div>
                            </div>
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Father Name</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     >

                                   <form:input type="text" path="fatherName" class="form-control" value="${oKycForm.fatherName}" id="fatherName" placeholder=""/>
                                </div>
                            </div>
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Mother Name</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                    <form:input type="text" path="motherName" class="form-control" value="${oKycForm.motherName}" id="motherName" placeholder=""/> 
                                </div>
                            </div>
                               </div>
                          <div class="form-group col-md-6">
                            <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Contact No</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                    <form:input type="text" path="contactNo" class="form-control" value="${oKycForm.contactNo}" id="contactNo" placeholder=""/> 
                                </div>
                            </div>
                            
                           
                             <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">National Id</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                 <form:input type="text" path="nationalId" class="form-control" value="${oKycForm.nationalId}" id="nationalId" placeholder=""/>
                                </div>
                            </div>
                               <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Passport No</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                      <form:input type="text" path="passport" class="form-control" value="${oKycForm.passport}" id="nationalId" placeholder=""/>
                                </div>
                            </div>
                               </div>
                               
                             
                           
      </div>
      
      
    </div>
                </div> 
                
                
                 <div class="col-md-12">
                <div class="panel panel-success">
      <div class="panel-heading text-center">Address Details</div>
      <div class="panel-body">
     <div class="nopadding form-group nopadding col-md-6">
                            <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle  col-md-5   form-group">
                                    <label class="pull-right">
</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                       <form:input type="text" path="presentAddress" class="form-control" value="${oKycForm.presentAddress}" id="presentAddress" placeholder=""/> 
                                </div>
                            </div>
                <div class="col-md-12 ">
                <div class="col-md-4 ">
                      </div>
                      <div class="col-md-8 ">
                      <div class="checkbox">
  <label><input type="checkbox" value="">same as above</label>
</div>
                      </div>
                      </div>
                         
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle  col-md-5   form-group">
                                    <label class="pull-right">
Permanent Address
</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                    <form:input type="text" path="permanentAddress" class="form-control" value="${oKycForm.permanentAddress}" id="permanentAddress" placeholder=""/> 
                                </div>
                            </div>
                               </div>
                          <div class="form-group col-md-6">
                         
                              <div class="col-md-12 nopadding">
                          
                                <div
                                    class="mystyle col-md-5  margin-bottomkyccity   form-group">
                                    <label class="pull-right ">City/Town</label>
                                </div>
                                <div class="margin-bottomkyccity nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                    <form:input type="text" path="presentAddressCity" class="form-control" value="${oKycForm.presentAddressCity}" id="permanentAddress" placeholder=""/> 
                                </div>
                            </div>
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5    form-group">
                                    <label class="pull-right">Country</label>
                                </div>
                                <div class="mystyle nopadding col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                   <select class="form-control mystyle" id="sel1">
    <option  value="bn">Bangladesh </option>
    <option  value="in">India</option>
    <option  value="pk">Pakistan</option>
    <option  value="bt">Bhutan</option>
        <option  value="np">Nepal</option>
            <option  value="jp">Japan</option>
                <option  value="ml">Maldives</option>
                    <option  value="ch">China</option>
                            <option  value="af">Afghanistan</option>
                                    <option  value=sl">Sri Lanka</option>
                                    
  </select> 
                                </div>
                            </div>
                            
                                 <div class="col-md-12">
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                            </div>
                              <div class="col-md-12">
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                                 &nbsp
                            </div>
                                <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5  margin-bottomkyccity   form-group">
                                    <label class="pull-right ">City/Town</label>
                                </div>
                                <div class="margin-bottomkyccity nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                   <form:input type="text" path="permanentCity" class="form-control" value="${oKycForm.presentAddressCity}" id="permanentAddress" placeholder=""/> 
                                </div>
                            
                       <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5    form-group">
                                    <label class="pull-right">Country</label>
                                </div>
                                <div class="mystyle nopadding col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                   <select class="form-control mystyle" id="sel1">
    <option  value="bn">Bangladesh </option>
    <option  value="in">India</option>
    <option  value="pk">Pakistan</option>
    <option  value="bt">Bhutan</option>
        <option  value="np">Nepal</option>
            <option  value="jp">Japan</option>
                <option  value="ml">Maldives</option>
                    <option  value="ch">China</option>
                            <option  value="af">Afghanistan</option>
                                    <option  value=sl">Sri Lanka</option>
                                    
  </select> 
                                </div>
                            </div>
                               
                             
                           
      </div>
    </div>
                </div>
                
                                 
      </div>
      
      
				</div>
				
				 <div class="col-md-12">
                <div class="panel panel-success">
      <div class="panel-heading text-center">Upload Photo and File</div>
      <div class="panel-body">
     <div class="form-group col-md-6">
                            <div class="col-md-12 nopadding">
                     <div class="col-md-6">
    <span  class="btn btn-primary btn-file pull-right">
                    Photo Upload <input class="form-control mystyle" type="file" id="imgInp" name="imageFile">
                </span>
                          </div>
                           <div class="col-md-6">
                            <img  id='img-upload'/>
                          </div>
                            </div>
                               </div>
                          <div class="form-group col-md-6">
                         <div class="col-md-12">
    <div class="form-group">
    <div class="col-md-4">
        <label class="pull-right">File Upload</label>
         </div >
        <div class="input-group col-md-8 padding-0">
            <span class="input-group-btn">
                <span  class="btn  btn-primary btn-file">
                    Browse<input class="form-control mystyle text-right" type="file"  name="documentFile">
                </span>
            </span>
            <input type="text" class="form-control" readonly>
        </div>
       
    </div>
</div>
                            
                               </div>
                               
                             
                           
      </div>
      
      
    </div>
                </div>
                
                       <div class="col-md-12">
                <div class="panel panel-success">
      <div class="panel-heading text-center">Introducer Information</div>
      <div class="panel-body">
     <div class="form-group col-md-6">
                            
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Name</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                  <form:input type="text" path="introducerName" class="form-control" value="${oKycForm.introducerName}" id="introducerName" placeholder=""/> 
                                </div>
                            </div>
                            <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Address</label>
                                </div>
                                <div class="mystyle  nopadding col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                  <form:input type="text" path="introducerAddress" class="form-control" value="${oKycForm.introducerAddress}" id="introducerAddress" placeholder=""/> 
                                </div>
                            </div>
                           
                               </div>
                          <div class="form-group col-md-6">
                            <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right">Occupation</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                    <form:input type="text" path="introducerOccupation" class="form-control" value="${oKycForm.introducerOccupation}" id="introducerOccupation" placeholder=""/>  
                                </div>
                            </div>
                              <div class="col-md-12 nopadding">
                            
                                <div
                                    class="mystyle col-md-5   form-group">
                                    <label class="pull-right ">Mobile No</label>
                                </div>
                                <div class="nopadding  mystyle  col-md-7 form-group"
                                     onkeypress="goMenuDescription(event)">

                                     <form:input type="text" path="introducerMobileNo" class="form-control" value="${oKycForm.introducerMobileNo}" id="introducerMobileNo" placeholder=""/>  
                                </div>
                            </div>
                          
                           
                               </div>
                               
                             
                           
      </div>
    </div>
                </div>
                
              

                </div>
                
                <div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Wallet</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-2 col-sm-offset-5">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-primary" value="Submit">
											</div>
										</div>
									</div>
                    </div>
              
                   
                </div>            
  </form:form>
                
             
                
                  
                           
                   
               
            
</body>
</html>