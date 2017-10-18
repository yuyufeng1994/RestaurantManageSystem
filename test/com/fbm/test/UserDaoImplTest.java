package com.fbm.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fbm.dao.UserDao;
import com.fbm.dao.impl.RoleDaoImpl;
import com.fbm.dao.impl.UserDaoImpl;
import com.fbm.vo.User;

public class UserDaoImplTest {

	UserDao userDao = new UserDaoImpl();
	RoleDaoImpl roleDaoImpl =new RoleDaoImpl();
	@Test
	public void testFindById() {
		System.out.println(userDao.findById(1l));
	}

	@Test
	public void testFindByName() {
		System.out.println(userDao.findByName("yyf"));
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId(1l);
		user.setName("yyf");
		user.setPassword("12345");
		user.setTell("13574472507");
		user.setType(2);
		userDao.update(user);
		System.out.println(userDao.findById(1l));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
	//	for (int i = 0; i < 125; i++) {
			User user = new User();
			user.setName("testName");
			user.setPassword("12345");
			user.setTell("13574472507");
			user.setType(2);
			System.out.println(userDao.add(user));
		//}

	}

	@Test
	public void testGetTotalStudentNumber() {
		System.out.println(userDao.getTotalStudentNumber());
	}

	@Test
	public void testGetPageList() {
		System.out.println(userDao.getPageList(4, 10));
	}

	@Test
	public void testGetList() {
		System.out.println(userDao.getList());
	}

	@Test
	public void testGetPage() {
		System.out.println(userDao.getPage(0));
	}
	@Test
	public void test(){
		//roleDaoImpl.findById(1);
		System.out.println(roleDaoImpl.getList());
	}

}
