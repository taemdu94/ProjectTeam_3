//자바스크립트 구현
function checkLogin(){
	if(document.frm.userid.value===""){
		alert("아이디를 입력해주세요.")
		frm.userid.focus(); //로그인 폼에 유저아이디에 마우스 커서를 올리겠다는 뜻.
		return false;
	}
	if(document.frm.pwd.value===""){
		alert("암호를 입력해주세요.")
		frm.pwd.focus();
	}
	return ture;
}

function checkJoin(){
	if(document.frm.userid.value===""){
		alert("이름을 입력해주세요.")
		frm.name.focus(); //유저 이름에 마우스 커서를 올리겠다는 뜻.
		return false;
	}
	if(document.frm.userid.value===""){
		alert("아이디를 입력해주세요.")
		frm.userid.focus(); //유저아이디에 마우스 커서를 올리겠다는 뜻.
		return false;
	}
	if(document.frm.pwd.value===""){
		alert("암호를 입력해주세요.")
		frm.pwd.focus();
	}
	return ture;
}