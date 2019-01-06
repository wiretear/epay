<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />

<style>
@import url('https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css');
@media(min-width:768px) {
    body {
        margin-top: 60px;
        background-color:#F1F1F1;
        
    }
    /*html, body, #wrapper, #page-wrapper {height: 100%; overflow: hidden;}*/
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
        padding-left: 220px;
    }

    #page-wrapper {
        padding: 22px 10px;
    }
}
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
 .navbar-default .navbar-toggle {
      border-color: transparent;
  }
.navbar .nav > li > a:hover > .label {
  top: 10px;
}
.navbar-brand {
    padding: 5px 15px;
}
</style>
<body >
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>

    <!-- Navigation -->
    <nav class="navbar  navbar-fixed-top" role="navigation" >
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
                                <li><a href="#"></a></li>
                                <li><a href="#"></a></li>
                                <li><a href="#">HOME</a></li>
                                <li><a href="#">LOG OUT</a></li>
                            </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
            
                <li>
                 <img src="${images}/NafisKhandaker.jpg" class="img-circle person" alt="Random Name" width="200" height="200">
                  <h4 style="color:white;" class="text-center">Nafees Khundker</h4> 
                    <a href="/erapay/index" data-toggle="collapse" data-target="#submenu-1">HOME</a>
                
                </li>
                <li>
                    <a href="/erapay/walletnew">WALLET OPEN</a>
                </li>
                <li>
                    <a href="/erapay/addbankaccountnew" data-toggle="collapse" data-target="#submenu-2">ADD BANK ACCOUNT</a>
                </li>
                
                <li>
                    <a href="/erapay/bankregistration">BANK REGISTRATION </a>
                </li>

            </ul>
        </div>
           </nav>
     
        <!-- /.navbar-collapse -->
 