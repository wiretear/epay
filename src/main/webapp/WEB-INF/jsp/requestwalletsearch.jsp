<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24-Dec-18
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
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



<html lang="en">
<head>
    <title>WALLET ID SEARCH</title>
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
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>
    <script>
        $(function() {
            var dialog, form,

                // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
                emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), password = $("#password"), allFields = $(
                []).add(name).add(email).add(password), tips = $(".validateTips");

            function updateTips(t) {
                tips.text(t).addClass("ui-state-highlight");
                setTimeout(function() {
                    tips.removeClass("ui-state-highlight", 1500);
                }, 500);
            }

            function checkLength(o, n, min, max) {
                if (o.val().length > max || o.val().length < min) {
                    o.addClass("ui-state-error");
                    updateTips("Length of " + n + " must be between " + min
                        + " and " + max + ".");
                    return false;
                } else {
                    return true;
                }
            }

            function checkRegexp(o, regexp, n) {
                if (!(regexp.test(o.val()))) {
                    o.addClass("ui-state-error");
                    updateTips(n);
                    return false;
                } else {
                    return true;
                }
            }

            function addUser() {
                var valid = true;
                allFields.removeClass("ui-state-error");

                valid = valid && checkLength(name, "username", 3, 16);
                valid = valid && checkLength(email, "email", 6, 80);
                valid = valid && checkLength(password, "password", 5, 16);

                valid = valid
                    && checkRegexp(
                        name,
                        /^[a-z]([0-9a-z_\s])+$/i,
                        "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
                valid = valid
                    && checkRegexp(email, emailRegex, "eg. ui@jquery.com");
                valid = valid
                    && checkRegexp(password, /^([0-9a-zA-Z])+$/,
                        "Password field only allow : a-z 0-9");

                if (valid) {
                    $("#users tbody").append(
                        "<tr>" + "<td>" + name.val() + "</td>" + "<td>"
                        + email.val() + "</td>" + "<td>"
                        + password.val() + "</td>" + "</tr>");
                    dialog.dialog("close");
                }

                return valid;
            }

            dialog = $("#dialog-form").dialog({

                autoOpen : false,
                height : 400,
                width : 850,
                modal : true,

                close : function() {
                    form[0].reset();
                    allFields.removeClass("ui-state-error");
                }
            });

            form = dialog.find("form").on("submit", function(event) {
                event.preventDefault();
                addUser();
            });

            $("#create-user").click(function() {
                $("#dialog-form").dialog("open");
            });
        });
        function showPopup() {
            //code to show your dialog
            return false
        }
        function putData(id11, id12) {
            var data1 = id11;
            var data2 = id12;
            window.opener.document.getElementById('id11').value = data1;
            window.opener.document.getElementById('id12').value = data2;
            window.close();
        }


        function doClick(v1, v2, v3) {

            // window.opener.document.a.
            alert(v1 + "==" + v2);
            //	window.document.getElementByName('groupDescription').value = v1;
            //   window.document.getElementByName('GroupId').value = v2;
            // alert(v2);

            window.close();
        }
    </script>
<script>
    function doSelect(a, b) {
//alert(b);
        opener.document.MoneyForm.name.value = a;
        opener.document.MoneyForm.walletId.value = b;
        //opener.document.frm.menuDescription.value = b;
        /*  oMenuGenarationForm.groupId.value=a;
          alert(oMenuGenarationForm.groupId.value);
          window.oMenuGenarationForm.groupId.value;*/
        window.close();
    }
</script>
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
        $(document).ready(function() {
            $('#datatable').dataTable();

            $("[data-toggle=tooltip]").tooltip();

        });
        function doClear()
        {
            onclick="location.href='/users/u'"
        }

        function doSubmit() {
            alert(document.getElementById("email").value);
            var f = document.NewUserRegistrationCMSC1Form;
            //alert(f);
            f.action = "/paymentmanagement/newUserRegistrationCMSC2";
            f.submit();
        }
    </script>
    <script TYPE="text/javascript">
        function onCall(form) {
            var idstr = form["formname:sname1"].value;

            alert(idstr);

        }
    </script>
    <style>
        label, input {
            display: block;
        }

        input.text {
            margin-bottom: 12px;
            hieght: 40px;
            width: 95%;
            padding: .4em;
        }

        .heading {
            padding-bottom: 5px !important;
            border-bottom: 1px solid #aaaaaa;
            font-size: 24px;
            text-align: left;
        }

        @media screen and (min-width:992px) {
            .user-form {
                border-left: 1px solid #dddddd;
            }
        }

        .top-margin {
            margin-top: 50px;
        }

        .oauth-links {
            margin-top: 10px;
        }

        .btn {
            border-radius: 0;
        }

        .tes {
            text-align: center;
        }

        .footer-bottom {
            background: #204D79;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        fieldset {
            padding: 0;
            border: 0;
            margin-top: 25px;
        }

        h1 {
            font-size: 1.2em;
            margin: .6em 0;
        }

        div#users-contain {
            width: 350px;
            margin: 20px 0;
        }

        div#users-contain table {
            margin: 1em 0;
            border-collapse: collapse;
            width: 100%;
        }
        .button {
            background-color: #286090;
            border: none;
            color: white;
            padding: 1px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }

        .button1
        {
            margin-left:7cm;
        }
        #wrapper {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        div#users-contain table td, div#users-contain table th {
            border: 1px solid #eee;
            padding: .6em 10px;
            text-align: left;
        }
        .ui-dialog .ui-state-error {
            padding: .3em;
        }

        .validateTips {
            border: 1px solid transparent;
            padding: 0.3em;
        }

        body {
            margin-bottom: 100px;
            overflow-x: hidden !important;
            overflow-y: auto;
        }

        .foo {
            position: fixed;
            bottom: 0;
        }

        .intro {
            background-color: #1E4892;
        }

        .spaceunder {
            line-height: 0.5em;
        !
        important;
        }

        .header {
            background: url("${images}/IMG8515.jpg");
        }

        .intro1 {
            background: url("${images}/1.jpg");
            width: 85.7%;
            margin-left: 2.6cm;
        }

        .customBackground {
            background: url("${images}/2840.jpg");
        }

        .top-buffer {
            margin-top: 2%;
        }
        .top-buffer1 {
            margin-top: 1%;
        }

        .top-buffer6 {
            margin-top: 5%;
        }

        .fontsizedatatable {
            font-size: 10px;
        }

        .top-buffer2 {
            margin-top: 15%;
        }

        .top-buffer3 {
            margin-top: 20%;
        }

        .top-buffer4 {
            margin-top: 40%;
        }

        .in {
            height: 25px !important;
            width: 200px !important;
            font-size: 11px !important;
        }

        .o {
            overflow-x: hidden !important;
        }

        .headcolorpanel {
            color: #286090;
        }

        .margin-bottom {
            margin-bottom: 5px;
        }

        .ui_datepicker {
            background: #94A3DC;
            border: 1px solid #555;
            color: #EEE;
        }

        .backimagebody {
            background-color: #F6F6F6;
        }

        .panelcolor {
            background-color: #320AA5;
        }

        .textfon {

        }

        h1 {
            font-family: 'Enriqueta', arial, serif;
            line-height: 1.25;
            margin: 0 0 10px;
            font-size: 15px;
            font-weight: bold;
        }

        .checkbox label::before {
            content: "";
            display: inline-block;
            position: absolute;
            width: 17px;
            height: 17px;
            left: 0;
            margin-left: -20px;
            border: 1px solid #cccccc;
            border-radius: 3px;
            background-color: #fff;
            -webkit-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
            -o-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
            transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
        }

        .checkbox label::after {
            display: inline-block;
            position: absolute;
            width: 16px;
            height: 16px;
            left: 0;
            top: 0;
            margin-left: -20px;
            padding-left: 3px;
            padding-top: 1px;
            font-size: 11px;
            color: #555555;
        }

        .checkbox input[type="checkbox"] {
            opacity: 0;
        }

        .checkbox input[type="checkbox"]:focus+label::before {
            outline: thin dotted;
            outline: 5px auto -webkit-focus-ring-color;
            outline-offset: -2px;
        }

        .checkbox input[type="checkbox"]:checked+label::after {
            font-family: 'FontAwesome';
            content: "\f00c";
        }

        .checkbox input[type="checkbox"]:disabled+label {
            opacity: 0.65;
        }

        .checkbox input[type="checkbox"]:disabled+label::before {
            background-color: #eeeeee;
            cursor: not-allowed;
        }

        .checkbox.checkbox-circle label::before {
            border-radius: 50%;
        }

        .checkbox.checkbox-inline {
            margin-top: 0;
        }

        .checkbox-primary input[type="checkbox"]:checked+label::before {
            background-color: #428bca;
            border-color: #428bca;
        }

        .checkbox-primary input[type="checkbox"]:checked+label::after {
            color: #fff;
        }

        .checkbox-danger input[type="checkbox"]:checked+label::before {
            background-color: #d9534f;
            border-color: #d9534f;
        }

        .checkbox-danger input[type="checkbox"]:checked+label::after {
            color: #fff;
        }

        .checkbox-info input[type="checkbox"]:checked+label::before {
            background-color: #5bc0de;
            border-color: #5bc0de;
        }

        .checkbox-info input[type="checkbox"]:checked+label::after {
            color: #fff;
        }

        .checkbox-warning input[type="checkbox"]:checked+label::before {
            background-color: #f0ad4e;
            border-color: #f0ad4e;
        }

        .checkbox-warning input[type="checkbox"]:checked+label::after {
            color: #fff;
        }

        .checkbox-success input[type="checkbox"]:checked+label::before {
            background-color: #5cb85c;
            border-color: #5cb85c;
        }

        .checkbox-success input[type="checkbox"]:checked+label::after {
            color: #fff;
        }

        * {
            -webkit-border-radius: 0 !important;
            -moz-border-radius: 0 !important;
            border-radius: 0 !important;
        }

        .mystyle input[type="email"] {
            height: 2px;
            font-size: 10px;
            line-height: 14px;
        }
        .fontsizetable
        {
            font-size: 15px;
        }
        thead{
            background-color: #204D79;
            color:white;

        }

    </style>
</head>
<body>



<div
        class="top-buffer6 mainbox col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-5 row">
    <div style="background-color: #f2f2f2;" class="panel panel-default">
        <div class="panel-heading">
            <h1  style="font-family: Lucida Console, Monaco, monospace"class="panel-title text-center">Search Wallet</h1>
        </div>
        <div class="panel-body">

            <div class="col-md-12">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="usr">Wallet Id:</label>
                        <input type="text" class="form-control" id="usr">
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="usr">Name:</label>
                        <input type="text" class="form-control" id="usr">
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-8">
                    <div class="form-group">
                        <label for="usr">Mobile No:</label>
                        <input type="text" class="form-control" id="usr">
                    </div>
                </div>
            </div>

        </div>
        <p>&nbsp
        <p>

    </div>


</div>
<div class="mainbox col-md-8 col-md-offset-2 col-sm-6 col-sm-offset-5 row">
    <form:form name="frm1"
               modelAttribute="owallettowallet">
        <table  id="example" class="table table-striped table-bordered hover">
            <thead>
            <tr class="fontsizetable">
                <th >Srl.</th>
                <th>Name</th>
                <th>Wallet Id</th>
                <th>Mobile No</th>
                <th>Select</th>
            </tr>
            </thead>
            <%
                int counter = 1;
            %>


            <c:forEach var="bo" items="${owallettowallet.walletSearchList}">
                <tr>
                    <td ><%=counter++%></td>
                    <td ><c:out value="${bo.name}"/></td>
                    <td ><c:out value="${bo.walletId}"/></td>
                    <td ><c:out value="${bo.mobileNO}"/></td>
                    <td><a href="#"
                           onclick="doSelect('${bo.name}','${bo.walletId}')">Select
                    </a></td>


                </tr>
            </c:forEach>





        </table>

    </form:form>
</div>
<div>
</div>
</body>
</html>