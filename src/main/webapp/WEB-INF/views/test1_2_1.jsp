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
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/base.css" />' />

	<title>Home</title>
</head>
<body>
<h1>
	test1_2_1
</h1>
<P>  The time on the server is ${serverTime}. </P>

<p>Page list</p>

	<div id="jumpList">
		↓
		<div id="layer1">
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/test1_2_1">
			<spring:url var="test1_2_1Url" value="/test1_2_1" />
			<input type="text" size="30" onClick="formSubmit(${test1_2_1Url})" />
			<input id="moveBtn" type="submit" value="1-2-1" />
		</form:form>
		</div>
	</div>
	
	
	<!-- 
	<li>
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/">
			<spring:url var="homeUrl" value="/" />
			<input type="text" size="30" onClick="formSubmit(${homeUrl})" />
			<input id="moveBtn" type="submit" value="-> HOME" />
		</form:form>
	</li>
	 -->

</body>
</html>
