package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.MemberDAO;
import com.team3.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");		// 페이지 이동
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
//		System.out.println("이름: " + name);		
		out.println(name);
		out.println(userid);
		out.println(pwd);
		out.println(email);
		out.println(phone);
		out.println(admin);
		
		//MemberDAO mDao = new MemberDAO();
		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberVO mVo = new MemberVO();
		
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(Integer.parseInt(admin));		
		
		int result = mDao.insertMember(mVo);		
		
		// 회원 가입 성공 - 디비에 성공적으로 저장 완료
		if(result == 1) {
			request.setAttribute("message", "회원 가입에 성공 하였습니다.");
		} else {	// 회원 가입 실패 - 디비에 저장 실패
			request.setAttribute("message", "회원 가입에 실패 하였습니다.");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);

	}
}
