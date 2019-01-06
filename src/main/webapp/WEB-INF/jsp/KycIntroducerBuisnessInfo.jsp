<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18-Dec-18
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/img" var="images" />
<head>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <!------ Include the above in your HEAD tag ---------->
    <style>
        .h4
        {
            color:#021b52;
        }
        .hiddenDiv {
            display: none;
        }
        .visibleDiv {
            display: block;
        }
        .show {
            display: inline-block;
            padding: 6px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            cursor: pointer;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #fff;
            background-color: #021c52;
            border-color: #0a1b3e;
            display: compact;
        }
        .hideRow {
            display: none;
        }
        .box {
            background:#fff;
            transition:all 0.2s ease;
            border:2px dashed #dadada;
            margin-top: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            background-clip: padding-box;
            padding:0 20px 20px 20px;
            height:500px;
        }

        .box:hover {
            border:2px solid #525C7A;
        }
        .btn-primary {
            color: #fff;
            background-color: #021c52;
            border-color: #0a1b3e;
        }

        .box span.box-title {
            color: #fff;
            font-size: 24px;
            font-weight: 300;
            text-transform: uppercase;
        }

        .box .box-content {
            padding: 16px;
            border-radius: 0 0 2px 2px;
            background-clip: padding-box;
            box-sizing: border-box;
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
        .nopadding {
            padding: 0 !important;
            margin: 0 !important;
        }
        form * {
            border-radius:0 !important;
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
    <script>
        function callpage ()
        {
            <%String USERINFORESPONSEINTRODUCER = (String) session.getAttribute("USERINFORESPONSEINTRODUCER");%>
            $('#introducermodal').modal('show');
            var value = "<%=USERINFORESPONSEINTRODUCER%>"
            if (value== "flag") {
                document.getElementById('IntrdocuerUpdateBtn').disabled = false;
                //$('input[type="text"], textarea').attr('readonly', 'readonly');
                document.getElementById('IntrdocuerBtn').className = 'hideRow';
            }
            else
            {
                document.getElementById('IntrdocuerBtn').disabled = true;
                $('input[type="text"], textarea').attr('readonly', 'readonly');

            }


            var enforceModalFocusFn = $.fn.modal.Constructor.prototype.enforceFocus;

            $.fn.modal.Constructor.prototype.enforceFocus = function () {
            };

            $confModal.on('hidden', function () {
                $.fn.modal.Constructor.prototype.enforceFocus = enforceModalFocusFn;
            });

            $confModal.modal({backdrop: false});
        }
    </script>
    <script>
        function hide() {
            document.getElementById('IntrdocuerBtn').disabled = false;
            $('input[type="text"], textarea').removeAttr('readonly');
            document.getElementById('clicked_button').value = "Update";
            document.frm.submit();
        }
    </script>
</head>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/erapay/index">
                <img src="${images}/Era-Infotech-Ltd.-Logo1.png" style="width:60%;"/>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        </div>
    </div>
</nav>
<body onload="callpage()">
<div class="container">
    <div class="row">
        <h2 class="text-center"></h2>
        <div class="row">
            <div class="col-md-3 text-center">
                <div class="box">
                    <div class="box-content">
                        <h4 class="tag-title">Photo And File</h4>
                        <img  id="image"  src="${images}/man.png" class="img-circle" alt="Random Name" width="130" height="130">
                        <hr/>

                        <p class="text-center">Upload a copy of photo id.
                            Like: National ID, Driving License, Passport etc. Make sure all information is clearly readable and that it is fully in frame.</p>
                        <br />
                        <a type="button" class="btn btn-block btn-primary" data-toggle="modal" data-target="#myModal2">Upload</a>
                    </div>
                </div>
                <div id="myModal2" data-keyboard="false" data-backdrop="static" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-lg">

                        <!-- Modal content-->
                        <div class="modal-content ">
                            <div class="modal-header">

                                <h4 class="modal-title">Upload</h4>
                            </div>




                            <div class="modal-body">
                                <form:form method="post" modelAttribute="oKycForm"
                                           name="frm" action="/erapay/executekyc123">
                                    <div class="container-fluid">
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
                                    <div class="row">
                                        <div class="form-group col-md-5">

                                        </div>
                                        <div class="col-md-3">
                                            <input type="submit" name="photo-submit" id="photo-submit"
                                                   tabindex="4" class="form-control btn btn-primary"
                                                   value="Submit">
                                        </div>
                                        <div class="col-sm-3">
                                            <input type=" " name="login-submit" data-dismiss="modal" id="login-submit"
                                                   tabindex="4" class="form-control btn btn-primary"
                                                   value="Close">
                                        </div>
                                    </div>
                                </form:form>

                            </div>
                        </div>

                    </div>
                </div>

            </div>
            <div class="col-md-3 text-center">
                <div class="box">
                    <div class="box-content">
                        <h4 class="tag-title">Basic Information</h4>
                        <img  id="image"  src="${images}/application.png" class="img-circle" alt="Random Name" width="130" height="130">
                        <hr />
                        <p class="text-center">Add your basic information  to send some goodies or official doc.</p>
                        <br/>
                        <br/>
                        <br/>
                        <br/>


                        <a  type="button" href="/erapay/kycinfoparameter" id="basicinfo"  class="btn btn-block btn-primary">ADD BASIC INFO</a>
                    </div>

                </div>
            </div>
            <div class="col-md-3 text-center">
                <div class="box">
                    <div class="box-content">
                        <h4 class="tag-title">Address</h4>
                        <img  id="image"  src="${images}/notebook1.png" class="img-circle" alt="Random Name" width="130" height="130">
                        <hr />
                        <p>Add your basic information and present address to send some goodies or official doc.</p>
                        <br />
                        <br/>
                        <br/>
                        <br/>

                        <a type="button" id="addressbtn" class="btn btn-block btn-primary" >ADDRESS</a>
                        <!-- Modal -->

                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center">
                <div class="box">
                    <div class="box-content">
                        <h4 class="tag-title">Introducer Info</h4>
                        <img  id="image"  src="${images}/notebook1.png" class="img-circle" alt="Random Name" width="130" height="130">
                        <hr />
                        <p>Add your basic information and present address to send some goodies or official doc.</p>
                        <br />
                        <br />
                        <br/>

                        <br/>
                        <a type="button" href="/erapay/kycintroducer" id="introducerinfo" class="btn btn-block btn-primary" data-toggle="modal" data-target="#introducermodal">INTRODUCER INFO</a>
                    </div>
                    <div id="introducermodal" data-keyboard="false" data-backdrop="static" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content" style="width:700px;">
                                <div class="modal-header">

                                    <h4 class="modal-title">Introducer Information</h4>
                                </div>

                                <div class="modal-body">
                                    <form:form method="post" modelAttribute="oKycForm"
                                               name="frm" action="/erapay/executekycintroducer">
                                        <div class="container-fluid">
                                            <div class="col-md-12">
                                                <!-- <input  class="pull-right  btn btn-primary" type="button" id="AddressEdit" onClick="hide()" value="Edit"> -->
                                            </div>
                                            <div class="row">
                                                <div class="col-md-8 col-md-offset-2">
                                                    <label class="pull-left">Introducer Name</label>
                                                    <form:input type="text" path="introducerName" class="form-control"   value="${oKycForm.introducerName}"  required="required" id="introducerName"   placeholder="Introducer Name"/>
                                                </div>
                                            </div>
                                            <input type="hidden" name="clicked_button" id="clicked_button" value=" "/>
                                            <div class="row">
                                                <div class="col-md-8 col-md-offset-2">
                                                    <label class="pull-left">Address</label>
                                                    <form:input type="text" path="introducerAddress" class="form-control" value="${oKycForm.introducerName}" required="required" id="Address" placeholder="Address"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-8 col-md-offset-2">
                                                    <label class="pull-left">Occupation</label>
                                                    <form:input type="text" path="introducerOccupation" class="form-control" required="required" value="${oKycForm.introducerOccupation}" id="introducerOccupation" placeholder="Introducer Occupation"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-md-8 col-md-offset-2">
                                                    <label class="pull-left">Mobile No</label>
                                                    <form:input type="text" path="introducerMobileNo" class="form-control" value="${oKycForm.introducerMobileNo}" required="required" id="introducerMobileNo" placeholder="Introducer Mobile No"/>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4">

                                                </div>
                                                <div class="col-md-2">

                                                </div>
                                                <div class="col-md-2">
                                                    <input type="submit" name="IntrdocuerUpdateBtn" id="IntrdocuerBtn"  id="login-submit"
                                                           tabindex="4" class="form-control btn btn-primary"
                                                           value="Submit">
                                                </div>
                                                <div class="col-md-2">
                                                    <input type="" name="login-submit" data-dismiss="modal" id="login-submit"
                                                           tabindex="4" class="form-control btn btn-primary"
                                                           value="Close" onclick="location.href='/erapay/businesskyc'">
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
</body>

