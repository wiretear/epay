
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

    <title>CHANGE PASSWORD</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

    <head>
        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script>
            $(document).ready(function() {

                $("#sidebar").mCustomScrollbar({
                    theme : "minimal"
                });

                // when opening the sidebar
                $('#sidebarCollapse').on('click', function() {
                    // open sidebar
                    $('#sidebar').addClass('active');
                    // fade in the overlay
                    $('.overlay').fadeIn();
                    $('.collapse.in').toggleClass('in');
                    $('a[aria-expanded=true]').attr('aria-expanded', 'false');
                });

                // if dismiss or overlay was clicked
                $('#dismiss, .overlay').on('click', function() {
                    // hide the sidebar
                    $('#sidebar').removeClass('active');
                    // fade out the overlay
                    $('.overlay').fadeOut();
                });
            });
        </script>
        <script>
            function checkPass()
            {
                //Store the password field objects into variables ...
                var pass1 = document.getElementById('pass1');
                var pass2 = document.getElementById('pass2');
                //Store the Confimation Message Object ...
                var message = document.getElementById('confirmMessage');
                //Set the colors we will be using ...
                var goodColor = "#66cc66";
                var badColor = "#ff6666";
                //Compare the values in the password field
                //and the confirmation field
                if(pass1.value == pass2.value){
                    //The passwords match.
                    //Set the color to the good color and inform
                    //the user that they have entered the correct password
                    pass2.style.backgroundColor = goodColor;
                    message.style.color = goodColor;
                    message.innerHTML = "Passwords Match"
                }else{
                    //The passwords do not match.
                    //Set the color to the bad color and
                    //notify the user.
                    pass2.style.backgroundColor = badColor;
                    message.style.color = badColor;
                    message.innerHTML = "Passwords Do Not Match!"
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
        </div>


        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">s
        </div>
    </div>
</nav>

<div class="wrapper">
    <!-- Sidebar Holder -->

    <!-- Page Content Holder -->

    <div class="container-fluid ">

        <div style="margin-top: 70px;" class="col-md-12">
            <div style="color: red;" class="col-md-5 text center"></div>

            <div style="color: red;" class="col-md-6 text center">
                <strong>
                    <%
                        out.print(session.getAttribute("TemporaryMessage"));
                    %>
                </strong>
            </div>
        </div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel">
                <div class="panel-heading text-center custom-header-panel">Change Password</div>
                <div class="panel-body">
                    <form:form method="post" data-toggle="validator" role="form"
                               modelAttribute="oForgetPasswordForm" name="oForgetPasswordForm"
                               action="/erapay/executeresetpassword">
                        <div class="col-md-12">
                            <br>
                            <p>Provide your password then an authentication code will be sent to the mobile.</p>
                            <hr>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-3"></div>
                            <div class="form-group col-md-6">
                                <label class="text-center" for="first_name">Temporary Password</label>
                                <form:input type="password" path="temporaryPassword"
                                            class="form-control"
                                            value="${oForgetPasswordForm.temporaryPassword}"
                                            placeholder="Temporary Password" required="required"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-3"></div>
                            <div class="form-group col-md-6">
                                <label class="text-center" >New Password</label> <form:input
                                    type="password"  path="newPassword"  class="form-control"
                                    id="pass1" value="${oForgetPasswordForm.newPassword}" placeholder="NewPassword"  required="required"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="col-md-3"></div>
                            <div class="form-group col-md-6">
                                <label class="text-center" for="first_name">Confirm New Password</label>
                                <form:input type="password" class="form-control"
                                            path="confirmNewPassword" id="pass2" value="${oForgetPasswordForm.confirmNewPassword}"
                                            onkeyup="checkPass(); return false;"  placeholder="Confirm NewPassword"  required="required"/>
                                <span id="confirmMessage" class="confirmMessage"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" name="login-submit" id="login-submit"
                                       tabindex="4" class="form-control btn btn-primary"
                                       value="Confirm">
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
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#sidebarCollapse').on('click', function() {
            $('#sidebar').toggleClass('active');
        });
    });
</script>
</body>
</html>

