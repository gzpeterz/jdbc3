package com.hc.dao;

import com.hc.javabean.User;

public interface UserDao {
	User selectById(int id);
	boolean insert(User user);
	boolean update(User user);
	boolean delete(int id);
}
