package com.team3.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoreDAO;
import dto.StoreVO;

@WebServlet("/storeInfoRegi.do")
public class storeInfoRegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("store_info => doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;  charset=utf-8");
		PrintWriter out = response.getWriter();

		String userid = "btestid01"; //request.getParameter("userid");
		String store_img_file_name = request.getParameter("store_img_file_name");  //1 대표사진 위치경로 정보
		String store_name = request.getParameter("store_name");        			   //2 업체 이름
		String store_type = request.getParameter("store_type");					   //3 업종 선택
		String time_day = request.getParameter("time_day");						   //4 운영 시간 - 평일
		String time_week = request.getParameter("time_week");					   //4 운영 시간 - 주말
		String store_addr = request.getParameter("store_addr");					   //5 주소	
		String store_addr_detail = request.getParameter("store_addr_detail");	   //6 주소 상세
		String store_parking = request.getParameter("store_parking");			   //7 주차 여부
		String store_parking_etc = request.getParameter("store_parking_etc");	   //8 주차 여부 - 비고

		StoreDAO sDao = new StoreDAO();
		StoreVO sVo = new StoreVO(); 
		
		sVo.setUserid(userid);
		sVo.setStore_photo(store_img_file_name);
		sVo.setStore_name(store_name);
		sVo.setStore_type(store_type);
		sVo.setStore_time(time_day);
		sVo.setStore_time_w(time_week);
		sVo.setStore_addr(store_addr);
		sVo.setStore_addr_detail(store_addr_detail);
		sVo.setParking(store_parking);
		sVo.setParking_detail(store_parking_etc);
		
		int result =  sDao.insertStoreInfo(sVo);
		System.out.println("insertStoreInfo's result : " + result);

	}

}
