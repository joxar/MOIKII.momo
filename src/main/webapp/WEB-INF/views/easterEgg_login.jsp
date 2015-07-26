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
<spring:url var="baseCss" value="/resources/css/base.css" />
<link rel="stylesheet" type="text/css" href='${baseCss}' />

<style type="text/css">
<!--
body { margin-top:30px; }
#login-nav input { margin-bottom: 15px; }
//-->
</style>
<!-- Bootstrap -->
<spring:url var="bootstrapCss" value="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href='${bootstrapCss}' />

<!-- ******** js ******** -->
<!-- jQuery -->
<spring:url var="jqueryJs" value="/resources/js/jquery-2.1.1.min.js" />
<script type="text/javascript" src="${jqueryJs}"></script>
<!-- Bootstrap -->
<spring:url var="bootstrapJs" value="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js" />
<script type="text/javascript" src="${bootstrapJs}"></script>

<title>MOIKII.momo</title>

</head>

<body>

	<div class="container">
		<div class="wrap" style="width:410px; float:left;">
			<div class="type-wrap">
		       	<span id="typed" style="white-space:pre;"></span>
	   		</div>
   		</div>
   		
        <div id="systemFullName">
        	<h1>
            	<span class="capitalLetter">M</span><span class="lowerLetter">ake </span>
            	<br>
            	<span class="capitalLetter">O</span><span class="lowerLetter">bstructions </span>
            	<br>
                <span class="capitalLetter">I</span><span class="lowerLetter">nto </span>
                <br>
                <span class="capitalLetter">K</span><span class="lowerLetter">eys for</span>
                <br>
                <span class="capitalLetter">I</span><span class="lowerLetter">nnovation and </span>
                <br>
                <span class="capitalLetter">I</span><span class="lowerLetter">mpact</span>
                <br>
			</h1>
			<br>
			<div style="text-align: right;">
				<a href="${pageContext.request.contextPath}/login" id="formId" style="text-decoration: underline;">MOIKII.momo</a>
            </div>
	    </div>
	    
	</div>    
</body>


<spring:url var="typedJs" value="/resources/js/typed.js" />
<script type="text/javascript" src="${typedJs}"></script>

<script>
var canvas = ".type-wrap";
var canvasArea = ".wrap";
var sysName = "#systemFullName";
var typedCursor = ".typed-cursor";
var lowerLetter = ".lowerLetter";

$(function(){
	
	$("#formId").submit();
	
	
	$(sysName).hide();
	$(lowerLetter).hide();

	$(canvas).typed({
		strings: ["acquire IT knowledges by working and studying . . . . . ?", "Start MOIKII↵"],
        typeSpeed: 80,
        backDelay: 80,
        loop: false,
        contentType: 'html', // or text
        // defaults to false for infinite loop
        loopCount: false,
        callback: function(){ window.setTimeout(newTyped(), 8000); },
        resetCallback: function() {}
	});
});

function hideElem(obj) {
	$(obj).hide();
}

function newTyped() {
	hideElem(canvas);	
	hideElem(canvasArea);
	$(sysName).fadeIn(800);
	window.setTimeout(function() {
		   $(lowerLetter).each(function(i) {
			   $(this).delay(1200 * i).fadeIn(2000);
		   })},
		   1000
	);
}
</script>
<style>
.container {	
	width: 1000px;  
    margin: 200px;
    text-align: left;
}
#systemFullName {
    margin: 0 0 0 280px;
}
#systemFullName H1 span {
	margin: -0.4em;
	font-family: monospace;
	font-size: 48px;
	letter-spacing: 0.1em;
	
}
#systemFullName H1 .capitalLetter {
	margin: 0 20px 0 1px;
	color: #1d9cff;
}
#systemFullName H1 .lowerLetter {
    color: #909090;
}
#systemFullName H1 .initspace {
    flaot: left;
    margin: 0 0 0 40px;
}
.wrap{
	max-width: 500px;
	margin: 50px 290px 50px 290px;
	padding: 15px;
	background:#f0f0f0;
	border-radius:5px;
	border:#CCC 1px solid;
}
.type-wrap{
	height: auto;
	float: left;
}


        /* code for animated blinking cursor */
        .typed-cursor{
            opacity: 1;
            font-weight: 100;
            -webkit-animation: blink 0.7s infinite;
            -moz-animation: blink 0.7s infinite;
            -ms-animation: blink 0.7s infinite;
            -o-animation: blink 0.7s infinite;
            animation: blink 0.7s infinite;
        }
        @-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-webkit-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-moz-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-ms-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-o-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
    </style>
    
</html>
