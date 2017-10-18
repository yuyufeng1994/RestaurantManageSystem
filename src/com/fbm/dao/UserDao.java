package com.fbm.dao;

import java.util.List;

import com.fbm.vo.User;
import com.fbm.web.Page;

public interface UserDao {

	// 通过id查找用户
	User findById(Long id);

	// 通过id查找用户
	User findByName(String name);

	// 更新
	void update(User user);

	// 删除
	void delete(Long id);

	// 增加
	Long add(User user);
	
	//得到所以用户列表
	List<User> getList();

	// ===============为分页做准备 如有需要需写上===================

	// 得到总的用户数量
	long getTotalStudentNumber();

	// 得到某页的用户列表
	List<User> getPageList(int n, int pageSize);

	// 得到某页
	Page<User> getPage(int n);
	
	

}
