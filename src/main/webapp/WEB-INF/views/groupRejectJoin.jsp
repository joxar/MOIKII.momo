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
<h1>Group Reject Page</h1>
<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/rejectJoin/exec" id="mainForm">
	<div id="main">
		<div>
			<form:input type="hidden" path="common.mainMessage"></form:input>
			<c:out value="${rootData.common.mainMessage}"></c:out>
		</div>
		<div id="reqList">
			<table>
				<thead>
					<tr>
						<td>☑️️</td>
						<td>GroupName</td>
						<td>Requster</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list_1" items="${rootData.groupList}" varStatus="sts_1">
						<c:set var="list_1elem" value="${sts_1.current}"></c:set>
						<c:forEach var="list_2" items="${list_1elem.requesterList}" varStatus="sts_2">
							<tr>
								<td><input type="checkbox"></td>
								<td><c:out value="${list_1.groupName}" /></td>
								<td><c:out value="${list_2.userName}" /></td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="button" value="REJECT!!" id="groupCreateBtn" onclick="submitProc('mainForm')">
		<br><br><br>
		<input type="button" value="BACK" id="loginBtn" onclick="login()">
	</div>
</form:form>

</body>
</html>
