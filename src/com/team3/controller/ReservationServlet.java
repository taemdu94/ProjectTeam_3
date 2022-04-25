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
		String url = "reservation_process_restaurant.jsp";

		HttpSession session = request.getSession();
		
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
		System.out.println("asdfawer");
		
		String store_name = request.getParameter("store_name");
		String resr_store_name = store_name;

		System.out.println(request.getParameter("resr_store_name") + "날짜===================");
		
//		String user_id = ((N_userVO) session.getAttribute("n_profile")).getUser_id();
//		System.out.println("user_id : " + user_id);
		
		String user_id = request.getParameter("user_id");
		System.out.println(request.getParameter("user_id") + "날짜===================");
		String user_name = request.getParameter("user_name");
		String resr_user_name = user_name;
		System.out.println(request.getParameter("resr_user_name") + "날짜===================");
		
//		System.out.println(request.getParameter("resr_user_name") + "user_name===================");
//		String resr_user_name = ((N_userVO) session.getAttribute("n_profile")).getUser_name();
		
		System.out.println(request.getParameter("resr_date") + "날짜===================");
		Date resr_date = Date.valueOf(request.getParameter("resr_date"));
		
		System.out.println(request.getParameter("resr_time") + "타임===================");
		Date resr_time = Date.valueOf(request.getParameter("resr_time"));
		
		System.out.println(request.getParameter("resr_store_need") + "resr_store_need=====");
		String resr_store_need = request.getParameter("resr_store_need");
		
		System.out.println(request.getParameter("resr_usingtime") + "resr_usingtime===================");
		Date resr_usingtime = Date.valueOf(request.getParameter("resr_usingtime"));
		
		System.out.println(request.getParameter("resr_person") + "resr_person===================");
		int resr_person = Integer.parseInt(request.getParameter("resr_person"));
		
		System.out.println(request.getParameter("resr_info") + "resr_info===================");
		String resr_info = request.getParameter("resr_info");
		
		System.out.println(request.getParameter("resr_before_info") + "resr_before_info===================");
		String resr_before_info = request.getParameter("resr_before_info");
		
		rVo.setUser_id(user_id);
		rVo.setResr_user_name(resr_user_name);
		rVo.setResr_store_name(resr_store_name);
		rVo.setResr_date(resr_date);
		rVo.setResr_time(resr_time);
		rVo.setResr_store_need(resr_store_need);
		rVo.setResr_usingtime(resr_usingtime);
		rVo.setResr_person(resr_person);
		rVo.setResr_info(resr_info);
		rVo.setResr_before_info(resr_before_info);
		
		System.out.println("s서블릿 에 들어ㅗ와ㅆ "+ rVo);

		
		int result = rDao.insertReservation(rVo);
		
		if (result == 1) {
			System.out.println("예약 등록에 성공했습니다.");
			request.setAttribute("message", "예약 등록에 성공했습니다.");
		} else {
			System.out.println("예약 등록에 실패했습니다.");
			request.setAttribute("message", "예약 등록에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("payment_process_restaurant.jsp");
		dispatcher.forward(request, response);
		
		request.setAttribute("reservation_info", rVo);
		
	}
	

}
