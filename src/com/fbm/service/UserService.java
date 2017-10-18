package com.fbm.service;

import java.util.List;

import com.fbm.vo.Role;
import com.fbm.vo.User;
import com.fbm.web.Page;
import com.fbm.web.SalaryOpe;

public interface UserService {
	User getUserById(Long id);

	Page<User> getPage(int pageNum);

	User edit(Long id, String password);

	void delUser(Long id);

	List<Role> getRoleList();

	void addUser(String name, Integer type, String tell);

	void editUser(Long id, String name, Integer type, String tell);

	void editUserForPassword(Long id);

	List<User> getUserList();

	boolean checkUserPassword(Long id, String password);
	
	SalaryOpe getSalaryOpe(String date,Integer pageNo);
	
}
