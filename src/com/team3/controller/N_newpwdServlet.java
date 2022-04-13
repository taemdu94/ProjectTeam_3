package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;
import com.team3.dto_vo.N_userVO;

@WebServlet("/N_newpwdServlet")
public class N_newpwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("member_n_pwd");
		
		N_userVO nvo = new N_userVO();
		
		nvo.setUser_id(user_id);
		nvo.setUser_password(user_password);
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		mDao.n_pwd_update(nvo);

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
