<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container" style="margin-top:20px">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading"><h3 class="panel-title"><strong>Profile </strong></h3></div>
				<div class="panel-body">
					<form:form action="${pageContext.request.contextPath}/profile/upload" method="post"
							modelAttribute="profileImageBean" enctype="multipart/form-data">
  
						<div class="media">
							<figure>
								<figcaption>Profile picture</figcaption>
								<a class="pull-left" href="#">				
									<img class="media-object" src="<c:url value='/resources/bootstrap-3.3.2-dist/profile.png'/>"
											class="img-rounded" width="80" height="80"  title="Profile picture"/>
								</a>
							</figure>
							<div class="media-body">
								<form:input type="file" path="file" />
							</div>
						</div> 
						<br>
						<form:button class="btn btn-success">Update profile</form:button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
