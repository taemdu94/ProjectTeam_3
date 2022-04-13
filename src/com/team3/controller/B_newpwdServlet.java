package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;
import com.team3.dto_vo.B_userVO;

@WebServlet("/B_newpwdServlet")
public class B_newpwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("member_b_pwd");
		
		B_userVO bvo = new B_userVO();
		
		bvo.setUser_id(user_id);
		bvo.setUser_password(user_password);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		mDao.b_pwd_update(bvo);

		out.print("<html>");
		out.print("<body>");
		out.print("<script>");
		out.print("alert(\"정상적으로 변경되었습니다.\");");
		out.print("location.href=\"login.jsp\";");
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");
	}

}
