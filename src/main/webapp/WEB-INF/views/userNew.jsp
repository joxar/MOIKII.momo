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
<link rel="stylesheet" type="text/css" href='<spring:url value="../resources/css/base.css" />' />

<!-- ******** js ******** -->
<script type="text/javascript" src="../resources/js/base.js"></script>

<title>MOIKII.momo</title>

</head>

<body>
<h1>Create your account</h1>
<form:form modelAttribute="createUser">
	<div id="authMain">
		<label class="itn_auth">Username     </label><form:input path="user.userName" type="text" id="userName" size="20"></form:input>
		<br>
		<label class="itn_auth">Password </label><form:input path="user.userPassword" type="text" id="userPassword" size="20"></form:input>
		<br>
		<input type="submit" value="次へ" name="_event_proceed">
	</div>
</form:form>

</body>
</html>
