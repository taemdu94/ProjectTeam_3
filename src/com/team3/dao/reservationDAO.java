package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team3.dto.B_userVO;
import com.team3.dto.N_reservationVO;

import util.DBManager;

public class reservationDAO {
	private reservationDAO() {}
	
	private static reservationDAO instance = new reservationDAO();
	
	public static reservationDAO getInstance() {
		return instance;
	}
	
	public N_reservationVO n_reservation(String user_id) {
		String sql = "select * from reservation_info where user_id=?";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		N_reservationVO nrvo = new N_reservationVO();
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nrvo.setUser_id(rs.getString("user_id"));
				nrvo.setResr_number(rs.getInt("resr_number"));
				nrvo.setResr_user_name(rs.getString("resr_user_name"));
				nrvo.setResr_user_tel(rs.getString("resr_user_tel"));
				nrvo.setResr_date(rs.getDate("resr_date"));
				nrvo.setResr_time(rs.getDate("resr_time"));
				nrvo.setResr_store_need(rs.getString("resr_store_need"));
				nrvo.setResr_usingtime(rs.getDate("resr_usingtime"));
				nrvo.setResr_person(rs.getInt("resr_person"));
				nrvo.setResr_info(rs.getString("resr_info"));
				nrvo.setResr_before_info(rs.getString("resr_before_info"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nrvo;
	}
	
	public int delete_reservation(N_reservationVO nrvo) {
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
}
