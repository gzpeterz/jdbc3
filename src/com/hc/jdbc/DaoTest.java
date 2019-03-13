package com.hc.jdbc;

import com.hc.dao.UserDao;
import com.hc.dao.impl.UserDaoImpl;
import com.hc.javabean.User;

public class DaoTest {

	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		User user = dao.selectById(1);
		System.out.println(user);
		
		User u2 = new User();
		u2.setUsername("student");
		u2.setPassword("123456");
		boolean ret = dao.insert(u2);
		System.out.println(ret);
	}

}
