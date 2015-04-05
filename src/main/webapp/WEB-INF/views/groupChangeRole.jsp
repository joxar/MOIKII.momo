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
<h1>Group Change Role Page</h1>
<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/changeRole/exec" id="mainForm">
	<div id="main">
		<div>
			<form:input type="hidden" path="common.mainMessage"></form:input>
			<c:out value="${rootData.common.mainMessage}"></c:out>
		</div>
		
		<div>
			<c:out value="Group Name" />
			<form:select path="group.slctGroupId" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/changeRole/tmp')">
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

		<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
			<c:set var="listElem" value="${sts.current}"></c:set>
			<tr>
				<td><c:out value="${list.userName}" /></td>
				<td>
					<form:select path="">
						<c:forEach var="list_a" items="${rootData.constants.roleNameList}">
							<option>
								<c:out value="${list_a}"><c:if test="${list.roleName == list_a}">selected</c:if></c:out>
							</option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<br>
		</c:forEach>
	</div>
	<input type="button" value="OK" id="groupCreateBtn" onclick="submitProc('mainForm')">
	<br><br><br>
	<input type="button" value="BACK" id="loginBtn" onclick="login()">
</form:form>

</body>
</html>
