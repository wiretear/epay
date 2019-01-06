<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"%>
  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/resources/core/css/wallettowallet.css" var="css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/resources/img" var="images" />
<spring:url value="/images" var="dbimages" />

<html>
<head>
<link href="${css}" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<jsp:include page="../fragments/NavHeader.jsp" />
<div id="wrapper">

<div id="page-wrapper">
 <div class="row top-buffer">

        
                <div
                    class="mainbox col-md-10 col-md-offset-1 col-sm-7 col-sm-offset-2">
                    
                    <div  class="panel">
                          <div class="panel-heading text-center custom-header-panel">WALLET TO WALLET TRANSFER</div>
                        <div>

                        </div>
                            <form:form>
                            <div class="panel-body">
						

						<div class="row">
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Email ID</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">
                                                            
                                                         <input type="text" name="studentType" placeholder="Enter Email ID Here.."
									class="form-control ">   

							</div>
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Amount</label>

							</div>
							<div class="margin-bottom col-xs-4 form-group">
                                                            
                                                             <input type="text" name="gender" id="datepicker" placeholder="Enter Amount Here.."
									class="form-control ">   

						</div>
						</div>

						<div class="row">
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right"> Name</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">

								<input type="text" name="stdntMembrID"
									placeholder="Enter Name Here.." class="form-control">
							</div>
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Charge</label>

							</div>
							<div class="margin-bottom col-xs-4 form-group">
                                                            
                                                            <input type="text" name="religion"
									placeholder="Enter Charge Here.." class="form-control">
								
							</div>
						</div>
						<div class="row">
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Wallet ID</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">

								<input type="text" name="name"
									placeholder="Enter Wallet ID Here.." class="form-control">
							</div>
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Description</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">
								<input type="text" name="nationalID"
									placeholder="Enter Product Description Here.." class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Balance</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">
                                                            
                                                            <input type="text" name="batchNo"
									placeholder="Enter Balance Here.." class="form-control">
								
							</div>
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">OTP</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">
								<input type="text" name="mobileNo"
									placeholder="Enter OTP Here.." class="form-control">
							</div>
						</div>
						<div class="row">
							<div class="margin-bottom col-xs-2 form-group">
								<label class="pull-right">Order No.</label>
							</div>
							<div class="margin-bottom col-xs-4 form-group">
                                                            <input type="text" name="batchNo"
									placeholder="Enter State Name Here.." class="form-control">
								
							</div>
							

						</div>

							<div class="row">
								<div class="col-sm-2 col-sm-offset-5">
									<input type="submit" name="login-submit" id="login-submit"
										tabindex="4" class="form-control btn btn-primary"
										value="Submit">
								</div>
								
							</div>
						</div>
                   
                         </form:form>
                    </div>
                </div>
                 
        </div>
  
</div>
</div>


</body>
</html>