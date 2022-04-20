

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import dao.StoreDAO;
import dto.ReserMngVO;

@WebServlet("/reserMng.do")
public class reserMngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("store_info in mng => doGet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;  charset=utf-8");

		
		String userid = "btestid01"; //request.getParameter("b_userid");
		String query_date = request.getParameter("query_date");
		String query_degree = request.getParameter("query_degree");

		System.out.println("request => userid => " + userid);
		System.out.println("request => query_date => " + query_date);
		System.out.println("request => query_degree => " + query_degree);
		
		StoreDAO sDao = new StoreDAO();
		
		String name =  sDao.getStoreInfo_Name(userid);
		name = name.trim();

		if(name != null) {
			System.out.println("getStoreInfo_Name's result(등록 성공) : " + name);

			ReservationDAO rDao = new ReservationDAO();

			if(query_date.equals("all") && query_degree.equals("all")) { 
				List<ReserMngVO>  Reserlist =  rDao.getReserInfo(name);
				request.setAttribute("Reserlist", Reserlist);
				System.out.println(Reserlist);
			}else {
				
				Date now = new Date();
				String nowTime = now.toString();
				System.out.println("nowTime = " + nowTime);
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:dd:ss"); //원하는 데이터 포맷 지정 
				query_date = simpleDateFormat.format(now); //지정한 포맷으로 변환 
				System.out.println("포맷 지정 후 query_date : " + query_date);

				
				List<ReserMngVO>  Reserlist =  rDao.getReserInfo(name, query_date, query_degree);
				request.setAttribute("Reserlist", Reserlist);
				System.out.println(Reserlist);
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("reser_mng.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("insertStoreInfo's result(등록 실퍠) : " + name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("reser_mng.jsp");
			dispatcher.forward(request, response);
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("store_info in mng => doPost");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;  charset=utf-8");

	}

}
