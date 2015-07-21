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
<!-- baseJs -->
<%-- <spring:url var="baseJs" value="/resources/js/base.js" />
<script type="text/javascript" src="${baseJs}"></script> --%>

<title>MOIKII.momo</title>

</head>

<body>
	<!-- ナビゲーションバー -->
	<jsp:include page="header.jsp"></jsp:include>
   
	<div class="container">
			<h1>Group Create Page</h1>
			<br>
			<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/create/invite" id="mainForm">
			<div id="main">
				<div class="col-md-5">
				<div class="form-group">
					<label for="exampleInputEmail1">GroupName</label>
					<form:input path="group.groupName" type="text" class="form-control" id="exampleInputEmail1"></form:input>
				</div>
				<div class="form-group">
					<label >Development Category</label>
					<form:select class="form-control" path="group.slctDevCateId" >
					<option value="">
					<c:if test="${not empty rootData.group.devCategoryList}">
						<c:forEach var="list" items="${rootData.group.devCategoryList}">
							<option value="${list.devCategoryId}" <c:if test="${rootData.group.slctDevCateId == list.devCategoryId}">selected</c:if>>
								<c:out value="${list.devCategoryId}. ${list.devCategoryName}"/>
							</option>
						</c:forEach>
					</c:if>
					</form:select>
				</div>
				
				<div id="memberList">
					<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
						<c:out value="${list.userName}"></c:out>
					</c:forEach>
				</div>
				<br>
				<input type="submit" value="Create Group" id="groupCreateBtn" class="btn btn-success">
			</div>
			</div>
		</form:form>
	</div>

</body>
</html>

<script>
$("#groupCreateBtn").on('click', function() {
	if ($("#exampleInputEmail1").val() === '') {
		alert("Please input your group name !");
		return false;
	}
});
</script>
