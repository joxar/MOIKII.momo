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
<!-- jQuery UI -->
<link type="text/css" rel="stylesheet"
  href="http://code.jquery.com/ui/1.10.3/themes/cupertino/jquery-ui.min.css" />
<script type="text/javascript"
  src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
  src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<!-- baseJs -->
<spring:url var="baseJs" value="/resources/js/base.js" />
<script type="text/javascript" src="${baseJs}"></script>

<title>MOIKII.momo</title>

</head>

<body>
	<!-- ナビゲーションバー -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<h1>Group Info Page</h1>
		<br>
		<div class="col-md-5" style="width:500px;">
		<form:form modelAttribute="rootData" action="${pageContext.request.contextPath}/group/information/exec" id="mainForm">
			<div id="main">
				<div>
					<form:input type="hidden" path="common.mainMessage"></form:input>
					<c:out value="${rootData.common.mainMessage}"></c:out>
				</div>
				
				<div class="form-group">
					<label>Group Name</label>
					<form:select path="group.slctGroupName" onchange="pullDownSelect(this, '${pageContext.request.contextPath}/group/information/exec')" class="form-control">
						<option value="">
						<c:if test="${not empty rootData.groupNameList}">
							<c:forEach var="list" items="${rootData.groupNameList}">
								<option value="${list}" <c:if test="${rootData.group.slctGroupName == list}">selected</c:if> >
								<c:out value="${list}"/>
								</option>
							</c:forEach>
						</c:if>
					</form:select>
				</div>
				
				<c:if test="${rootData.group.slctGroupName != ''}">
					<table class="table table-hover table-condensed">
					<thead>
						<tr class="info">
							<td colspan="2">Devlopment Category</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2">
							     <c:out value="${rootData.devCategory.devCategoryName}"></c:out>
						     </td>
						</tr>
					</tbody>
					
					<thead>
						<tr class="info">				
							<td colspan="2">Phase</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${rootData.group.devCategory.phNameList}" varStatus="sts">
						<tr>
					 		<td>
					 			<c:out value="[${list}]"></c:out>
					 			<c:if test="${!sts.last}"> -></c:if>
					 		</td>
					 	</tr>
					 	</c:forEach>
					</tbody>
					
					<thead>
						<tr class="info">
							<td colspan="2">Members</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${rootData.group.memberList}" varStatus="sts">
							<tr>
								<td style="width:160px;">
									<select title="Role" class="form-control">
										<!-- GroupManager以外は変更不可やねんで -->
										<option ${!rootData.view.updatable ? "disabled='disabled'" : ''}>(sample)Manager</option>
										<option ${!rootData.view.updatable ? "disabled='disabled'" : ''}>(sample)Developer</option>
									</select>
								</td>
								<td>
									<c:out value="${list.userName}"></c:out>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					
					<thead>
						<tr class="info">				
							<td colspan="2">Requester</td>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td style="text-align:right	;">
								<c:if test="${rootData.view.updatable}">
									<input type="checkbox" />
								</c:if>
							</td>
							<td>(sample)Taro</td>
						</tr>
					</tbody>
					
				</table>
			</c:if>
			
			<div id="btnArea">
				<!-- 更新できるのはManagerの特権 -->
				<c:if test="${rootData.view.updatable}">
					<input type="button" value="UPDATE" id="updateBtn" class="btn btn-success" >
				</c:if>
				<!-- グループ外の人には参加申請ボタンをお渡しする約束 -->
				<c:if test="${rootData.view.requestable_join}">
					<input type="button" value="JOIN" id="joinBtn" class="btn btn-success" >
				</c:if>
			</div>

			</div>
		</form:form>
		</div>
		
		<div id="confirmDialog">
            <p>aaa</p>
        </div>
		
		</div>


</body>
</html>

<style>
table {
	float: left;
	width: 1000px;
}
#btnArea {
	text-align: right;
}
</style>

<script>
$(function() {
	$("#confirmDialog").hide();
});
$("#updateBtn").on("click", function() {
    $('#confirmDialog').dialog({
        autoOpen: true,
        title: 'Confirm Dialog',
        closeOnEscape: false,
        modal: true,
        buttons: {
            "OK": function(){
            $(this).dialog('close');
            }
        }
    });
});
</script>
