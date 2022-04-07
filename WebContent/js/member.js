
function n_login() {
	if (document.nfrm.member_n_id.value==="") {
		alert("아이디를 입력해 주세요.")
		nfrm.member_n_id.focus();
		return false;
	}
	if (document.nfrm.member_n_pwd.value==="") {
		alert("패스워드를 입력해 주세요.")
		nfrm.member_n_pwd.focus();
		return false;
	}
	return true;
}
function b_login() {
	if (document.bfrm.member_b_id.value==="") {
		alert("아이디를 입력해 주세요.")
		bfrm.member_b_id.focus();
		return false;
	}
	if (document.bfrm.member_b_pwd.value==="") {
		alert("패스워드를 입력해 주세요.")
		bfrm.member_b_pwd.focus();
		return false;
	}
	return true;
}