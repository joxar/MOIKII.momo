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
		<input type="button" value="groupCreate" id="loginBtn" onclick="login('mainForm')">
	</div>
</form:form>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/showInfo/init" id="mainForm2">
	<input type="button" value="groupShowInfo" id="loginBtn" onclick="login('mainForm2')">
</form:form>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/reqJoin/init" id="mainForm3">
	<input type="button" value="requestJoin" id="loginBtn" onclick="login('mainForm3')">
</form:form>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/rejectJoin/init" id="mainForm4">
	<input type="button" value="rejectJoin" id="loginBtn" onclick="login('mainForm4')">
</form:form>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/changeRole/init" id="mainForm5">
	<input type="button" value="changeRole" id="loginBtn" onclick="login('mainForm5')">
</form:form>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/user/new" id="mainForm6">
	<input type="button" value="userNew" id="loginBtn" onclick="login('mainForm6')">
</form:form>

</body>
</html>
