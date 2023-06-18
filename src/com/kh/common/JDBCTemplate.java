package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public static Connection getConnection() {
		
		
		Connection conn = null;
		Properties prop = new Properties();
		
		// 읽어들이고자하는 파일의 물리적인 경로(경로를 알아내는 방법)
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		// System.out.println(fileName);
		// 클래스파일을 기준으로 삼겠다->리소스를 가져오겠다("경로")-> 기준(WEB-INF에 있는 classes기준-최상위 폴더) "/" 이 표시는 최상위
		// -> getPath() : 파일 경로 가져오기
		try {
		
			prop.load(new FileInputStream(fileName));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
											   prop.getProperty("username"),
											   prop.getProperty("password"));
												
			conn.setAutoCommit(false); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2_2) 전달받은 Connection객체를 가지고 ROLLBACK 시켜주는 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 3. JDBC용 객체를 반납시켜주는 메소드(각 객체별로)
	// 3-1) Connection객체를 전달받아서 반납시켜주는 메소드(오버로딩)
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3_2) Statement객체를 전달받아서 반납시켜주는 메소드(오버로딩)
	// => 다형성 적용으로 인해 PreparedStatement 객체도 Statement타입으로 받을 수 있음
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3_3) ResultSet객체를 전달받아서 반납시켜주는 메소드(오버로딩)
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
