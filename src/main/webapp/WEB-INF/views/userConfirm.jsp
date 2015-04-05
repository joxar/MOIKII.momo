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
<h1>Confirm your account</h1>
<form method="post">
    <label class="itn_auth">Username </label><c:out value="${createUser.user.userName}" />
    <br>
	<label class="itn_auth">Password </label><c:out value="${createUser.user.userPassword}" />
	<br>
	<input type="submit" value="完了" name="_event_confirmed">
	<input type="submit" value="再入力" name="_event_revise">
</form>
</body>
</html>
