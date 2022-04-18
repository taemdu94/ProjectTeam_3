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

import com.team3.dao.reservationDAO;
import com.team3.dto.N_reservationVO;
import com.team3.dto.N_userVO;

@WebServlet("/N_reservationServlet")
public class N_reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		String user_id = ((N_userVO) session.getAttribute("n_profile")).getUser_id();
		
		reservationDAO mDao = reservationDAO.getInstance();
		
		N_reservationVO nrvo = mDao.n_reservation(user_id);
		
		session.setAttribute("reservation", nrvo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("reserve/reserve_history.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
