package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



	public int insertReservation(ReservationVO rVo) {
		System.out.println("실패1");
		String sql = "insert into reservation_info values(?,reservation_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
		System.out.println("실패2");
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
			
			
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			System.out.println("실패3");
			
			
			pstmt.setString(1,rVo.getUser_id());
			pstmt.setInt(2,rVo.getResr_number());
			pstmt.setString(3, rVo.getResr_user_tel());
			pstmt.setString(4, rVo.getResr_store_name());
			pstmt.setDate(5, rVo.getResr_date());
			pstmt.setDate(6, rVo.getResr_time());
			pstmt.setString(7, rVo.getResr_store_need());	
			pstmt.setDate(8, rVo.getResr_usingtime());
			pstmt.setInt(9, rVo.getResr_person());
			pstmt.setString(10, rVo.getResr_info());
			pstmt.setString(11, rVo.getResr_before_info());
			
			System.out.println("실패4");
			
			
			// 4. 쿼리 실행 및 결과 처리
			// executeUpdate(sql)	- insert update delete	
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}		
		return result;		
	}

	
	

	
}


