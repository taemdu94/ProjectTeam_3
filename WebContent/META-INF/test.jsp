<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body><%@ page import ="java.sql.DriverManager" %>
<%@ page import ="java.sql.Statement" %>
<%@ page import ="java.sql.ResultSet" %>
<%@ page import ="java.sql.Connection" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//java.sql << import 필요

// 테이터베이스 연동 코드

//1. jdbc 드라이버 코드
// forName(className)
Class.forName("oracle.jdbc.driver.OracleDriver");

// 2. 디비 접속을 위한 연결 격체 생성
// getConnection(url, user, password)
Connection conn = DriverManager.getConnection(
		"jdbc:oracle:thin:@localheost:1521:xe",
		"willjeong",
		"willjeong");

// 3. 쿼리들을 싱행하기 위한 객체 생성
Statement stmt = conn.createStatement();

// 4. 쿼리 실행 및 결과 처리
// executeQuery(sql) : select 할때 사용
// executeUpdate(sql) : -insert, update, delete 할때 사용

request.getParameter("name");
request.getParameter("userid");
request.getParameter("pwd");
request.getParameter("email");
request.getParameter("phone");
request.getParameter("admin");

String sql_select = "select * from member";
// String sql_insert = "insert into member values("+ name + "," + userid + ","+ pwd +" ," + email +"," + phone +", " + admin +")";

ResultSet rs = stmt.executeQuery(sql_select);


/* stmt.executeUpdate(sql_insert);
stmt.executeUpdate("update member set email='kenneth820@naver.com' where userid='kenneth'");
stmt.executeUpdate("delete from member where userid = 'hodong'");
*/


while(rs.next()) {
	out.print("<h6>" + rs.getString("name") + rs.getString("userid") + "</h6>");
}
//rs = stmt.executeQuery(sql_select_id);
//while(rs.next()){
//	out.print("<h6>" + rs.getString("name") + rs.getString("userid") + "</h6>");
//	request.setAttribute("name", rs.getString("name"));
//	request.setAttribute("id", rs.getString("userid"));
//}

rs.close();
stmt.close();
conn.close();

//RequestDispatcher dispatcher = request.getRequestDispatcher("member/selectTest.jsp");
//dispatcher.forward(request, response);	

%>
</body>
</html>
</html>