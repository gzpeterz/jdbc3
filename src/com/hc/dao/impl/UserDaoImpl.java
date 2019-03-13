package com.hc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hc.dao.UserDao;
import com.hc.javabean.User;
import com.hc.jdbc.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectById(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from user where id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pst, rs);
		}
		return user;
	}

	@Override
	public boolean insert(User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into user values(null, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			int ret = pst.executeUpdate();
			if (ret == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("发生异常了");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pst);
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
