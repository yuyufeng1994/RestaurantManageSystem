package com.fbm.dao.impl;

import java.util.List;

import com.fbm.base.BaseDAOImpl;
import com.fbm.dao.DishDao;
import com.fbm.vo.Dish;
import com.fbm.web.Page;

public class DishDaoImpl extends BaseDAOImpl<Dish> implements DishDao {

	@Override
	public Dish findById(Long id) {
		String sql = "select id,name,type_id,price,picture,sale,stock,description from dish where id = ?";
		return query(sql, id);
	}

	@Override
	public Dish findByName(String name) {
		String sql = "select id,name,type_id,price,picture,sale,stock,description from dish where name = ?";
		return query(sql, name);
	}

	@Override
	public void update(Dish dish) {
		String sql = "update dish set name=?,type_id=?,price=?,picture=?,sale=?,stock=?,description=? "
				+ "where id = ?";
		update(sql, dish.getName(), dish.getType_id(), dish.getPrice(),
				dish.getPicture(), dish.getSale(), dish.getStock(),
				dish.getDescription(), dish.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from dish where id = ?";
		update(sql, id);
	}

	@Override
	public Long add(Dish dish) {
		String sql = "insert into dish(name,type_id,price,picture,sale,stock,description) "
				+ "values(?,?,?,?,?,?,?)";
		Long id = insert(sql, dish.getName(), dish.getType_id(),
				dish.getPrice(), dish.getPicture(), dish.getSale(),
				dish.getStock(), dish.getDescription());
		return id;
	}

	@Override
	public List<Dish> getList() {
		String sql = "SELECT id,name,type_id,price,picture,sale,stock,description "
				+ "FROM dish";
		return queryForList(sql);
	}

	@Override
	public long getTotalStudentNumber(String likeStr) {
		String sql = null;
		if ("".equals(likeStr) || likeStr == null) {
			sql = "SELECT count(id) FROM dish";
		} else {
			sql = "SELECT count(id) "
					+ "FROM dish where name like '%"
					+ likeStr
					+ "%' or type_id like '%"
					+ likeStr+ "%'";
					
		}

		return getSingleVal(sql);
	}

	@Override
	public List<Dish> getPageList(int n, int pageSize, String condition,
			String likeStr) {
		String sql = null;
		if ("".equals(likeStr) || likeStr == null) {
			sql = "SELECT id,name,type_id,price,picture,sale,stock,description "
					+ "FROM dish order by " + condition + " LIMIT ?, ?";
		} else {
			sql = "SELECT id,name,type_id,price,picture,sale,stock,description "
					+ "FROM dish where name like '%"
					+ likeStr
					+ "%' or type_id like '%"
					+ likeStr+ "%' order by "
					+ condition + " LIMIT ?, ?";
		}
		return queryForList(sql, (n - 1) * pageSize, pageSize);
	}

	@Override
	public Page<Dish> getPage(int n, String condition, String likeStr) {
		
		Page<Dish> page = new Page<Dish>(n);
		page.setTotalItemNumber(getTotalStudentNumber(likeStr));
		// 校验 pageNo 的合法性
		n = page.getPageNo();
	//	if (page.getTotalPageNumber() != 0) {
			page.setList(getPageList(n, 10, condition, likeStr));
	//	}

		return page;
	}

	@Override
	public List<Dish> getListByName(String keyword) {
		String sql = "SELECT id,name,type_id,price,picture,sale,stock,description "
				+ "FROM dish where name like ?";
		return queryForList(sql,"%"+keyword+"%");
	}

}
