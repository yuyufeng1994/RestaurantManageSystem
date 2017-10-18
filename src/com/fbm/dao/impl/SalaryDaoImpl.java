package com.fbm.dao.impl;

import java.util.List;

import com.fbm.base.BaseDAOImpl;

import com.fbm.dao.SalaryDao;

import com.fbm.vo.Salary;
import com.fbm.web.Page;

public class SalaryDaoImpl extends BaseDAOImpl<Salary> implements SalaryDao {
	@Override
	public Salary findById(Long id) {
		String sql = "select id,userId,salary,date from Salary where id = ?";
		return query(sql, id);
	}

	@Override
	public Salary findByUserId(String userId) {
		String sql = "select id,userId,salary,date from Salary where userId = ?";
		return query(sql, userId);
	}

	@Override
	public void update(Salary salary) {
		String sql = "update salary set userId=?,salary=?,date=? where id = ?";
		update(sql, salary.getUserId(), salary.getSalary(), salary.getDate(),
				salary.getId());

	}

	@Override
	public void delete(Long id) {
		String sql = "delete from salary where id = ?";
		update(sql, id);
	}

	@Override
	public Long add(Salary salary) {
		String sql = "insert into salary(userId,salary,date) "
				+ "values(?,?,?)";
		Long id = insert(sql, salary.getUserId(), salary.getSalary(),
				salary.getDate());
		return id;
	}

	@Override
	public List<Salary> getList() {
		String sql = "select id,userId,salary,date from Salary";
		return queryForList(sql);
	}

	@Override
	public long getTotalSalaryNumber() {
		String sql = "SELECT count(id) FROM Salary";
		return getSingleVal(sql);
	}

	@Override
	public List<Salary> getPageList(int n, int pageSize) {
		String sql = "SELECT id,userId,salary,date from Salary order by id desc LIMIT ?, ?";
		return queryForList(sql, (n - 1) * pageSize, pageSize);
	}

	@Override
	public Page<Salary> getPage(int n) {
		Page<Salary> page = new Page<Salary>(n);
		page.setTotalItemNumber(getTotalSalaryNumber());
		// 校验 pageNo 的合法性
		n = page.getPageNo();
		page.setList(getPageList(n, 10));
		return page;
	}

}
