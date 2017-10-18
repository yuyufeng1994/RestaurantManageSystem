package com.fbm.dao;

import java.util.List;

import com.fbm.vo.Salary;
import com.fbm.web.Page;

public interface SalaryDao {
	// 通过id查找用户
	Salary findById(Long id);

	// 通过id查找用户
	Salary findByUserId(String userId);

	// 更新
	void update(Salary salary);

	// 删除
	void delete(Long id);

	// 增加
	Long add(Salary salary);

	// 得到所以用户列表
	List<Salary> getList();

	// 得到总的用户数量
	long getTotalSalaryNumber();

	// 得到某页的用户列表
	List<Salary> getPageList(int n, int pageSize);

	// 得到某页
	Page<Salary> getPage(int n);
}
