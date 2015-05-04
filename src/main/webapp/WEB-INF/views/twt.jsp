<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
body {
	padding-top: 70px;
}
//
-->
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

<title>MOIKII.momo</title>
</head>

<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">MOIKII.momo</a>
		</div>
	</div>

	<div class="container main-content">
		<table class="table table-bordered table-hover" id="board">
			<thead>
				<tr>
					<td colspan="2">
 						<form:form id="postForm" modelAttribute="root" action="${pageContext.request.contextPath}/twt/json" >
						    <div class="form-group">
							    <form:textarea class="form-control" rows="5" id="postContents" path="momo.momo_contents"></form:textarea>
								    <div align="right">
									    <button id="post" class="btn btn-primary">send message!</button>
								    </div>
							</div>
						</form:form>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr id="dummy"></tr>
			</tbody>
		</table>
	</div>
	<!-- ******** js ******** -->
	<spring:url var="twtJs" value="/resources/js/twt.js" />
	<script type="text/javascript" src="${twtJs}"></script>
</body>
</html>
