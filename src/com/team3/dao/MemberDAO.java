package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team3.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	// 데이터 베이스에 접근하여 데이터를 획득하거나 설정
	// CRUD를 메서드로 구현한 클래스
	
	// 싱글톤 적용
	private MemberDAO() {		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	// Create (insert) - 회원 가입
	public int insertMember(MemberVO mVo) {
		String sql_insert_pstmt = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql_insert_pstmt);
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			
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
	
	
	// Read (select) - 사용자 인증
	// 데이터 베이스에서 회원 정보를 select 하여 값을 비교하고 로그인 수행
	public int checkUser(String userid, String pwd) {		
		String sql_select_pstmt = "select pwd, name from member where userid=?";
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_pstmt);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			System.out.println("pwd : " + rs.getString("pwd"));
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) {
					result = 1;		// pwd 일치
				} else {
					//암호 불일치
					// 비밀번호가 맞지 않습니다.
					result = 0;
					// 존재하지 않는 회원 입니다.
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
	
	// Read (select) - 데이터 활용
	// userid에 해당하는 회원 정보를 모두 획득
	public MemberVO getMember(String userid) {
		String sql_select_info = "select * from member where userid=?";
		MemberVO mVo = null;		

		mVo = new MemberVO();
		
		int result = -1;
		String name;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_info);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// 디비로부터 회원 정보 획득
			if(rs.next()) {
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return mVo;
		
	}
	
	// Read (select) - 아이디 중복 확인
	public int confirmID(String userid) {
		String sql_select_checkId ="select userid from member where userid=?";
		
		int result = -1;
	
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();

			// 3. 쿼리문을 실행하기 위한 객체 생성
			pstmt = conn.prepareStatement(sql_select_checkId);
			pstmt.setString(1, userid);

			// 4. 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
//			System.out.println("userid : " + rs.getString("userid"));
				result = 1;
			} else {
				result = -1;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return result;	
		
	}
	
	
	// Update (update) - 회원 정보 수정
	public int updateMember(MemberVO mVo) {
		String sql_update = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			// 1. jdbc 드라이버 로드 : forName(className)
			// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
			conn = DBManager.getConnection();
	
			// 3. 쿼리문을 실행하기 위한 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserid());
			
			// 4. 쿼리 실행 및 결과 처리
			// executeUpdate(sql)	- update	
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	// Delete (delete) - 회원 삭제
	public int deleteMember() {
		String sql_delete = "delete from member where userid=?";
		
		int result = -1;
		
		return result;		
	}
	
}
