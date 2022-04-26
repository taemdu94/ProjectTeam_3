package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dto.PaymentVO;
import com.team3.dao.MemberDAO;
import com.team3.dao.PaymentDAO;
import com.team3.dao.ReservationDAO;
import com.team3.dto.N_userVO;


@WebServlet("/Payment.do")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "payment_process_restaurant.jsp";
		
		HttpSession session = request.getSession();
		// 만약, 세션 속성이 유지되고 있는 동안(즉, 로그인 되어 있는 상태)에는 main.jsp 페이지로 이동한다.				
		if (session.getAttribute("loginUser") != null) {
			url = "payment_process_restaurant.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
	
		PaymentVO payVo = new PaymentVO();
		
		ServletContext context = getServletContext();
		
		String payment_type = request.getParameter("payment_type");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		out.println("<br /> 결제내역 : " + payment_type);
		out.println("<br /> 가격 : " + amount);
		
//		out.println("<br /> 등록일자 : " + request.getAttribute("col_date"));
		
		payVo.setPayment_type(payment_type);
		payVo.setAmount(amount);
		
		PaymentDAO rDao = PaymentDAO.getInstance();
		
		int result = rDao.insertPayment(payVo);
		
		if (result == 1) {
			System.out.println("결제에 성공했습니다.");
			request.setAttribute("message", "결제에 성공했습니다.");
		} else {
			System.out.println("결제에 실패했습니다.");
			request.setAttribute("message", "결제에 실패했습니다.");
		}
		
		response.sendRedirect("payment_process_lodging.do");
		response.sendRedirect("payment_process_restaurant.do");
	}

}
