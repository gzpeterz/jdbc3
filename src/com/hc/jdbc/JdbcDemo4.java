package com.hc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo4 {

	public static void main(String[] args) {
		JdbcDemo4 jdbc = new JdbcDemo4();
		// jdbc.showUserByName("tiger");
		// jdbc.showUserByName("aaa' or '1'='1");
		// jdbc.showUserByName2("tiger");
		jdbc.showUserByName2("aaa' or '1'='1");
	}

	public void showUserByName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from user where username = '" + name + "'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}
		System.out.println("查询结束了 ！");
	}
	
	public void showUserByName2(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from user where username = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pstmt, rs);
		}
	}
}
