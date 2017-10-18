package com.fbm.dao.impl;

import java.util.List;
import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.UserDao;
import com.fbm.vo.User;
import com.fbm.web.Page;
public class UserDaoImpl extends BaseDAOImpl<User> implements UserDao {
	
	public User findById(Long id) {
		String sql = "select id,name,password,type,tell from user where id = ?";
		return query(sql, id);
	}

	@Override
	public User findByName(String name) {
		String sql = "select id,name,password,type,tell from user where name = ?";
		return query(sql, name);
	}

	@Override
	public void update(User user) {
		String sql = "update user set name=?,password=?,type=?,tell=? where id = ?";
		update(sql, user.getName(), user.getPassword(), user.getType(),
				user.getTell(), user.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from user where id = ?";
		update(sql, id);

	}

	@Override
	public Long add(User user) {
		String sql = "insert into user(name,password,type,tell) "
				+ "values(?,?,?,?)";
		Long id = insert(sql, user.getName(), user.getPassword(),
				user.getType(), user.getTell());
		return id;

	}

	@Override
	public List<User> getList() {
		String sql = "SELECT id,name,password,type,tell " + "FROM user";
		return queryForList(sql);
	}

	@Override
	public long getTotalStudentNumber() {
		String sql = "SELECT count(id) FROM user";
		return getSingleVal(sql);
	}

	@Override
	public List<User> getPageList(int n, int pageSize) {
		String sql = "SELECT id,name,password,type,tell "
				+ "FROM user order by id desc LIMIT ?, ?";
		return queryForList(sql, (n - 1) * pageSize, pageSize);
	}

	@Override
	public Page<User> getPage(int n) {
		Page<User> page = new Page<User>(n);
		page.setTotalItemNumber(getTotalStudentNumber());
		// 校验 pageNo 的合法性
		n = page.getPageNo();
		page.setList(getPageList(n, 10));
		return page;
	}
}
