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
<link rel="stylesheet" type="text/css" href='<spring:url value="resources/css/base.css" />' />

<!-- ******** js ******** -->
<script type="text/javascript" src="resources/js/base.js"></script>

	<title>auth</title>
</head>
<body>
<h1>
	auth
</h1>
<P>  The time on the server is ${serverTime}. </P>

	<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/login_auth" id="mainForm">
	
	<div id="authMain">
		<label class="itn_auth">Name:     </label><input type="text" id="authName" size="20">
		<br>
		<label class="itn_auth">Password: </label><input type="text" id="authPassword" size="20">
		<br>
		<input type="button" value="LOGIN!!!!!" id="loginBtn" onclick="login()">
	</div>

	</form:form>

</body>
</html>
