package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team3.dao.MemberDAO;
import com.team3.dao.ReservationDAO;
import com.team3.dao.StoreDAO;
import com.team3.dto.N_userVO;
import com.team3.dto.ReservationVO;
import com.team3.dto.StoreVO;


@WebServlet("/Reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		
		ReservationDAO rDao = ReservationDAO.getInstance();
		ReservationVO rVo = new ReservationVO();
		
		MemberDAO nDao = MemberDAO.getInstance();
		N_userVO nVo = new N_userVO();
		
		StoreDAO sDao = StoreDAO.getInstance();
		StoreVO sVo = new StoreVO();
		
		HttpSession session = request.getSession();	
		
		
		
		String user_id = ((N_userVO) session.getAttribute("n_profile")).getUser_id();

		String resr_user_name = ((N_userVO) session.getAttribute("n_profile")).getUser_name();
		
		String resr_store_name = request.getParameter("store_name");
		
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("resr_user_name", resr_user_name);
		request.setAttribute("resr_store_name", resr_store_name);

		RequestDispatcher dispatcher = request.getRequestDispatcher("reser_request_restaurant.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
	

}
