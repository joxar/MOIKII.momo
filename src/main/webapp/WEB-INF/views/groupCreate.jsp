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
<h1>Group Create Page</h1>
<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/create/exec" id="mainForm">
	<div id="main">
		<div>
			<form:input type="hidden" path="common.mainMessage"></form:input>
			<form:label path="common.mainMessage"></form:label>
		</div>
		<div>
			<c:out value="GroupName: "/><form:input path="group.groupName" type="text"></form:input>
		</div>
		<div>
		<c:out value="Development Category: "/>
		<form:select path="group.slctDevCateId" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/create/tmp')">
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
		<div id="phList">
			<form:input type="hidden" path="group.devCategory.phNameList"></form:input>
			<c:forEach var="list" items="${rootData.group.devCategory.phNameList}" varStatus="sts">
				<c:set var="idx" value="${sts.index}" />
				<input type="button" value="${list}">
				<c:if test="${!sts.last}"> -> 
					<a href="#" onclick="showOrHideTriggerOn('hiddenObj_${idx}', 'show')">+</a>
					<form:select class="hiddenObj_${idx}" path="group.slctDevCateId" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/create/tmp')">
						<c:if test="${not empty rootData.group.devCategoryList}">
							<c:forEach var="list" items="${rootData.group.devCategory.phNameList}">
								<option value="${list}">
								<c:out value="${list}" />
								</option>
							</c:forEach>
						</c:if>
					</form:select>
					<label class="hiddenObj_${idx}">-> </label>
					<a class="hiddenObj_${idx}" href="#" onclick="showOrHideTriggerOn('hiddenObj_${idx}', 'hide')">-</a>
					<a class="hiddenObj_${idx}" href="#">+</a>
				</c:if>
			</c:forEach>
			
		</div>
		<div id="memberList">
			<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
				<c:out value="${list.userName}"></c:out>
			</c:forEach>
		</div>
		<br>
		<input type="button" value="CREATE" id="groupCreateBtn" onclick="jumpProc()">
		<br><br><br>
		<input type="button" value="BACK" id="loginBtn" onclick="login()">
	</div>
</form:form>

</body>
</html>
