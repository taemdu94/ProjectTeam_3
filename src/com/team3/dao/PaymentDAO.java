package com.team3.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.team3.dto.N_userVO;
import com.team3.dto.PaymentVO;

import util.DBManager;


public class PaymentDAO  {
	
	private PaymentDAO() {		
	}
	
	private static PaymentDAO instance = new PaymentDAO();
	
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	
	// Create (insert) - 회원 가입
		public int insertPayment(PaymentVO payVo) {
			String sql = "insert into payment values(payment_LPAD(seq.nextval, 4, 0),?,sysdate,?";
			
			int result = -1;
			
			Connection conn = null;
			PreparedStatement pstmt= null;
			
			try {
				// 1. jdbc 드라이버 로드 : forName(className)
				// 2. 디비 접속을 위한 연결 객체 생성 : getConnection(url, user, password)
				conn = DBManager.getConnection();
		
				// 3. 쿼리문을 실행하기 위한 객체 생성
//				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
	
				pstmt.setString(1, payVo.getPayment_type());
				pstmt.setInt(2, payVo.getAmount());
				
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
