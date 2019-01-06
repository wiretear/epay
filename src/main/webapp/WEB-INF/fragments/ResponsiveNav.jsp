<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/resources/core/css/nav.css" var="css" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />
<link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
<head>
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
<style>
.navbar {
    padding: 7px 5px;
    background: #fff;
    border: none;
    border-radius: 0;
    margin-bottom: 40px;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
    background-color: #132142;
    font-size: 15px !important;
    letter-spacing: 4px;

</style>
    </head>
    <body>
 <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                         <a class="navbar-brand" href="/erapay/index">
               <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:70%;"/>
            </a>

                                <i id="sidebarCollapse" style="margin-top:25px;" class="glyphicon glyphicon-menu-hamburger white"></i>
                                
                            
                            
                        </div>
                        

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                              <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
