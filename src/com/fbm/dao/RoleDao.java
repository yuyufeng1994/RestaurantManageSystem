package com.fbm.dao;

import java.util.List;

import com.fbm.vo.Role;


public interface RoleDao {
	// 通过id查找用户
		Role findById(Integer id);
		
		//得到所以用户列表
		List<Role> getList();

}
