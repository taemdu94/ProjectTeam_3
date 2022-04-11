
function checkLogin(){
	if(document.frm.userid.value.length===0){
		alert("아이디를 써주세요")
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value===""){
		alert("암호는 반드시 입력해야 합니다.")
		frm.pwd.focus();
		return false;
	}
	return ture;
}

function checkJoin(){
	if(document.frm.name.value.length===0){
		alert("이름를 써주세요")
		frm.name.focus();
		return false;
	}
	if(document.frm.userid.value===""){
		alert("아이디를 써주세요.")
		frm.userid.focus();
		return false;
	}
	if(document.frm.pwd.value===""){
		alert("암호는 반드시 입력해야 합니다.")
		frm.pwd.focus();
		return false;
	}
	return ture;
}

function checkId(){
	if(document.frm.userid.value ==="") {
		alert('아이디를 입력하여 주세요.');
		document.frm.userid.focus();
		return;
	}
	var url = "checkId.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");	
}

function idOk(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.checkid.value = document.frm.userid.value;
	self.close();
}

















