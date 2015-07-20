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

	<div class="row">
      <div class="col-md-12">
         <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="${pageContext.request.contextPath}/twt/group/0">MOIKII.momo</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <b class="caret"></b></a>
                     <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/group/create/init">groupCreate</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/information/init">groupShowInfo</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/request/init">requestJoin</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/approval/init">rejectJoin</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/changeRole/init">changeRole</a></li>
                     </ul>
                  </li>
               </ul>
               <ul class="nav navbar-nav navbar-right">
                   <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong><sec:authentication property="principal.username" /></strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    	<ul class="dropdown-menu">
                    		<li>
                    			<a href="${pageContext.request.contextPath}/logout">Sign out</a>
                    		</li>
                    	</ul>
                    </li>
               </ul>
            </div>
         </nav>
       </div> 
   </div>


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
							<td><form:checkbox path="joinRequestList[${sts.index}].checkRequest" /></td>
							<td><c:out value="${list.requestGroup.groupName}" /></td>
							<td><c:out value="${list.requester.userName}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="submit" value="Approve" name="_approve" class="btn btn-success">
		<br><br><br>
		<input type="submit" value="Refuse" name="_refuse" class="btn btn-success">
	</div>
	</div>
</form:form>

</body>
</html>
