
<!DOCTYPE html>
<html>

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

    <title>Add Bank</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

    <head>
        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>

            .panel-height {
                height: 300px; / change according to your requirement/
            }
            .custom-header-panel {
                background-color: #021b52 !important;
                border-color: #021b52 !important;

            }
        </style>
    </head>


<body>
<jsp:include page="../fragments/nav.jsp" />
<div class="wrapper">
    <jsp:include page="../fragments/SideNav.jsp" />

    <div class="container-fluid">

        <div  style="margin-top: 120px;" class="row">

            <div  class="col-md-6">

                <div class="panel panel-default">
                    <div class="panel-heading text-center custom-header-panel1">
                        <b style="color: white">Send Money To Wallet</b>
                    </div>
                    <div class="panel-body panel-height">
                        <div class="row" style="margin-top: 50px;">
                            <div class="col-md-4">
                                <img class="img-responsive"   src="${images}/bank-building (1).png" />
                            </div>

                            <div class="col-md-8" style="margin-top: 45px;">
                                <button onclick="window.location.href='/erapay/wallettowallet'"
                                        class="btn btn-success">
                                   Wallet To Wallet
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div  class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading text-center custom-header-panel">
                        <b style="color: white">Send Money To Bank Account</b>
                    </div>
                    <div class="panel-body panel-height">
                        <div class="row"style="margin-top: 60px">
                            <div class="col-md-4">
                                <img class="img-responsive" src="${images}/wallet.png" />
                            </div>
                            <div class="col-md-8" style="margin-top: 45px;">
                                <button onclick="window.location.href='/erapay/wallettobankaccounttransfer'"
                                        class="btn btn-success ">
                                    Wallet To Bank Account
                                </button>
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

