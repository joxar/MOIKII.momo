<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>

<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- ******** css ******** -->
<spring:url value="/resources/css/base.css" var="baseCss" />
<link rel="stylesheet" type="text/css" href="${baseCss}">
<!-- ******** js ******** -->
<spring:url value="/resources/js/base.js" var="baseJs" />
<script type="text/javascript" src="${baseJs}"></script>

	<title>dbAccessMock</title>
</head>
<body>
<h1>
	dbAccessMock
</h1>
<P>  The time on the server is ${serverTime}. </P>

	<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/dbAccessMock/show" id="mainForm">
	
	<div id="authMain">
		<form:select path="dbacMock.selectedTBL">
			<option value="0"></option>
			<option value="1">SET UP TEST_TBL</option>
			<option value="2">SHOW ALL</option>
		</form:select>

		<input type="button" value="EXECUTE" id="dbacMock" onclick="showDBData()">
		
		<table>
		<c:forEach items="${rootData.dbacMock.testDataList}" var="list" varStatus="status">
			<tr style="border:1px solid black">
				<td style="border:1px solid black"><c:out value="${list.col1}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col2}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col3}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col4}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col5}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col6}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col7}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col8}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col9}" /></td>
				<td style="border:1px solid black"><c:out value="${list.col10}" /></td>
			</tr>
		</c:forEach>
		</table>
		
		</div>

	</form:form>

</body>
</html>
