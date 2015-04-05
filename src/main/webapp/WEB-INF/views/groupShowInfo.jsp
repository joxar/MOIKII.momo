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
<h1>Group Info Page</h1>
<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/showInfo/exec" id="mainForm">
	<div id="main">
		<div>
			<form:input type="hidden" path="common.mainMessage"></form:input>
			<c:out value="${rootData.common.mainMessage}"></c:out>
		</div>
		
		<div>
			<c:out value="Group Name" />
			<form:select path="group.slctGroupId" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/showInfo/tmp')">
				<option value="">
				<c:if test="${not empty rootData.groupList}">
					<c:forEach var="list" items="${rootData.groupList}">
						<option value="${list.groupId}" <c:if test="${rootData.group.slctGroupId == list.groupId}">selected</c:if>>
						<c:out value="${list.groupId}. ${list.groupName}"/>
						</option>
					</c:forEach>
				</c:if>
			</form:select>
		</div>
		
		<div id="devCategoryName">
			<c:out value="${rootData.group.devCategory.devCategoryName}"></c:out>
		</div>
		
		<div id="phNameList">
			<c:forEach var="list" items="${rootData.group.devCategory.phNameList}" varStatus="sts">
				<c:out value="[${list}]"></c:out>
				<c:if test="${!sts.last}"> -> </c:if>
			</c:forEach>
		</div>
		
		<div id="memberList">
			<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
				<c:out value="${list.userName}"></c:out>
				<br>
			</c:forEach>
		</div>
		<br>
		
		<input type="button" value="BACK" id="loginBtn" onclick="login()">
	</div>
</form:form>

</body>
</html>
