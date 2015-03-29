<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- ******** css ******** -->
<!-- lib css -->
<spring:url var="baseCss" value="/resources/css/base.css" />
<link rel="stylesheet" type="text/css" href='${baseCss}' />

<!-- ******** js ******** -->
<spring:url var="baseJs" value="/resources/js/base.js" />
<script type="text/javascript" src="${baseJs}"></script>

<title>MOIKII.momo</title>

</head>

<body>
<h1>MOIKII.momo</h1>
<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/create/init" id="mainForm">
	<div id="authMain">
		<label class="itn_auth">Name:     </label><form:input path="user.userName" type="text" id="userName" size="20"></form:input>
		<br>
		<label class="itn_auth">Password: </label><form:input path="user.userPassword" type="text" id="userPassword" size="20"></form:input>
		<br>
		<input type="button" value="LOGIN!!!!!" id="loginBtn" onclick="login()">
	</div>
</form:form>

</body>
</html>
