package com.hc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcHello {

	public static void main(String[] args) throws Exception {
		// 1.注册驱动
		// Class.forName("com.mysql.jdbc.Driver");
		// 2. 连接数据库
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://10.0.13.200/jdbc?useSSL=false", "root", "root123");
		// 3.创建Statement对象
		Statement stmt = conn.createStatement();
		// 4.执行SQL语句并且遍历查询结果
		String sql = "select * from user";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("username"));
		}
		// 5.关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
