<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page session="false"%>

<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
               <a class="navbar-brand" href="${pageContext.request.contextPath}/twt">MOIKII.momo</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
               <ul class="nav navbar-nav">
                  <li class="dropdown">
                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <b class="caret"></b></a>
                     <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/group/create/init">groupCreate</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/showInfo/init">groupShowInfo</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/reqJoin/init">requestJoin</a></li>
                        <li><a href="${pageContext.request.contextPath}/group/rejectJoin/init">rejectJoin</a></li>
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

	<div class="container main-content">
		<table class="table table-bordered table-hover" id="board">
			<thead>
				<tr>
					<td colspan="2">
 						<form:form id="postForm" modelAttribute="rootData" action="${pageContext.request.contextPath}/twt/json" >
						    <div class="form-group">
							    <form:textarea class="form-control" rows="5" id="postContents" path="momo.momo_contents"></form:textarea>
								    <div align="right">
									    <button id="post" class="btn btn-primary">send message!</button>
								    </div>
							</div>
						</form:form>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr id="dummy">
					<c:if test="${not empty rootData.momoList}">
						<c:forEach items="${rootData.momoList}" var="list" begin="${start}" end="${end}">
							<tr style="height:80"><td><c:out value="${list.momo_contents}"/></td></tr>
						</c:forEach>
					</c:if>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- ******** js ******** -->
	<spring:url var="twtJs" value="/resources/js/twt.js" />
	<script type="text/javascript" src="${twtJs}"></script>
</body>
</html>