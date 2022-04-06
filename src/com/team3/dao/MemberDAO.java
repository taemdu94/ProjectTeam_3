package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team3.dto_vo.B_userVO;
import com.team3.dto_vo.N_userVO;

import util.DBManager;

public class MemberDAO {
	
	//데이터 베이스에 접근하여 데이터를 획득하거나 설정
	
	//Create (insert) - 회원 가입
	public int sign_up() {
		
		return 0;
	}
	
	//Read (select) - 사용자 인증,
	public int n_sign_in(String user_id, String user_password) {
		String sql = "select user_id, user_password from n_user where user_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		

		int result = -1;
		
		try {		
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("user_password")!=null && rs.getString("user_password").equals(user_password)) {							
					
					result = 1;
				} else {
					
					result = 0;
					
					result = -1;
				}
			}
	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	public int b_sign_in(String user_id, String user_password) {
		String sql = "select user_id, user_password from b_user where user_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		

		int result = -1;
		
		try {		
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("user_password")!=null && rs.getString("user_password").equals(user_password)) {							
					
					result = 1;
				} else {
					
					result = 0;
					
					result = -1;
				}
			}
	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	//					데이터 활용
	public N_userVO n_profile(String user_id) {
		String sql = "select * from n_user where user_id=?";
		N_userVO nvo = new N_userVO();
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nvo.setUser_id(rs.getString("user_id"));
				nvo.setUser_password(rs.getString("user_password"));
				nvo.setUser_name(rs.getString("user_name"));
				nvo.setUser_email(rs.getString("user_email"));
				nvo.setUser_tel(rs.getString("user_tel"));
				nvo.setN_membership(rs.getInt("n_membership"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}
	public B_userVO b_profile(String user_id) {
		String sql = "select * from b_user where user_id=?";
		B_userVO bvo = new B_userVO();
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bvo.setUser_id(rs.getString("user_id"));
				bvo.setUser_pwd(rs.getString("user_pwd"));
				bvo.setUser_name(rs.getString("user_name"));
				bvo.setUser_email(rs.getString("user_email"));
				bvo.setUser_tel(rs.getString("user_tel"));
				bvo.setB_license(rs.getString("b_license"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}
	
	//Update (update) - 회원 정보 수정
	public int profile_update() {
		
		return 0;
		
	}
	
	//Delete (delete) - 회원 삭제
	public int n_user_delete() {
		String sql = "delete from n_user where user_id=?";
		
		int result = -1;
		
		return result;
	}
	public int b_user_delete() {
		String sql = "delete from b_user where user_id=?";
		
		int result = -1;
		
		return result;
	}

}
