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

	<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/changeRole/exec" id="mainForm">
		
		<div class="container">
			<c:if test="${not empty rootData.common.mainMessage}">
				<div class="col-md-10 col-md-offset-1">
					<div class="alert alert-info" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<span class="sr-only">Error:</span>
		        		<form:input type="hidden" path="common.mainMessage"></form:input>
						<c:out value="${rootData.common.mainMessage}"></c:out>
					</div>
				</div>
			</c:if>
		</div>
		
		<div class="container">
			<h1>Group Change Role Page</h1>
			<br>
			<div class="col-md-5">
				<div id="main">
					
					
					
					<div>
						<label>Group Name</label>
						<form:select path="group.slctGroupName" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/changeRole/tmp')" class="form-control">
							<option value="">
							<c:if test="${not empty rootData.groupNameList}">
								<c:forEach var="list" items="${rootData.groupNameList}">
									<option value="${list}" <c:if test="${rootData.group.slctGroupName == list}">selected</c:if>>
										<c:out value="${list}"/>
									</option>
								</c:forEach>
							</c:if>
						</form:select>
						<br>
					</div>
				</div>
			</div>
		</div>
	
		<div class="container">
			<div class="col-md-3">
				<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
					<c:set var="listElem" value="${sts.current}"></c:set>
					<tr>
						<td><label><c:out value="${list.userName}" /></label></td>
						<td>
						<form:select path="group.memberList[${sts.index}].slctRoleId" class="form-control">
							<c:forEach var="list_a" items="${list.roleList}" >
								<option value="${list_a.roleId}" <c:if test="${listElem.slctRoleId == list_a.roleId}">selected</c:if>>
									<c:out value="${list_a.roleName}"></c:out>
								</option>
							</c:forEach>
						</form:select>
						</td>
					</tr>
					<br>
				</c:forEach>
			</div>
		</div>
		
		<div class="container">
			<div class="col-md-3">			
				<br>
				<input type="button" value="Change Role" id="groupCreateBtn" onclick="submitProc('mainForm')" class="btn btn-success">
	
			</div>
		</div>

	</form:form>
	
</body>
</html>
