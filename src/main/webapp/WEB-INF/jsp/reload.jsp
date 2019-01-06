<meta charset="utf-8" xmlns:form="http://www.w3.org/1999/xhtml" xmlns:form="http://www.w3.org/1999/xhtml">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
    <spring:url value="/img" var="images" />
    <spring:url value="/erapay/branchsearchajax" var="findStateCitiesURL" />


    <spring:url value="/images" var="dbimages" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapmincss" />
    <spring:url value="/core/css/wallettowallet.css" var="css" />
    <spring:url value="/core/css/nav.css" var="navcss" />
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <spring:url value="/img" var="images" />

</head>

<form:select path="branchName" id="mySelect1" class="form-control">

    <form:option value="O" label="Select an Option" />
    <form:options items="${oAddBankAccountForm.mapValue}" ></form:options>
</form:select>