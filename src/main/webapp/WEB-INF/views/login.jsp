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

<title>MOIKII.momo</title>

</head>

<body>
	<!-- ナビゲーションバー -->


	<div class="container" style="margin-left:110px">
		<c:if test="${param.error}">
			<div class="col-md-10 col-md-offset-1">
				<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				<span class="sr-only">Error:</span>
		        Incorrect username or password.
				</div>
			</div>
		</c:if>
	</div>
	
	<div class="container" style="margin-top:40px">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default">
				<div class="panel-heading"><h3 class="panel-title"><strong>Sign In </strong></h3></div>
				<div class="panel-body">
					<form:form modelAttribute="rootData" role="form" name="login_form" action="${pageContext.request.contextPath}/authentication" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Username or Email</label>
						<input type="text" name="j_username" class="form-control" id="exampleInputEmail1" >
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password <a href="/sessions/forgot_password">(forgot password)</a></label>
						<input type="password" name="j_password" class="form-control" id="exampleInputPassword1" >
					</div>
						<button type="submit" class="btn btn-default">Sign in</button>
				</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
