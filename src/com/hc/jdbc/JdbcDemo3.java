package com.hc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo3 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			// 4.执行SQL语句并且遍历查询结果
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("username"));
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt, rs);
		}
		System.out.println("at end of jdbc");
	}

	@Test
	public void testAdd() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into user values(null, 'whale', 'www123') ";
			int num = stmt.executeUpdate(sql);
			System.out.println("num is " + num);
			if (num == 1) {
				System.out.println("数据插入成功 ！");
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, stmt);
		}
	}
}
