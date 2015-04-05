<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ******** css ******** -->
<!-- lib css -->
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/base.css" />' />

<title>Home</title>

	<!-- ******** header.jsp ******** -->
	<jsp:include page="header.jsp" flush="true" />

	<!-- ******** side.jsp(left) ******** -->
	<jsp:include page="side.jsp" flush="true" />

	<!-- ******** footer.jsp ******** -->
	<jsp:include page="footer.jsp" flush="true" />

	<div id="contentsArea">
		<h1>HOME</h1>
		<P>The time on the server is ${serverTime}.</P>

		<div id="tk">
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/tk_sandbox">
			<spring:url var="kt_sandbox_Url" value="/tk_sandbox" />
			<input id="moveBtn" type="submit" value="tk-sandbox" />
		</form:form>
		
		<div id="auth">
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/login_init/">
			<spring:url var="login_Url" value="/login_init/" />
			<input id="moveBtn" type="submit" value="login_Url" />
		</form:form>

		<div id="dbAccess">
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/dbAccessMock/init">
			<spring:url var="dbAccessMock_Url" value="/dbAccessMock" />
			<input id="moveBtn" type="submit" value="dbAccessMock_Url" />
		</form:form>

		<p>Click a button to jump!</p>
		<div id="jumpList">
			↓
			<div id="layer1">
			<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/test1">
				<spring:url var="test1Url" value="/test1" />
				<input id="moveBtn" type="submit" value="1" />
			</form:form>
			</div>
			↓　　　　　　　　　↓
			<div id="layer2">
			<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/test1_1">
				<spring:url var="test1_1Url" value="/test1-1" />
				<input id="moveBtn" type="submit" value="1-1" />
			</form:form>
			<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/test1_2">
				<spring:url var="test1_2Url" value="/test1_2" />
				<input id="moveBtn" type="submit" value="1-2" />
			</form:form>
			</div>
			　　　　　　　　　　↓			
			<div id="layer3">
			<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/test1_2_1">
				<spring:url var="test1_2_1Url" value="/test1_2_1" />
				<input id="moveBtn" type="submit" value="1-2-1" />
			</form:form>
			</div>
			</div>
</div>
			</div>
			
		</div>
	</div>
