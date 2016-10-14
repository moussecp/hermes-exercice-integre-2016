<!DOCTYPE html>
<%@ page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>
		<spring:message code="watto_cashier"/>
		-
		<spring:message code="add"/>
	</title>
	
	<spring:url value="/css/bootstrap.min.css" var="cssUrl" />
	<link href="${cssUrl}" rel="stylesheet">
</head>
<body>

	<div id="container" class="container">

		<h1>
			<spring:message code="buyer.add"/>
		</h1>
	
		<spring:url value="/buyers" var="addBuyerUrl" />
		<f:form action="${addBuyerUrl}" method="post" modelAttribute="buyer" cssClass="form-horizontal">
			<c:import url="buyerForm.jsp" />
		</f:form>	
	</div>
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
   	<spring:url value="/js/bootstrap.min.js" var="jsUrl" />
   	<script src="${jsUrl}"></script>
</body>
</html>
