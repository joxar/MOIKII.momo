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
<spring:url var="baseJs" value="/resources/js/base.js" />
<script type="text/javascript" src="${baseJs}"></script>

<title>MOIKII.momo</title>

</head>

<body>
	<!-- ナビゲーションバー -->
	<jsp:include page="header.jsp"></jsp:include>

<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/approval/exec" id="mainForm">
	<div class="container">
			<c:if test="${not empty rootData.common.mainMessage}">
				<div class="alert alert-info" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<span class="sr-only">Error:</span>
	        		<form:input type="hidden" path="common.mainMessage"></form:input>
					<c:out value="${rootData.common.mainMessage}"></c:out>
				</div>
			</c:if>
		</div>
		<div class="container">
		<h1>Group Refuse Page</h1>
		<br>
	<div id="main">
		<div id="reqList">
			<table class="table table-striped table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<td><span class="glyphicon glyphicon-check" aria-hidden="true"></span>️</td>
						<td>GroupName</td>
						<td>Requster</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${rootData.joinRequestList}" varStatus="sts">
						<tr>
							<td><form:checkbox path="joinRequestList[${sts.index}].checkRequest" class="chkbox" /></td>
							<td><c:out value="${list.requestGroup.groupName}" /></td>
							<td><c:out value="${list.requester.userName}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="submit" value="Approve" name="_approve" class="btn btn-success" id="approveBtn">
		<br><br><br>
		<input type="submit" value="Refuse" name="_refuse" class="btn btn-success" id="rejectBtn">
	</div>
	</div>
</form:form>

</body>
</html>

<script>
$("#approveBtn, #rejectBtn").on('click', function() {
	var obj = $(".chkbox");
	var flag = false;
	var i=0;	
	var len = obj.length;
	for (i; i<len; i++) {
		if (obj[i].checked == true) {
			flag = true;
		}		
	}
	if (flag) {
		submitProc('mainForm');
	} else {
		alert("Please choose request at least one !");
		return false;
	}
});
</script>

