function init() {
	var pullDownObj = document.getElementsByClassName("option");
	for (var i=0; i<pullDownObj.length; i++) {
		alert(pullDownObj[i].value);
		if (pullDownObj[i].value !== "") {
			pullDownObj[i].setAttribute("selected", true);
			alert(pullDownObj[i]);
		}
	}
}

function showOrHideTriggerOn(className, showOrHide) {
	var targets = document.getElementsByClassName(className);
	if (showOrHide === "show") {
		for (var i=0; i<targets.length; i++) {
			targets[i].style.display="block";
		}
	} else if (showOrHide === "hide") {
		for (var i=0; i<targets.length; i++) {
			targets[i].style.display="none";
		}
	}
}

window.onload = init;

function login(formName) {
	submitProc(formName);
};

function submitProc(formName) {
	var formData = document.getElementById(formName);
	formData.submit();
}

function submitProc2(formName, url) {
	var formData = document.getElementById(formName);
	formData.setAttribute("action", url);
	formData.submit();
}

function jumpProc() {
	var formData = document.getElementById("mainForm");
	formData.submit();
}

function showDBData() {
	submitProc();
}

function pullDownSelect(slctObj, url) {
	var slctVal = slctObj.options[slctObj.selectedIndex].value;
	slctObj.value=slctVal;
	submitProc2("mainForm", url);
}
