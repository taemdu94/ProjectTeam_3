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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team3.dto.StoreVO;

@WebServlet("/storeList.do")
public class StoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./store/storeList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		StoreVO sVo = new StoreVO();
		
		String savePath = "images";
		int uploadFileSizeLimit = 5 * 1024 * 1024; 
		String encType="UTF-8";
		
		ServletContext context = getServletContext(); 
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리");
		System.out.println(uploadFilePath);
		
		try	{
			MultipartRequest multi = new MultipartRequest( request,
					uploadFilePath,//saveDirectory, // 업로드 될 파일 패스(경로)설정을 위해 ServletContext
					uploadFileSizeLimit, //maxPostSize, 5* 1024 * 1024,-> 5MB
					encType, //encoding,
				 	new DefaultFileRenamePolicy());
			String store_photo1 = multi.getParameter("store_photo1");
			String store_name = multi.getParameter("store_name");
			String store_type = multi.getParameter("store_type");
			String store_addr = multi.getParameter("store_addr");
			
			out.print("<br>사진: " + store_photo1);
			
			out.print("<br>업체명: " + multi.getParameter("store_name"));
			out.print("<br>업종: " + multi.getParameter("store_type"));
			out.print("<br>주소: " + multi.getParameter("store_addr"));
			
			
		}catch(Exception e) {
			System.out.println("예외 발생 : " + e);
		}
		System.out.println(sVo.getStore_name());
		
	response.sendRedirect("storeList.do");
	}
}
