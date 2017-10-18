package com.fbm.dao.impl;

import java.util.List;


import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.RoleDao;
import com.fbm.vo.Role;

public class RoleDaoImpl extends BaseDAOImpl<Role> implements RoleDao {

	@Override
	public Role findById(Integer id) {
		String sql = "select id,name from roles where id = ?";
		return query(sql, id);
	}

	@Override
	public List<Role> getList() {
		String sql = "SELECT id,name " + "FROM roles";
		return queryForList(sql);
	}

}
