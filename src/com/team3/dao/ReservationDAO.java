package com.team3.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team3.dto.MemberVO;
import com.team3.dto.ReservationVO;

import util.DBManager;


public class ReservationDAO  {
	
	private ReservationDAO() {	
		
	}
	
	private static ReservationDAO instance = new ReservationDAO();
	
	public static ReservationDAO getInstance() {
		return instance;
		
	}


	public int insertReservation(ReservationDAO rVo) {
		String sql = "insert into reservation_info values(?,reservation_info_seq.nextval,?,?";
		
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
			
			pstmt.setString(1, rVo.getUser_id());
			pstmt.setInt(2, rVo.getResr_number());
			pstmt.setString(3, rVo.getResr_number());
			pstmt.setString(4, rVo.getResr_user_name());
			pstmt.setString(5, rVo.getResr_user_tel());
			pstmt.setString(6, rVo.getResr_store_name());
			pstmt.setInt(7, rVo.getResr_user_degree());
			pstmt.setString(8, rVo.getResr_user_name());
			
			
			
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


