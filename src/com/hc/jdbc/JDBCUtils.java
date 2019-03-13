package com.hc.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtils {
	
	private static final String URL ;
	private static final String USER ;
	private static final String PASSWORD ;
	private static final String DRIVER ;
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(JDBCUtils.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = prop.getProperty("jdbc.driver");
		URL = prop.getProperty("jdbc.url");
		USER = prop.getProperty("jdbc.username");
		PASSWORD = prop.getProperty("jdbc.password");
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
}
