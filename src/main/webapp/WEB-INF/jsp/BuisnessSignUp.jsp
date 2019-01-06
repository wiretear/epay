<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18-Dec-18
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/img" var="images" />
    <spring:url value="/index" var="home"/>

    <script src='https://www.google.com/recaptcha/api.js'></script>
    <!-- Theme Made By www.w3schools.com - No Copyright -->
    <title>Business SignUp </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        body {
            font: 400 15px/1.8 Lato, sans-serif;

            padding-top: 50px;

        }

        .btn-register {
            background-color: #1CB94E;
            outline: none;
            color: #fff;
            font-size: 14px;
            height: auto;
            font-weight: normal;
            padding: 14px 0;
            text-transform: uppercase;
            border-color: #1CB94A;
        }
        .btn-register:hover,
        .btn-register:focus {
            color: #fff;
            background-color: #1CA347;
            border-color: #1CA347;
        }





        .navbar {
            font-family: Montserrat, sans-serif;
            margin-bottom: 0;
            background-color: #132142;
            border: 0;
            font-size: 15px !important;
            letter-spacing: 4px;
            opacity: 0.9;
        }
        .navbar-fixed-top {
            min-height: 80px;
        }

        .navbar li a, .navbar .navbar-brand {
            color: white !important;
        }
        .navbar-nav li a:hover {
            color: #e2c802 !important;
        }
        .navbar-nav li.active a {
            color: #fff !important;
            background-color: #29292c !important;
        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
        }
        .open .dropdown-toggle {
            color: #fff;
            background-color: #555 !important;
        }
        .dropdown-menu li a {
            color: #000 !important;
        }
        .dropdown-menu li a:hover {
            background-color: red !important;
        }



        textarea:focus, input:focus, input[type]:focus, .uneditable-input:focus {
            border-color: #2A319B;
            box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(229, 103, 23, 0.6);
            outline: 0 none;
        }
        .service_first p {
            font-family: roboto;
            font-size: 14px;
            font-weight: 400;
            margin: 0;
            padding: 0 15px 15px;
            text-align: center;
        }


        .footer-bottom {;
            background: #031634 none repeat scroll 0% 0%;

            padding-top: 10px;
            padding-bottom: 10px;
        }
        form * {
            border-radius:0 !important;

        }
        .btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited {
            background-color: #2A319B !important;
        }
        span.req {
            color:red;
            font-size: 112%;
        }
        form > fieldset > legend {
            font-size:120%;
        }

        body {
            font: 400 15px/1.8 Lato, sans-serif;
            color: #777;
            padding-top: 100px;

        }

        .panel-login {

            -webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
            -moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
            box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
        }


        /************************************************************
        *************************Footer******************************
        *************************************************************/
    </style>

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
        function validatephone(phone)
        {
            var maintainplus = '';
            var numval = phone.value
            if ( numval.charAt(0)=='+' )
            {
                var maintainplus = '';
            }
            curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
            phone.value = maintainplus + curphonevar;
            var maintainplus = '';
            phone.focus;
        }
        // validates text only
        function Validate(txt) {
            txt.value = txt.value.replace(/[^a-zA-Z-'\n\r.]+/g, '');
        }
        // validate email
        function email_validate(email)
        {
            var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

            if(regMail.test(email) == false)
            {
                document.getElementById("status").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
            }
            else
            {
                document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";
            }
        }
        // validate date of birth
        function dob_validate(dob)
        {
            var regDOB = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/;

            if(regDOB.test(dob) == false)
            {
                document.getElementById("statusDOB").innerHTML	= "<span class='warning'>DOB is only used to verify your age.</span>";
            }
            else
            {
                document.getElementById("statusDOB").innerHTML	= "<span class='valid'>Thanks, you have entered a valid DOB!</span>";
            }
        }
        // validate address
        function add_validate(address)
        {
            var regAdd = /^(?=.*\d)[a-zA-Z\s\d\/]+$/;

            if(regAdd.test(address) == false)
            {
                document.getElementById("statusAdd").innerHTML	= "<span class='warning'>Address is not valid yet.</span>";
            }
            else
            {
                document.getElementById("statusAdd").innerHTML	= "<span class='valid'>Thanks, Address looks valid!</span>";
            }
        }



        /*
        $(function () {
            $('#txtFirstName').keydown(function (e) {

                if ( e.ctrlKey || e.altKey) {
                    e.preventDefault();
                } else {
                    var key = e.keyCode;
                    if (!((key == 8) || (key == 32) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
                        e.preventDefault();
                    }
                }
            });
        });
        */

        function isNumberKey(evt,id)
        {
            try{
                var charCod = (evt.which) ? evt.which : event.keyCode;

                if(charCod==46 || charCod==32){
                    var txt=document.getElementById(id).value;
                    return true;
                }
                var regex = new RegExp("^[a-zA-Z]+$");
                var str = String.fromCharCode(!evt.charCode ? evt.which : evt.charCode);
                if (regex.test(str)) {
                    return true;
                }
                else
                {
                    evt.preventDefault();
                    alert('Please Enter Alphabate');
                    return false;
                }

            }catch(w){
                alert(w);
            }
        }




    </script>



    <script>
        $('#phone_number').attr('data-original-title', 'phone number is required')
            .tooltip('fixTitle')
            .tooltip('show');
    </script>

</head>
<body  style=" background-color:#2c49c887;"id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">

        <a class="navbar-brand text-center" href="${home}">  <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:70%;"/></a>

        <div class="collapse navbar-collapse" id="myNavbar">

            <ul class="nav navbar-nav navbar-right">

                <li><a href="/erapay/index">HOME</a></li>
                <li><a href="/erapay/login">LOG IN</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div style="background-color:f2f3f8;" class="row panel  col-md-8 col-md-offset-2">
        <div class="panel ">
            <div class="row  col-md-8 col-md-offset-2">
                <form:form method="post" modelAttribute="osignUpFormBean"
                           name="osignUpFormBean" action="/erapay/executebusinesssignup">
                    <div class="panel-body"><fieldset><legend class="text-center">SIGN UP</legend>

                        <div class="col-md-12 text-center">
                            <strong style="color: red"><%out.print(session.getAttribute("SignUpMessage"));%></strong>
                        </div>
                        <div class="form-group">
                            <label for="username"><span class="req">* </span> Company Name:</label>
                            <form:input type="text" path="userName"  id="txtFirstName" class="form-control" onkeypress="return isNumberKey(event,this.id)"   required="required" placeholder="Company Name:" value="${osignUpFormBean.userName}"/>

                            <div id="errLast"></div>
                        </div>

                        <div class="form-group">
                            <label for="email"><span class="req">* </span>Email</label>
                            <form:input type="email" path="email" class="form-control" required="required" id = "email"  placeholder="Email" onchange="email_validate(this.value);" value="${osignUpFormBean.email}"/>
                            <div class="status" id="status"></div>
                        </div>
                        <div class="form-group">
                            <label><span class="req">* </span>Mobile No:</label>
                            <form:input  type="tel" title="01676365375" pattern="\+?(88)?0?1[56789][0-9]{8}\b"  path="phone" class="form-control" placeholder="Mobile No" id="phone_number"  required="required" value="${osignUpFormBean.phone}"/>
                        </div>
                        <div class="form-group">
                            <label for="password"><span class="req">* </span> Password</label>
                            <form:input type="password" path="password" class="form-control inputpass" id="pass1"  required="required" placeholder="Password" value="${osignUpFormBean.password}"/>
                            <p style="font-size: x-small">Password between 8 and 20 characters; must contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character, but cannot contain whitespace.</p>
                            <div id="errLast"></div>
                            <label for="password"><span class="req">* </span>Confirm  Password: </label>
                            <input required name="confirmpassword" type="password" class="form-control inputpass"  required="required" minlength="4" maxlength="16" placeholder="Enter again to validate"  id="pass2" onkeyup="checkPass(); return false;" />
                            <span id="confirmMessage" class="confirmMessage"></span>
                        </div>
                        <div class="form-group">

                            <input type="checkbox" required name="terms" onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');" id="field_terms">   <label for="terms">I agree with the <a href="" title="You may read our terms and conditions by clicking on this link">terms and conditions</a> for Registration.</label>
                        </div>


                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6 col-sm-offset-3">
                                    <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-primary" value="Sign Up Now">
                                </div>
                            </div>
                        </div>
                        <h5>You will receive an email to complete the registration and validation process.</h5>
                        <h5>Be sure to check your spam folders. </h5>
                    </fieldset>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<nav
        class="footer-bottom navbar container-fluid  navbar-default  ">
    <div>
        <div class="container-fluid text-center ">
            <p style="color: white;">&copy;ERA InfoTech Limited 2010-2020</p>
        </div>
    </div>
</nav>
</body>
</html>
