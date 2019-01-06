<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="StyleSheet" href="/resources/core/tree/design.css"
	type="text/css">
<spring:url value="/resources/img" var="images" />
<spring:url value="/paymentmanagement/users" var="LogOut" />
<spring:url value="/resources/core/js/jquery-1.9.1.js" var="date1js" />
<spring:url value="/resources/core/js/jquery-ui.js" var="date2js" />
<spring:url value="/resources/core/js/jquery-ui.css" var="datecss" />
<spring:url value="/resources/core/css/design.css" var="designCss" />
<spring:url value="/newUserRegistrationCMSC1" var="reset" />



<html lang="en">
<head>
<title>User Profile</title>
<meta charset="utf-8">
<script src="${date1}"></script>
<script src="${date2}"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="${designCss}" rel="stylesheet" />
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
	<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">

$(document).ready(

/* This is the function that will get executed after the DOM is fully loaded */
function() {

	$("#datepicker").datepicker({
		dateFormat : 'dd/mm/yy',//this option for formatting a Date
		changeMonth : true, //this option for allowing user to select month
		changeYear : true, //this option for allowing user to select from year range
		yearRange : "-50:+50"
	});
});
$("#datepicker1").datepicker({
	dateFormat : 'dd/mm/yy',//this option for formatting a Date
	changeMonth : true, //this option for allowing user to select month
	changeYear : true, //this option for allowing user to select from year range
	yearRange : "-50:+50"
});

$(document).ready(function() {
    $('#datatable').dataTable();
    
     $("[data-toggle=tooltip]").tooltip();
    
} );

</script>
<style>


body {
    font-family: 'Poppins', sans-serif;
    background: #F7F9FA;
    overflow-x:hidden;
    
}
#sidebar .sidebar-header {
    padding: 20px;
    background: #6d7fcc;
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
    height: 80vh;
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

h1 {
	font-family: 'Enriqueta', arial, serif;
	line-height: 1.25;
	margin: 0 0 10px;
	font-size: 15px;
	font-weight: bold;
}




thead{
    background-color: #204D79;
    color:white;
  
}
.form-control{
  -webkit-border-radius: 0;
     -moz-border-radius: 0;
          border-radius: 0;
}
th {
  font-family: "Trebuchet MS", Arial, Verdana;
  font-size: 12px;
  padding: 4px;

}
tr {
  font-family: "Trebuchet MS", Arial, Verdana;
  font-size: 12px;
  padding: 4px;

}
.mystyle input[type="text"] {
	height: 2px;
	font-size: 10px;
	line-height: 14px;
	border-radious:0;
}

</style>
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

<div class ="container-fluid">
<div  style="margin-top:60px;"class="col-md-12 form-inline">
<div  class="col-md-10 col-md-offset-3">
 <div class="form-group">
    <label for="email">From Date:</label>
 		<input type="text" name="dateOfBirth" id="datepicker"
									class="form-control">
  </div>
   <div class="form-group">
    <label for="email">To Date:</label>
 		<input type="text" name="dateOfBirth" id="datepicker1"
									class="form-control">
  </div>  </div>
			
						
							</div>
		<div  style="margin-top:30px;"class="mainbox col-md-12">

		<table  id="example" class="table table-striped table-bordered hover">
		
<thead>
			<tr class="">
				<th >Srl.</th>
				<th>User ID</th>
				<th>User Name</th>
				<th>D of Birth</th>
				<th>Mobile No</th>
				<th>Email ID</th>
				<th>Request Date</th>
				<th>P</th>
				<th>A</th>
				<th>R</th>
				<th >Approve/Reject</th>
				
				<th>Details</th>
			
			</tr>
			</thead>
				<tr>
					<td>1</td>
					<td>BHAI</td>
					<td>Ruhul Amin</td>
					<td>01676365375</td>
					<td>neazaahsan65@gmail.com</td>
					<td>02/07/2017</td>
					<td><div class="">
                     <label><input type="radio" id='regular' name="optradio"></label>
                 </div></td>
					<td><div class="">
                     <label><input type="radio" id='regular' name="optradio"></label>
                 </div></td>
					<td ><div class="">
                     <label><input type="radio" id='regular' name="optradio"></label>
                 </div></td>
                 	<td> pending</td>
					<td></td>
				
					
					
				
				</tr>
	
		</table>
	</div>
		<div>
		</div>
		</div>
</body>
</html>