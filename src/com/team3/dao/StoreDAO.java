package com.team3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team3.dto.StoreVO;

import util.DBManager;

public class StoreDAO {
	private StoreDAO() {// 디폴트 생성자 만들고, 밖에서 못쓰게 private
	}

	private static StoreDAO instance = new StoreDAO(); // 필드도 가져다 못쓰게 막아놓음

	public static StoreDAO getInstance() { // 제공은 해줄게. getInstance
		return instance;
	}

	// Search (select) - 업체 검색
	public List<StoreVO> searchStore(String query) {
		String sql_select_search = "select store_photo1, store_name, store_type, store_addr from store_info where store_name like ?";

		List<StoreVO> list = new ArrayList<StoreVO>();
		
		StoreVO sVo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_select_search);
			pstmt.setString(1, "%" + query + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sVo = new StoreVO();
				
				sVo.setStore_photo1(rs.getString("store_photo1"));
				sVo.setStore_name(rs.getString("store_name"));
				sVo.setStore_type(rs.getString("store_type"));
				sVo.setStore_addr(rs.getString("store_addr"));
				
				list.add(sVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// Read (select) - 특정 업체 상세 조회
	public StoreVO StoreDetail(String store_name) { 
		String sql_select = "select * from store_info where store_name=?";
		
		
		int result = -1;
		StoreVO sVo = new StoreVO();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, store_name);
			rs = pstmt.executeQuery();
			
			//상품 정보 획득
			rs.next();
			sVo.setStore_photo1(rs.getString("store_photo1"));
			sVo.setStore_photo2(rs.getString("store_photo2"));
			sVo.setStore_photo3(rs.getString("store_photo3"));
			sVo.setStore_name(rs.getString("store_name"));
			sVo.setStore_type(rs.getString("store_type"));
			sVo.setStore_time(rs.getString("store_time"));
			sVo.setStore_time_w(rs.getString("store_time_w"));
			sVo.setStore_addr(rs.getString("store_addr"));
			sVo.setStore_addr_detail(rs.getString("store_addr_detail"));
			sVo.setStore_tel(rs.getString("store_tel"));
			sVo.setMenu_info(rs.getString("menu_info"));
			sVo.setParking(rs.getString("parking"));
			sVo.setParking_detail(rs.getString("parking_detail"));
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return sVo;
	}
}
