

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/storeInfoMng.do")
public class storeInfoMngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;  charset=utf-8");
		PrintWriter out = response.getWriter();

		
		out.print("<html>");
		out.print("<body>");
		
		String userid = request.getParameter("userid");
		String store_img_file_name = request.getParameter("store_img_file_name");
		String store_name = request.getParameter("store_name");
		String store_type = request.getParameter("store_type");
		String time_day = request.getParameter("time_day");
		String time_week = request.getParameter("time_week");
		String store_addr = request.getParameter("store_addr");
		String store_addr_detail = request.getParameter("store_addr_detail");
		String store_menu = request.getParameter("store_menu");
		String store_parking = request.getParameter("store_parking");
		String store_parking_etc = request.getParameter("store_parking_etc");
		
		
		
		
		
		out.print("아이디-userid:" + userid);
		out.print("<br>");
		out.print("대표사진-store_img_file_name:" + store_img_file_name);
		out.print("<br>");
		out.print("업체이름-store_name:" + store_name);
		out.print("<br>");
		out.print("업종-store_type:" + store_type);
		out.print("<br>");
		out.print("운영시간(평일)-time_day:" + time_day);
		out.print("<br>");
		out.print("운영시간(주말)-time_week:" + time_week);
		out.print("<br>");
		out.print("업체주소-store_addr:" + store_addr);
		out.print("<br>");
		out.print("업체주소상세-store_addr_detail:" + store_addr_detail);
		out.print("<br>");
		out.print("메뉴-store_menu:" + store_menu);
		out.print("<br>");
		out.print("주차-store_parking:" + store_parking);
		out.print("<br>");
		out.print("주차(비고)-store_parking_etc:" + store_parking_etc);

		out.print("</body>");
		out.print("</html>");

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
