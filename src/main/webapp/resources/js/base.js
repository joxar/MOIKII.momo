function init() {
//	alert("base.js has been called");
}
window.onload = init;

function login() {
	submitProc();
};

function submitProc() {
	var formData = document.getElementById("mainForm");
	formData.submit();
}

function showDBData() {
	submitProc();
}


