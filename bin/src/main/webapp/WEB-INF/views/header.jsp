<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- ナビゲーションバー -->
<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<input type="text" value="${rootData.view.viewID}" />
				<c:if test="${rootData.view.viewID != 'V000'}">
					<a class="navbar-brand"	href="${pageContext.request.contextPath}/twt/group/0">MOIKII.momo</a>
				</c:if>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/group/create/init">groupCreate</a></li>
							<li><a href="${pageContext.request.contextPath}/group/information/init">groupShowInfo</a></li>
							<li><a href="${pageContext.request.contextPath}/group/request/init">requestJoin</a></li>
							<li><a href="${pageContext.request.contextPath}/group/approval/init">rejectJoin</a></li>
							<li><a
								href="${pageContext.request.contextPath}/group/changeRole/init">changeRole</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> 
							<strong><sec:authentication	property="principal.username" /></strong> <span
							class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/logout">Sign
									out</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</div>
</div>