<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page session="false"%>

<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ******** css ******** -->
<!-- lib css -->
<spring:url var="baseCss" value="/resources/css/base.css" />
<link rel="stylesheet" type="text/css" href='${baseCss}' />
<style type="text/css">
<!--
body { margin-top:30px; }
#login-nav input { margin-bottom: 15px; }
//-->
</style>
<!-- Bootstrap -->
<spring:url var="bootstrapCss"
	value="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href='${bootstrapCss}' />

<!-- ******** js ******** -->
<!-- jQuery -->
<spring:url var="jqueryJs" value="/resources/js/jquery-2.1.1.min.js" />
<script type="text/javascript" src="${jqueryJs}"></script>
<!-- Bootstrap -->
<spring:url var="bootstrapJs"
	value="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js" />
<script type="text/javascript" src="${bootstrapJs}"></script>
<!-- underscore -->
<spring:url var="underscoreJs" value="/resources/js/underscore-min.js" />
<script type="text/javascript" src="${underscoreJs}"></script>

<title>MOIKII.momo</title>
</head>

<body>
	<spring:url value="/profile/download" var="varBookCoverUrl"/>
	<!-- ナビゲーションバー -->
	<jsp:include page="header.jsp"></jsp:include>
アップロードされました。<br>
ファイルは<br>
<%-- <img src="${rootData.profileImage.binary}" /> --%>
<img src="http://localhost:8080${varBookCoverUrl}"/>
</body>
</html>