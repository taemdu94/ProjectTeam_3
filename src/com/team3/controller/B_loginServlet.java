package com.team3.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dao.MemberDAO;
import com.team3.dto_vo.B_userVO;

@WebServlet("/B_loginServlet")
public class B_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String b_id = request.getParameter("member_b_id");
		String b_pwd = request.getParameter("member_b_pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		String url = "";
		int result = mDao.b_sign_in(b_id, b_pwd);		
		
		if (result == 1) {
			//DB에서 회원정보(이름 포함)을 가져와서 저장하는 구문 작성
			B_userVO bvo = mDao.b_profile(b_id);
			
			HttpSession session = request.getSession();	//세션 객체 생성
			session.setAttribute("b_profile", bvo);		//회원 정보를 세션에 저장
			
			session.setAttribute("login", "2");
			
			request.setAttribute("message", "인증이 완료되었습니다.");
			
			url = "index.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
			
			url = "login.jsp";
		} else {
			request.setAttribute("message", "존재하지 않는 회원 입니다.");

			url = "login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
