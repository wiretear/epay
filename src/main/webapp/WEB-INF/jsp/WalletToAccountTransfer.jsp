
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url value="/img" var="images" />
    <spring:url value="/qrcode" var="qrcode"/>
    <spring:url value="/images" var="dbimages" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
    <spring:url value="/core/css/wallettowallet.css" var="css" />
    <spring:url value="/core/css/nav.css" var="navcss" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <spring:url value="/img" var="images" />

        <%String sCusCode = (String) session.getAttribute("CUSCODE");%>

    <title>Bank Account To Wallet</title>

    <!-- Bootstrap CSS CDN -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->

    <head>
        <link href="${bootstrapmincss}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${css}" rel="stylesheet" type="text/css" media="all"/>
        <link href="${navcss}" rel="stylesheet" type="text/css" media="all"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

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


            function openwindow() {
                winURL = "loadfundsearch";
                winName = "loadfundsearch";
                winHeight = 380;
                winWidth = 600;
                winHeight = 380;
                winWidth = 600;
                winTop = ((screen.availHeight / 2) - (winHeight / 2));
                winLeft = ((screen.availWidth / 2) - (winWidth / 2));
                winOpen = "";

                if (winOpen) {
                    if (winOpen.closed) {
                        winOpen = window
                            .open(
                                winURL,
                                winName,
                                "top="
                                + winTop
                                + ",left="
                                + winLeft
                                + ",width="
                                + winWidth
                                + ",height="
                                + winHeight
                                + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
                    } else {
                        winOpen.close();
                        winOpen = window
                            .open(
                                winURL,
                                winName,
                                "top="
                                + winTop
                                + ",left="
                                + winLeft
                                + ",width="
                                + winWidth
                                + ",height="
                                + winHeight
                                + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
                    }
                } else {
                    winOpen = window
                        .open(
                            winURL,
                            winName,
                            "top="
                            + winTop
                            + ",left="
                            + winLeft
                            + ",width="
                            + winWidth
                            + ",height="
                            + winHeight
                            + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
                }
                winOpen.focus();
            }

        </script>
    </head>
<body >
<jsp:include page="../fragments/nav.jsp" />



<div class="wrapper">
    <!-- Sidebar Holder -->
    <jsp:include page="../fragments/SideNav.jsp" />

    <!-- Page Content Holder -->
    <div >


        <div class="col-md-5">
        </div>
        <div  style="color: red;"class="col-md-4 text center">
            <strong><%out.print(session.getAttribute("WalletToAccountTransferMessage"));%></strong>
        </div>
        <div style="margin-top:60px;">
            <div class="container-fluid">
                <div class="row col-md-8 col-md-offset-2">
                    <div class="panel">
                        <div class="panel-heading text-center custom-header-panel">Wallet To Bank Account</div>
                        <div class="panel-body">
                            <div class="col-md-12">
                                <form:form method="post"
                                           modelAttribute="oWalletToAccountTransferForm"
                                           name="LoadFundForm"
                                           action="/erapay/executeloadfundotp">
                                    <fieldset>
                                        <div class="form-group col-md-12">
                                            <label for="merchanteName">Wallet ID</label>
                                            <div class="input-group">
                                                <form:input type="text" path="walletId" name="walletId" id="walletId" class="form-control" value="${oWalletToAccountTransferForm.walletId}" placeholder="Wallet ID"/> <span class="input-group-addon  " onclick="return openwindow()"> <i class="glyphicon glyphicon-search"></i>
								</span>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="merchanteName">Account No</label>
                                            <div class="input-group">
                                                <form:input type="text" path="bankAccount" name="bankAccount" id="bankAccount" class="form-control" value="${oWalletToAccountTransferForm.bankAccount}" placeholder="Account No"/> <span class="input-group-addon  "
                                                                                                                                                                                                                          onclick="return openwindow()"> <i class="glyphicon glyphicon-search"></i>
								</span>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="first_name">Bank Name</label>
                                            <form:input type="text" path="bankName"
                                                        class="form-control"
                                                        value="${oWalletToAccountTransferForm.bankName}"
                                                        placeholder="Bank Name" required="required"/>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="first_name">Branch Name</label>
                                            <form:input type="text" path="branchName"
                                                        class="form-control"
                                                        value="${oWalletToAccountTransferForm.branchName}"
                                                        placeholder="Branch Name" required="required"/>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="first_name">Account Title</label>
                                            <form:input type="text" path="accountTittle"
                                                        class="form-control"
                                                        value="${oWalletToAccountTransferForm.accountTittle}"
                                                        placeholder="Account Title" required="required"/>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="first_name">Amount</label>
                                            <form:input type="text" path="amount"
                                                        class="form-control"
                                                        value="${oWalletToAccountTransferForm.amount}"
                                                        placeholder="Amount" required="required"/>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label for="first_name">Charge</label>
                                            <form:input type="text" path="chargeAmount"
                                                        class="form-control"
                                                        value="${oWalletToAccountTransferForm.chargeAmount}"
                                                        placeholder="Charge" required="required"/>
                                        </div>

                                        <div class="form-group col-md-2">
                                        </div>
                                    </fieldset>
                                    <div class="form-group">
                                        <div class="col-md-5"></div>
                                        <div class="col-md-4">
                                            <input type="Submit"  id="myBtn"
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

                                                <h4 class="modal-title text-center">Confirm OTP</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form:form method="post" modelAttribute="executeloadfund"
                                                           name="oWalletToAccountTransferForm" action="/erapay/executeloadfundotp">
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
                                                                    <label class="text-center">OTP:</label>
                                                                </div>
                                                                <div  class="form-group col-md-8">
                                                                    <input type="text" class="form-control"  placeholder="Enter OTP Here"/ >
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
                                                                       value="Close">
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

