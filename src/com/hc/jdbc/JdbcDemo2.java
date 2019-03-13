package com.hc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 连接数据库
			conn = DriverManager.getConnection("jdbc:mysql://10.0.13.200/jdbc?useSSL=false", "root", "root123");
			// 3.创建Statement对象
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
			// 5.关闭资源
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
		System.out.println("at end of jdbc");
	}
}
