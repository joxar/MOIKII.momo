<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- ******** css ******** -->
<!-- lib css -->
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/base.css" />' />

	<title>kt_sandbox</title>

<h1>
	Sandbox of TK
</h1>
	back to the top
	<br /><br />
	
	<script>
	function test() {
		var url = "/app/aaa";
		window.showModalDialog(url, this);
		window.open
	}
	
	</script>
	<input type="button" value="てすと" onclick="test()" />
	
	
	
	
	
	
	
	<dl>
	<dt>PLACE HOLDER</dt>
	<dd>
		<form:form modelAttribute="placeAttrModel" action="${pageContext.request.contextPath}/">
			<input type="text" placeholder="text box using palceholder attribute">
			<spring:url var="test1_1Url" value="/test1-1" />
		</form:form>
	</dd>
	
	<dt>PROGRESS BAR</dt>
	<dd>
		<progress max="100" value="80">80%</progress>
		<br /><br />
	</dd>

	<dt>SECTION</dt>
	<dd>
		<section>
	  	<h1>aaa</h1>
			<p>xxx</p>
	  	<h1>bbb</h1>
			<p>yyy</p>
    	</section>
    	<br />
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
	<dt>COLOR TYPE INPUT</dt>
	<dd>
	  <input type="color" placeholder="#000">
	  <br /><br />
	</dd>
	<dt>RANGE TYPE INPUT</dt>
	<dd>
	  thin<input type="range" placeholder="50">thick
	  <br /><br />
	</dd>
	<dt>RESET/SUBMIT TYPE INPUT</dt>
	<dd>
		<input type="reset" value="RESET"><input type="submit" value="SUBMIT">
		<br /><br />
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

	</dl>
	
	<dt>TELEPHONE NUMBER</dt>
	<dd>
		<p><a href="tel:000-00000">000-1111</a></p>
	</dd>

	<p contextmenu="countup" id="hello">Hello HTML5 Technique Bible</p>
	
	<!-- 
	<menu type="context" id="countup">
	  <menuitem label="count up num of characters which in the selected string" onclick="countup('char')"></menuitem>
	  <menuitem label="count up num of words which in the selected string" onclick="countup('word')"></menuitem>
	</menu>
	-->
	
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
