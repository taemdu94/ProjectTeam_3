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
//싱글톤 적용
	private StoreDAO() {
	}

	private static StoreDAO instance = new StoreDAO();

	public static StoreDAO getInstance() {
		return instance;
	}

	// 업체 검색 조회(list)
	public List<StoreVO> searchStore(StoreVO store) {
		String sql_search = "SELECT store_name, store_photo1, store_addr, store_type FROM store_info WHERE store_name LIKE ?";
		
		int result = -1;
		List<StoreVO> list = new ArrayList<StoreVO>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		//load, Connection
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql_search);
			pstmt.setString(1, "%"+store.getStore_name()+"%");
			rs = pstmt.executeQuery();
			
			store = null;
			
			//상품 정보 획득
			while(rs.next()) {
				StoreVO sVo = new StoreVO();
				
				sVo.setStore_photo1(rs.getString("store_photo1")); //담을 때 set
				sVo.setStore_name(rs.getString("store_name"));
				sVo.setStore_type(rs.getString("store_type"));
				sVo.setStore_addr(rs.getString("store_addr"));
				
				list.add(sVo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
	}

}
