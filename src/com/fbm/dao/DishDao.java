package com.fbm.dao;

import java.util.List;

import com.fbm.vo.Dish;
import com.fbm.web.Page;

public interface DishDao {
	// 通过id查找用户
	Dish findById(Long id);

	// 通过id查找用户
	Dish findByName(String name);

	// 更新
	void update(Dish dish);

	// 删除
	void delete(Long id);

	// 增加
	Long add(Dish dish);

	// 得到所以用户列表
	List<Dish> getList();
	
	// ===============为分页做准备 如有需要需写上===================

	// 得到总的用户数量
	long getTotalStudentNumber(String likeStr);

	/**
	 * 根据条件得到相应的list
	 */
	// 得到某页的菜单列表
	List<Dish> getPageList(int n, int pageSize, String condition,String likeStr);

	// 得到某页 id desc asc
	Page<Dish> getPage(int n, String condition,String likeStr);

	List<Dish> getListByName(String keyword);

}
