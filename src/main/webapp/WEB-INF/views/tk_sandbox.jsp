<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- ******** css ******** -->
<!-- lib css -->
<spring:url var="bootStrapCss" value="/resources/bootstrap-3.3.2-dist/css/bootstrap.css" />
<spring:url var="bootStrapThemeCss" value="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.css" />
<spring:url var="moikiiBaseCss" value="/resources/css/base.css" />
<spring:url var="tkBaseCss" value="/resources/css/tk_sandbox.css" />
<link rel="stylesheet" type="text/css" href="${bootStrapCss}" />
<link rel="stylesheet" type="text/css" href="${bootStrapThemeCss}" />
<link rel="stylesheet" type="text/css" href="${moikiiBaseCss}" />
<link rel="stylesheet" type="text/css" href="${tkBaseCss}" />
<!-- ******** js ******** -->
<spring:url var="jqueryJs" value="/resources/js/jquery-2.1.1.min.js" />
<spring:url var="bootStrapJs" value="/resources/bootstrap-3.3.2-dist/js/bootstrap.js" />
<spring:url var="bootStrapNpmJs" value="/resources/bootstrap-3.3.2-dist/js/npm.js" />
<script type="text/javascript" src="${jqueryJs}"></script>
<script type="text/javascript" src="${bootStrapJs}"></script>
<script type="text/javascript" src="${bootStrapNpmJs}"></script>

<!-- ******** TITLE ******** -->
<title>kt_sandbox</title>
<!-- ******** include JSP ******** -->
<jsp:include page="header.jsp" flush="true" />
<jsp:include page="side.jsp" flush="true" />

<h1>
	Sandbox of TK
</h1>
<script>
	function test() {
		var url = "/app/";
		window.showModalDialog(url, this);
		window.open
	}
</script>

<!-- ******** Tab menu ******** -->
<ul class="nav nav-tabs" id="menuList">
	<li class="active"><a href="#tab1" data-toggle="tab">Home</a></li>
	<li><a href="#tab2" data-toggle="tab">Profile</a></li>
	<li><a href="#tab3" data-toggle="tab">Messages</a></li>
</ul>

<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade in active" id="tab1">
		<input type="button" class="btn btn-primary btn-lg" value="Home" onclick="test()" />
	</div>

	<div class="tab-pane fade" id="tab2">
	 	<dl>
			<dt>PLACE HOLDER</dt>
			<dd>
				<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/" class="form-search">
					<input type="text" class="input-medium search-query" placeholder="placeholder!!!">
				</form:form>
			</dd>
	
			<dt>PROGRESS BAR</dt>
			<dd>
				<progress max="100" value="80">80%</progress>
				<br /><br />
			</dd>
	
			<dt>CALENDAR TYPE INPUT</dt>
			<dd>
		  		<input type="date" placeholder="2014/01/01" required autofocus>
				<br /><br />
	    	</dd>
	       
			<dt>MAIL TYPE INPUT</dt>
			<dd>
		  		<input type="email" placeholder="aaa@bbb.co.jp">
				<br /><br />
			</dd>
		</dl>
	</div>
	
	<div class="tab-pane fade in" id="tab3">
		<dl>
			<dt>COLOR TYPE INPUT</dt>
			<dd>
			  <input type="color">
			  <br /><br />
			</dd>
	
			<dt>RANGE TYPE INPUT</dt>
			<dd>
				thick<input type="range" placeholder="50" style="width:200px;">
			</dd>
			
			<dt>RESET/SUBMIT TYPE INPUT</dt>
			<dd>
				<input type="reset" value="RESET"><input type="submit" value="SUBMIT">
			</dd>
		
			<dt>FOR TEXT EDITING</dt>
			<dd>
				<textarea rows="3" cols="10" required></textarea>
				<button onclick="document.execCommand('bold')">太字</button>
				<button onclick="document.execCommand('forecolor', false, forecolor.value)">文字色</button>
				<input id="forecolor" type="color" value="#000000">
				<button onclick="document.execCommand('backcolor', false, backcolor.value)">背景色</button>
				<input id="backcolor" type="color" value="#FFFFFF">
				<button onclick="document.execCommand('fontsize', false, fontsize.value)">文字サイズ</button>
				<input id="fontsize" type="number" value="3" min="1" max="7">
			</dd>
	
			<dt>TELEPHONE NUMBER</dt>
			<dd>
				<p><a href="tel:000-00000">000-1111</a></p>
			</dd>
		</dl>
	</div>
</div>
		
	<script>
	  function countup(type) {
	    var text = document.getSelection().toString();
	    if (type == 'char') {
	      alert('char: '+text.length);
	    } else if (type = 'word') {
	      alert('word: '+text.split(/\s/).length);
	    }
	  }
	</script>
