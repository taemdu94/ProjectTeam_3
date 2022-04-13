package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ora_user","1234");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//select
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	//insert, update, delete
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
