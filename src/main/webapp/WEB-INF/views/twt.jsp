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
<!-- underscore -->
<spring:url var="underscoreJs" value="/resources/js/underscore-min.js" />
<script type="text/javascript" src="${underscoreJs}"></script>

<title>MOIKII.momo</title>
</head>

<body>
   <!-- ナビゲーションバー -->
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
   
	<!-- コメント投稿フォーム -->
	<div class="container main-content">
		<table class="table table-hover" id="board">
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
				<!-- ここに投稿コメントを表示 -->
				<tr id="dummy">
					<c:if test="${not empty rootData.momoList}">
						<c:forEach items="${rootData.momoList}" var="list" begin="${start}" end="${end}">
							<tr style="height:80">
								<td>
									<div class="media">
										<a class="pull-left" href="#">
										<img class="media-object" src="<c:url value='/resources/bootstrap-3.3.2-dist/profile.png'/>"
												class="img-rounded" width="80" height="80"/>
										</a>
										<div class="media-body">
											 <c:out value="${list.createName}"/>
											 <p class="text-left">
											 	<c:out value="${list.momo_contents}"/>
											 </p>
											 <p class="text-right">
											 	<small><c:out value="${list.create_date}"/></small>
											 </p>
											 <p class="text-right">
											 	<small><a class="reply-link" >コメントする</a></small>
											 </p>
									     </div>
									 </div>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tr>
			</tbody>
		</table>		
	</div>
	<!-- 返信コメントの描画に使うテンプレート -->
	<script type="text/html" id="tmplReplyComment">
        <div class="replyComment">
		<div class="media">
			<a class="pull-left" href="#">
				<img class="media-object" src="<c:url value='/resources/bootstrap-3.3.2-dist/profile.png'/>"
						class="img-rounded" width="80" height="80"/>
			</a>
			<div class="media-body">
				<p class="text-left">
					{{name}}
				</p>
				<p class="text-left">
					{{contents}}
				</p>
				 <p class="text-right">
					<small>{{time}}</small>
				</p>
			</div>
		</div>
        </div>
	</script>
	<!-- 返信フォームの描画に使うテンプレート -->
	<script type="text/html" id="tmplCommentBox">
		<div name="replyForm" class="replyForm">		
			<textarea name="replyContent" class="form-control" rows="5"></textarea>
			<div align="right">
				<button name="replyButton" class="btn btn-primary">send message!</button>
			</div>
		</div>
	</script>
	<!-- 投稿コメントの描画に使うテンプレート -->
	<script type="text/html" id="tmplString">
		<tr style="height:80">
								<td>
									<div class="media">
										<a class="pull-left" href="#">
										<img class="media-object" src="<c:url value='/resources/bootstrap-3.3.2-dist/profile.png'/>"
												class="img-rounded" width="80" height="80"/>
										</a>
										<div class="media-body">
											 {{name}}
											 <p class="text-left">
											 	{{contents}}
											 </p>
											 <p class="text-right">
											 	<small>{{time}}</small>
											 </p>
											 <p class="text-right">
											 	<small><a class="reply-link" >コメントする</a></small>
											 </p>
									     </div>
									 </div>
								</td>
							</tr>
	</script>
	<!-- ******** js ******** -->
	<spring:url var="twtJs" value="/resources/js/twt.js" />
	<script type="text/javascript" src="${twtJs}"></script>
</body>
</html>
