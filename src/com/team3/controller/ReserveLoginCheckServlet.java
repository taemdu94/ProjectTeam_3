package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dao.StoreDAO;
import com.team3.dto.StoreVO;

@WebServlet("/reserveLoginCheck.do")
public class ReserveLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//상품 이름 가져와서 조회한 내용 출력
		String store_name = request.getParameter("store_name");
		System.out.println(store_name + "상품이름==========");
		StoreDAO sDao = StoreDAO.getInstance();
		StoreVO sVo =new StoreVO();
		//업종 컬럼 값 가져오기
		String store_type = request.getParameter("store_type");
		System.out.println(store_type + "213123131");
		
		HttpSession session = request.getSession();
		
		// 로그인 상태이면서, 업종에 맞게 페이지 이동

		if (session.getAttribute("login") == "1" && "요식업".equals(store_type)) {
			request.setAttribute("store", store_type);
			request.setAttribute("store_name", store_name);

			RequestDispatcher dispatcher = request.getRequestDispatcher("reser_request_restaurant.jsp");
			dispatcher.forward(request, response);
			

		} else if (session.getAttribute("login") == "1" &&  "숙박업".equals(store_type) || "문화시설".equals(store_type) )  {
			request.setAttribute("store", store_type);
			request.setAttribute("store_name", store_name);

			RequestDispatcher dispatcher = request.getRequestDispatcher("reser_request_lodging.jsp");
			dispatcher.forward(request, response);
//		} else if (session.getAttribute("login") == "1" && "문화시설".equals(store_type))  {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("reser_request_lodging.jsp");
//			dispatcher.forward(request, response);
			
			} else {
			out.print("<script>");
			out.print("alert(\"로그인 해주세요.\");");
			out.print("location.href=\"member/login.jsp\";");
			out.print("</script>");
		}
		
	}
}