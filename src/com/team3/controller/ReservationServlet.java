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

import com.team3.dao.ReservationDAO;
import com.team3.dto.N_reservationVO;
import com.team3.dto.N_userVO;


@WebServlet("/reservation.do")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String store_type = request.getParameter("store_type");
			System.out.println(store_type);
		
		String user_id = ((N_userVO) session.getAttribute("n_profile")).getUser_id();
			System.out.println(user_id);
		
		String user_name = ((N_userVO) session.getAttribute("n_profile")).getUser_name();
			System.out.println(user_name);
		
		String user_tel = ((N_userVO) session.getAttribute("n_profile")).getUser_tel();
			System.out.println(user_tel);
		
		String store_name = request.getParameter("store_name");
			System.out.println(store_name+"-----");
		
		Date resr_date = Date.valueOf(request.getParameter("resr_date"));
			System.out.println(resr_date+"=====");
		
			
			
			// 오류 발생....
		Date resr_time = Date.valueOf(request.getParameter("resr_time"));
			System.out.println(resr_time+"////////");
		
		int resr_person = Integer.parseInt(request.getParameter("resr_person"));
			System.out.println(resr_person);
		
		String resr_store_need = request.getParameter("resr_store_need");
			System.out.println(resr_store_need);
		
		String resr_before_info = request.getParameter("resr_before_info");
			System.out.println(resr_before_info);
		
		ReservationDAO rDao = ReservationDAO.getInstance();
		N_reservationVO rvo = new N_reservationVO();
		
		rvo.setUser_id(user_id);
		rvo.setResr_user_name(user_name);
		rvo.setResr_user_tel(user_name);
		rvo.setResr_store_name(user_tel);
		rvo.setResr_date(resr_date);
		rvo.setResr_time(resr_time);
		rvo.setResr_store_need(resr_store_need);
		rvo.setResr_person(resr_person);
		rvo.setResr_before_info(resr_before_info);
		
		System.out.println(rvo);
		int result = rDao.insertresr_restaurant(rvo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment_process_restaurant.jsp");
		dispatcher.forward(request, response);

	}
	

}
