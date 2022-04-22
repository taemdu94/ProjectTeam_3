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

@WebServlet("/reserveLoginCheck.do")
public class ReserveLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		HttpSession session = request.getSession();

		if (session.getAttribute("login") == "1") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("./reserve/reserStore.jsp");
			dispatcher.forward(request, response);
		} else {
			out.print("<script>");
			out.print("alert(\"로그인 해주세요.\");");
			out.print("location.href=\"member/login.jsp\";");
			out.print("</script>");
		}

		out.print("<html>");
		out.print("<body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
