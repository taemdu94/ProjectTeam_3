<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>

<h2>로그인</h2>
<form method="post" action="login.do" name="frm">
	
<table>
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="userid">
		</td>
	</tr>
	<tr>
		<td>암 호</td>
		<td>
			<input type="password" name="pwd">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인" onclick="return checkLogin()">
			<input type="reset" value="취소">
			<input type="button" value="회원가입" onclick="location.href='join.do'">
		</td>
	</tr>
</table>
	
	
</form>

</body>
</html>