package com.fbm.service.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.fbm.dao.RoleDao;
import com.fbm.dao.UserDao;
import com.fbm.dao.impl.RoleDaoImpl;
import com.fbm.dao.impl.UserDaoImpl;
import com.fbm.service.UserService;
import com.fbm.util.MD5Util;
import com.fbm.vo.Role;
import com.fbm.vo.User;
import com.fbm.web.Page;
import com.fbm.web.SalaryOpe;

public class UserServiceImpl implements UserService {
	UserDao userdao = new UserDaoImpl();
	RoleDao roleDao = new RoleDaoImpl();

	@Override
	public User getUserById(Long id) {
		User user = userdao.findById(id);
		user.setRole(roleDao.findById(user.getType()));
		return user;
	}

	@Override
	public Page<User> getPage(int pageNum) {
		Page<User> page = userdao.getPage(pageNum);
		for (User u : page.getList()) {
			u.setRole(roleDao.findById(u.getType()));
		}
		return page;
	}

	@Override
	public User edit(Long id, String password) {
		User user = userdao.findById(id);
		user.setPassword(password);
		userdao.update(user);
		return userdao.findById(id);
	}

	@Override
	public void delUser(Long id) {
		userdao.delete(id);
	}

	@Override
	public List<Role> getRoleList() {
		return roleDao.getList();
	}

	@Override
	public void addUser(String name, Integer type, String tell) {
		User user = new User();
		user.setName(name);
		user.setPassword(MD5Util.string2MD5("12345"));
		user.setTell(tell);
		user.setType(type);
		userdao.add(user );
		
	}

	@Override
	public void editUser(Long id, String name, Integer type, String tell) {
		User user = userdao.findById(id);
		user.setType(type);
		user.setName(name);
		user.setTell(tell);
		userdao.update(user);
	}

	@Override
	public void editUserForPassword(Long id) {
		User user = userdao.findById(id);
		user.setPassword(MD5Util.string2MD5("12345"));
		userdao.update(user);
	}

	@Override
	public List<User> getUserList() {
		return userdao.getList();
	}

	@Override
	public boolean checkUserPassword(Long id, String password) {
		User user = userdao.findById(id);
		if(user == null){
			return false;
		}
		if(user.getPassword().equals(MD5Util.string2MD5(password))){
			return true;
		}
		return false;
	}

	@Override
	public SalaryOpe getSalaryOpe(String date, Integer pageNo) {
		//2015-06-01;
		String yearStr = date.substring(0,4);
		String monStr = date.substring(5,7);
		
		
		int year= Integer.parseInt(yearStr);
		int mon = Integer.parseInt(monStr);
		Calendar ca = Calendar.getInstance(); 

		ca.set(Calendar.YEAR, year); 

		ca.set(Calendar.MONTH, mon-1); 

		ca.set(Calendar.DAY_OF_MONTH, 1); 

		ca.set(Calendar.HOUR_OF_DAY, 0); 

		ca.set(Calendar.MINUTE,0); 

		ca.set(Calendar.SECOND, 0); 

		java.util.Date date1 = ca.getTime(); 
		
		ca.set(Calendar.YEAR, 2015); 
		ca.set(Calendar.DAY_OF_MONTH, 30); 
		java.util.Date date2 = ca.getTime(); 
		SalaryOpe salaryOpe = new SalaryOpe(pageNo,new Date(date1.getTime()),new Date(date2.getTime()));
		
		return salaryOpe;
	}	
}
