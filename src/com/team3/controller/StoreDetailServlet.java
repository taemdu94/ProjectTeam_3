package com.team3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team3.dao.StoreDAO;
import com.team3.dto.StoreVO;

@WebServlet("/storeDetail.do")
public class StoreDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//상품 이름 가져와서 조회한 내용 출력
		String store_name = request.getParameter("store_name");
		StoreDAO sDao = StoreDAO.getInstance();
		StoreVO sVo = new StoreVO();
		
		//메뉴 컬럼 값을 구분자를 통해 배열 형식으로 담기
				String menu_info = sDao.StoreDetail(store_name).getMenu_info();
				System.out.println(menu_info);
				String[] menu_infoArr = new String[100];
				
					menu_infoArr = menu_info.split("원");
					for(int i=0; i < menu_infoArr.length; i++ ) {
						System.out.println(menu_infoArr[i]);
//						for문 적용 전에 단일 테스트
//						menu_infoArr = menu_info.split("원");
//						System.out.println(menu_infoArr[1]);
					}
		
		sVo = sDao.StoreDetail(store_name);
		
		request.setAttribute("store", sVo);
		request.setAttribute("menu1", menu_infoArr[0]);
		request.setAttribute("menu2", menu_infoArr[1]);
		request.setAttribute("menu3", menu_infoArr[2]);
		request.setAttribute("menu4", menu_infoArr[3]);
		RequestDispatcher dispatcher = request.getRequestDispatcher("store/storeDetail.jsp");
		dispatcher.forward(request, response);
	}
}