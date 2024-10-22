
package com.team3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team3.dto.N_reservationVO;
import com.team3.dto.ReserMngVO;
import com.team3.dto.ReservationVO;

import util.DBManager;


public class ReservationDAO  {
	
	private ReservationDAO() {	
		
	}
	
	private static ReservationDAO instance = new ReservationDAO();
	
	public static ReservationDAO getInstance() {
		return instance;
		
	}

	
	public List<ReservationVO> reservationList(String user_id) {
		String sql = "select * from reservation_info where user_id=?";
		
		
		int result = -1;
		
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			

			while(rs.next()) {
				
				ReservationVO nrvo = new ReservationVO();
				
				nrvo.setUser_id(rs.getString("user_id"));
				nrvo.setResr_number(rs.getInt("resr_number"));
				nrvo.setResr_user_name(rs.getString("resr_user_name"));
				nrvo.setResr_user_tel(rs.getString("resr_user_tel"));
				nrvo.setResr_store_name(rs.getString("resr_store_name"));
				nrvo.setResr_date(rs.getDate("resr_date"));
				nrvo.setResr_time(rs.getDate("resr_time"));
				nrvo.setResr_store_need(rs.getString("resr_store_need"));
				nrvo.setResr_usingtime(rs.getDate("resr_usingtime"));
				nrvo.setResr_person(rs.getInt("resr_person"));
				nrvo.setResr_info(rs.getString("resr_info"));
				nrvo.setResr_before_info(rs.getString("resr_before_info"));

				list.add(nrvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int delete_reservation(ReservationVO nrvo) {
		String sql = "DELETE FROM reservation_info where resr_number=?";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nrvo.getResr_number());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}





	public int insertresr_restaurant(N_reservationVO rvo) {
		String sql = "insert into reservation_info values(?,reservation_seq.nextval,?,?,?,?,?,?,sysdate,?,'임시메뉴데이터',?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = -1;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, rvo.getUser_id());

			

			//pstmt.setString(1,rVo.getUser_id());

			pstmt.setString(2, rvo.getResr_user_name());
			pstmt.setString(3, rvo.getResr_user_tel());
			pstmt.setString(4, rvo.getResr_store_name());
			pstmt.setDate(5, rvo.getResr_date());
			pstmt.setDate(6, rvo.getResr_time());
			pstmt.setString(7, rvo.getResr_store_need());
			
			// 4. 쿼리 실행 및 결과 처리
			// executeUpdate(sql)	- insert update delete	

			pstmt.setInt(8, rvo.getResr_person());
			
			pstmt.setString(9, rvo.getResr_before_info());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	
	public List<ReserMngVO> getReserInfo(String store_name, String query_date, String query_degree) {
		
		
		System.out.println("store_name in getReserInfo(,,) = " + store_name);
		System.out.println("query_date in getReserInfo(,,) = " + query_date);
		System.out.println("query_degree in getReserInfo(,,) = " + query_degree);
		
		String sql_select_info = "";
		
		if(query_date.equals("all") && query_degree.equals("all")) {
			sql_select_info = "select ri.resr_number, ri.resr_user_name, ri.resr_date, ri.resr_info, ri.resr_user_tel, nu.n_membership from reservation_info ri, n_user nu where resr_store_name=? and ri.user_id = nu.user_id";
		}else if(query_date.equals("all")){
			sql_select_info = "select ri.resr_number, ri.resr_user_name, ri.resr_date, ri.resr_info, ri.resr_user_tel, nu.n_membership from reservation_info ri, n_user nu where resr_store_name=? and ri.user_id = nu.user_id and nu.n_membership=? ";
		}else if(query_degree.equals("all")){
			sql_select_info = "select ri.resr_number, ri.resr_user_name, ri.resr_date, ri.resr_info, ri.resr_user_tel, nu.n_membership from reservation_info ri, n_user nu where resr_store_name=? and ri.user_id = nu.user_id and ri.resr_date=?";
		}else {
			sql_select_info = "select ri.resr_number, ri.resr_user_name, ri.resr_date, ri.resr_info, ri.resr_user_tel, nu.n_membership from reservation_info ri, n_user nu where resr_store_name=? and ri.user_id = nu.user_id and ri.resr_date=? and nu.n_membership=? ";
		}
		
		int result = -1;
		String name;
		
		List<ReserMngVO> list = new ArrayList<ReserMngVO>();
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		System.out.println("store_name in  DAO = " + store_name);
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"ora_user", 
					"1234");
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_info);
			if(query_date.equals("all") && query_degree.equals("all")) {
				pstmt.setString(1, store_name.trim());
			}else if(query_date.equals("all")){
				pstmt.setString(1, store_name.trim());
				pstmt.setString(2, query_degree);
			}else if(query_degree.equals("all")){
				pstmt.setString(1, store_name.trim());
				pstmt.setString(2, query_date);
			}else {
				pstmt.setString(1, store_name.trim());
				pstmt.setString(2, query_date);
				pstmt.setString(3, query_degree);
			}
			
			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			System.out.println("rs in  DAO = " + rs);
		
			//
			//if(rs.next()) {
			while(rs.next()) {

				ReserMngVO rVo = new ReserMngVO(); 
				
				rVo.setResr_number(rs.getInt("resr_number"));
				rVo.setResr_user_name(rs.getString("resr_user_name"));
				rVo.setResr_date(rs.getString("resr_date"));
				rVo.setResr_info(rs.getString("resr_info"));
				rVo.setResr_user_tel(rs.getString("resr_user_tel"));
				rVo.setN_membership(rs.getInt("n_membership"));
				

				list.add(rVo);
				System.out.println("list in DAO = " + list);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			if(rs != null)		rs.close();
			if(pstmt != null)	pstmt.close();
			if (conn != null)	conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return list; 	
	}
	

	
}



