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
	<jsp:include page="header.jsp"></jsp:include>
   
   <div class="container">
   　　　<div class="row">
	
	<!-- プロフィールサイドバー -->
	<div class="col-md-2">
		<div class="media">
			<img src="${pageContext.request.contextPath}/profile/download/<sec:authentication	property="principal.username" />"
					class="media-object" width="120" height="120">
			<div class="profile-usertitle">
				<div class="profile-usertitle-name" style="text-align:center">
					<a href="#"><sec:authentication property="principal.username" /></a>
				</div>
			</div>
			<div class="profile-usermenu">
			   <h4>Groups</h4>
				<ul class="nav nav-pills nav-stacked">
				<li role="presentation" ><a id ="listx" href="${pageContext.request.contextPath}/twt/group/0">ALL</a></li>
					<c:if test="${not empty rootData.user.groupList}">
						<c:forEach items="${rootData.user.groupList}" var="list"  varStatus="loop" >
							<li role="presentation" >
								<a href="${pageContext.request.contextPath}/twt/group/${list.groupId}"><c:out value="${list.groupName}"/></a>
							</li>
						</c:forEach>
				    </c:if>
				</ul>
			</div>
		</div>
	</div>
	
   
	<!-- コメント投稿フォーム -->
		<div class="col-md-8">
			<table class="table table-hover" id="board">
				<thead>
					<tr>
						<td colspan="2">
	 						<form:form id="postForm" modelAttribute="rootData" action="${pageContext.request.contextPath}/twt/post" >
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
									<td class="momoComment">
										<div class="media">
											<a class="pull-left" href="#">
											<img class="media-object" src="${pageContext.request.contextPath}/profile/download/${list.createName}"
													class="img-rounded" width="80" height="80"/>
											</a>
											<div class="media-body">
												 <input type="hidden" class="hiddenId" value="${list.momoNum}"/>
												 <c:out value="${list.createName}"/>
												 <p class="text-left">
												 	<span class="contents">${list.momo_contents}</span>
												 </p>
												 <p class="text-right">
												 	<small><c:out value="${list.create_date}"/></small>
												 </p>
												 <p class="text-right">
												 	<small>
												 	    <c:if test="${list.childCount == -1}" var="flg" />
												 	    <c:if test="${flg}">
												 			<a class="reply-link" >コメントする</a>
												 		</c:if>
												 		<c:if test="${!flg}">
												 			<c:forEach items="${list.childList}" var="list_child" begin="0" end="${list.childCount}">
												 				 <div class="replyComment">
																	<div class="media">
																		<a class="pull-left" href="#">
																			<img class="media-object" src="${pageContext.request.contextPath}/profile/download/${list_child.createName}"
																					class="img-rounded" width="80" height="80"/>
																		</a>
																		<div class="media-body">
																			<p class="text-left">
																				 <c:out value="${list_child.createName}"/>
																			</p>
																			<p class="text-left">
																				<span class="replyContents">${list_child.return_contents}</span>
																			</p>
																			 <p class="text-right">
																				<small><c:out value="${list_child.create_date}"/></small>
																			</p>
																		</div>
																	</div>
															        </div>
															        <input type="hidden" class="hiddenId" value="${list_child.momo_momo_num}"/>
												 			</c:forEach>
												 				<div name="replyForm" class="replyForm">		
																	<textarea name="replyContent" class="form-control" rows="5"></textarea>
																	<div align="right">
																		<button name="replyButton" class="btn btn-primary">send message!</button>
																	</div>
																</div>
												 		</c:if>
												 	</small>
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
	</div>	
	</div>
	<!-- 返信コメントの描画に使うテンプレート -->
	<script type="text/html" id="tmplReplyComment">
        <div class="replyComment">
		<div class="media">
			<a class="pull-left" href="#">
				<img class="media-object" src="${pageContext.request.contextPath}/profile/download/{{name}}"
						class="img-rounded" width="80" height="80"/>
			</a>
			<div class="media-body">
				<p class="text-left">
					{{name}}
				</p>
				<p class="text-left">
					<span class="replyContents">
						{{contents}}
					</span>
				</p>
				 <p class="text-right">
					<small>{{time}}</small>
				</p>
			</div>
		</div>
        </div>
		<input type="hidden" class="hiddenId" value="{{momoNum}}"/>
	</script>
	<!-- 返信フォームの描画に使うテンプレート -->
	<script type="text/html" id="tmplReplyForm">
		<div name="replyForm" class="replyForm">		
			<textarea name="replyContent" class="form-control" rows="5"></textarea>
			<div align="right">
				<button name="replyButton" class="btn btn-primary">send message!</button>
			</div>
		</div>
	</script>
	<!-- 投稿コメントの描画に使うテンプレート -->
	<script type="text/html" id="tmplComment">
		<tr style="height:80">
			<td class="momoComment">
				<div class="media">
					<a class="pull-left" href="#">
						<img class="media-object" src="${pageContext.request.contextPath}/profile/download/{{name}}"
								class="img-rounded" width="80" height="80"/>
					</a>
					<div class="media-body">
						<input type="hidden" class="hiddenId" value="{{momoNum}}"/>
							{{name}}
						<p class="text-left">
							<span class="contents">
								{{contents}}
							</span>
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
