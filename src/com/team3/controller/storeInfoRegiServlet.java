

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		//PrintWriter out = response.getWriter();

		
		String savePath = "images";
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
	    System.out.println("서버상의 실제 디렉토리:");
	    System.out.println(uploadFilePath);
		
	    
		MultipartRequest multi = new MultipartRequest(request, 
				uploadFilePath,
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		String userid = "btestid01"; //request.getParameter("b_userid");
		String store_img_file_name1 = multi.getFilesystemName("store_img_file_name1");  //1 대표사진 위치경로 정보
		String store_name = multi.getParameter("store_name");        			   //2 업체 이름
		String store_type = multi.getParameter("store_type");					   //3 업종 선택
		String time_day = multi.getParameter("time_day");						   //4 운영 시간 - 평일
		String time_week = multi.getParameter("time_week");					   //4 운영 시간 - 주말
		String store_addr = multi.getParameter("store_addr");					   //5 주소	
		String store_addr_detail = multi.getParameter("store_addr_detail");	   //6 주소 상세
		String store_parking = multi.getParameter("store_parking");			   //7 주차 여부
		String store_parking_etc = multi.getParameter("store_parking_etc");	   //8 주차 여부 - 비고
		System.out.println("multi => userid => " + userid);
		System.out.println("multi => store_img_file_name1 => " + store_img_file_name1);
		System.out.println("multi => store_name => " + store_name);
		System.out.println("multi => store_type => " + store_type);
		System.out.println("multi => time_day => " + time_day);
		System.out.println("multi => time_week => " + time_week);
		System.out.println("multi => store_addr => " + store_addr);
		System.out.println("multi => store_addr_detail => " + store_addr_detail);
		System.out.println("multi => store_parking => " + store_parking);
		System.out.println("multi => store_parking_etc => " + store_parking_etc);

		
		/*
		StoreDAO sDao = new StoreDAO();
		StoreVO sVo = new StoreVO(); 
		
		sVo.setUserid(userid);
		sVo.setStore_photo(store_img_file_name1);
		sVo.setStore_photo(store_img_file_name2);
		sVo.setStore_photo(store_img_file_name3);
		sVo.setStore_name(store_name);
		sVo.setStore_type(store_type);
		sVo.setStore_time(time_day);
		sVo.setStore_time_w(time_week);
		sVo.setStore_addr(store_addr);
		sVo.setStore_addr_detail(store_addr_detail);
		sVo.setParking(store_parking);
		sVo.setParking_detail(store_parking_etc);
		
		int result =  sDao.insertStoreInfo(sVo);

		if(result == 1) {
			System.out.println("insertStoreInfo's result(등록 성공) : " + result);
*/			
		    
		    
		    String filename1 = "";
		    String filename2 = "";
		    String filename3 = "";
		    String origfilename1 = "";
		    String origfilename2 = "";
		    String origfilename3 = "";
		    
		        
		        /*		        
		        Enumeration files = multi.getFileNames();
		        
		        String file1 = (String)files.nextElement();
		        store_img_file_name1 = multi.getFilesystemName(file1);
		        System.out.println("filename1:" + store_img_file_name1);
		        String file2 = (String)files.nextElement();
		        store_img_file_name2 = multi.getFilesystemName(file2);
		        System.out.println("filename2:" + store_img_file_name2);
		        
		        String file3 = (String)files.nextElement();
		        store_img_file_name3 = multi.getFilesystemName(file3);
		        origfilename3 = multi.getOriginalFileName(file3);
		        System.out.println("filename3:" + store_img_file_name3);
*/
		    
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_mng.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_mng.do");
			dispatcher.forward(request, response);
/*
	}else{
			System.out.println("insertStoreInfo's result(등록 실퍠) : " + result);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("store_info_regi.jsp");
			dispatcher.forward(request, response);
		}
			
*/	

	}

}
